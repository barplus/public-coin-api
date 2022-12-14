package com.coin.service.impl;

import com.coin.entity.TContestSponsorshipLogo;
import com.coin.entity.TDict;
import com.coin.entity.TDictExample;
import com.coin.mapper.TDictMapper;
import com.coin.req.ContestConfigReq;
import com.coin.req.DictReq;
import com.coin.rsp.ContestConfigRsp;
import com.coin.service.ContestSponsorshipLogoService;
import com.coin.service.DictService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    private static final Logger logger = LoggerFactory.getLogger(DictServiceImpl.class);

    @Resource
    private TDictMapper tDictMapper;
    @Resource
    private ContestSponsorshipLogoService contestSponsorshipLogoService;

    @Override
    public List<TDict> getListByType(DictReq dictReq) throws Exception {
        TDictExample example = new TDictExample();
        TDictExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(dictReq.getDictType())){
            criteria.andDictTypeEqualTo(dictReq.getDictType());
        }
        if(dictReq.getStatus() != null){
            criteria.andStatusEqualTo(dictReq.getStatus());
        }
        if(dictReq.getOnlySortNum() != null && dictReq.getOnlySortNum().intValue() == 1){
            example.setOrderByClause(" sort_num");
        } else {
            example.setOrderByClause(" status desc, is_default desc, sort_num");
        }
        return tDictMapper.selectByExample(example);
    }

    @Override
    public TDict getById(Integer id) throws Exception {
        return tDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public TDict getDefaultByType(String dictType) throws Exception {
        TDictExample example = new TDictExample();
        example.createCriteria().andDictTypeEqualTo(dictType).andIsDefaultEqualTo(1).andStatusEqualTo(1);
        List<TDict> list = tDictMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public TDict getByTypeAndCode(String dictType, String dictCode) throws Exception {
        TDictExample example = new TDictExample();
        example.createCriteria().andDictTypeEqualTo(dictType).andDictCodeEqualTo(dictCode);
        List<TDict> list = tDictMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public String getValByTypeAndCode(String dictType, String dictCode) throws Exception {
        TDict dict = this.getByTypeAndCode(dictType, dictCode);
        return dict.getDictVal();
    }

    @Override
    public ContestConfigRsp getContestConfig() throws Exception {
        ContestConfigRsp rsp = new ContestConfigRsp();
        TDict dict = this.getByTypeAndCode("CONTEST_CONFIG", "TOP_LOGO_LINK");
        rsp.setTopLogoLink(dict.getDictVal());
        dict = this.getByTypeAndCode("CONTEST_CONFIG", "SPONSORSHIP_LOGO_LINK");
        rsp.setSponsorshipLogoLink(dict.getDictVal());
        dict = this.getByTypeAndCode("CONTEST_CONFIG", "BRAND_EXPLAIN");
        rsp.setBrandExplain(dict.getDictValBig());
        dict = this.getByTypeAndCode("CONTEST_CONFIG", "SHARE_LINK");
        rsp.setShareLink(dict.getDictVal());
        dict = this.getByTypeAndCode("CONTEST_CONFIG", "REGISTER_LINK");
        rsp.setRegisterLink(dict.getDictVal());
        List<TContestSponsorshipLogo> list = contestSponsorshipLogoService.getAllList();
        rsp.setContestSponsorshipLogos(list);
        return rsp;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(DictReq req) throws Exception {
        TDict oldDict = this.getByTypeAndCode(req.getDictType(), req.getDictCode());
        if(oldDict != null){
            throw new BizException(CodeCons.ERROR, "??????????????????????????????????????????");
        }
        if(req.getIsDefault().intValue() == 1){
            this.clearDefault(req.getDictType(), null, req.getLoginName());
        }
        TDict dict = BizUtil.getInsertInfo(new TDict(), req.getLoginName(), new Date());
        dict.setDictType(req.getDictType());
        dict.setDictCode(req.getDictCode());
        dict.setDictName(req.getDictName());
        dict.setDictVal(req.getDictVal());
        dict.setDictValBig(req.getDictValBig());
        dict.setParentDictCode(req.getParentDictCode());
        dict.setSortNum(req.getSortNum());
        dict.setIsDefault(req.getIsDefault());
        dict.setStatus(req.getStatus());
        tDictMapper.insertSelective(dict);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(DictReq req) throws Exception {
        TDict dict = BizUtil.getUpdateInfo(new TDict(), req.getId(), req.getLoginName(), new Date());
        if(req.getStatus() != null){
            if(req.getStatus().intValue() !=0 && req.getStatus().intValue() !=1){
                throw new BizException(CodeCons.ERROR, "???????????????");
            }
            dict.setStatus(req.getStatus());
        }
        if(req.getIsDefault() != null){
            if(req.getIsDefault().intValue() !=0 && req.getIsDefault().intValue() !=1){
                throw new BizException(CodeCons.ERROR, "???????????????");
            }
            dict.setIsDefault(req.getIsDefault());
        }
        if(req.getSortNum() != null){
            dict.setSortNum(req.getSortNum());
        }
        if(StringUtils.isNotBlank(req.getDictVal())){
            dict.setDictVal(req.getDictVal());
        }
        if(StringUtils.isNotBlank(req.getDictValBig())){
            dict.setDictValBig(req.getDictValBig());
        }
        logger.info("dict-service-update, dict={}", dict);
        int count = tDictMapper.updateByPrimaryKeySelective(dict);
        if(count > 0 && req.getIsDefault() != null && req.getIsDefault().intValue() == 1){
            TDict oldDict = tDictMapper.selectByPrimaryKey(req.getId());
            this.clearDefault(oldDict.getDictType(), oldDict.getId(), req.getLoginName());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        TDict dict = tDictMapper.selectByPrimaryKey(id);
        if("CONTEST_TAG".equals(dict.getDictType())){
            tDictMapper.deleteByPrimaryKey(id);
        } if("CONTEST_NAME".equals(dict.getDictType())){
            tDictMapper.deleteByPrimaryKey(id);
        } else {
            throw new BizException(CodeCons.ERROR, "????????????????????????");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveContestConfig(ContestConfigReq req) throws Exception{
        Date now = new Date();
        this.updateDict("TOP_LOGO_LINK", req.getLoginName(), now, req.getTopLogoLink(), false);
        this.updateDict("SPONSORSHIP_LOGO_LINK", req.getLoginName(), now, req.getSponsorshipLogoLink(), false);
        this.updateDict("BRAND_EXPLAIN", req.getLoginName(), now, req.getBrandExplain(), true);
        this.updateDict("REGISTER_LINK", req.getLoginName(), now, req.getRegisterLink(), false);
        this.updateDict("SHARE_LINK", req.getLoginName(), now, req.getShareLink(), false);
    }

    private void updateDict(String dictCode, String updateUser, Date now, String val, boolean isBigVal) throws Exception {
        TDict dict = this.getByTypeAndCode("CONTEST_CONFIG", dictCode);
        TDict updateDict = BizUtil.getUpdateInfo(new TDict(), dict.getId(), updateUser, now);
        if(isBigVal){
            updateDict.setDictValBig(val);
        } else {
            updateDict.setDictVal(val);
        }
        tDictMapper.updateByPrimaryKeySelective(updateDict);
    }

    /**
     * ??????????????????????????????????????????
     * @param dictType ??????
     * @param excludeId ???????????????id
     * @param updateUser ?????????
     */
    private void clearDefault(String dictType, Integer excludeId, String updateUser){
        TDictExample example = new TDictExample();
        TDictExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeEqualTo(dictType);
        criteria.andIsDefaultEqualTo(1);
        if(excludeId != null){
            criteria.andIdNotEqualTo(excludeId);
        }
        List<TDict> list = tDictMapper.selectByExample(example);
        for(TDict dict:list){
            TDict updateDict = BizUtil.getUpdateInfo(new TDict(), dict.getId(), updateUser, new Date());
            updateDict.setIsDefault(0);
            tDictMapper.updateByPrimaryKeySelective(updateDict);
        }
    }

}
