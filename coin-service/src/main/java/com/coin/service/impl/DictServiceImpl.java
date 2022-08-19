package com.coin.service.impl;

import com.coin.entity.TDict;
import com.coin.entity.TDictExample;
import com.coin.mapper.TDictMapper;
import com.coin.mapper.ext.DictMapper;
import com.coin.req.DictReq;
import com.coin.service.DictService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictMapper dictMapper;
    @Resource
    private TDictMapper tDictMapper;

    @Override
    public List<TDict> getListByType(DictReq dictReq) throws Exception {
        TDictExample example = new TDictExample();
        TDictExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(dictReq.getDictType())){
            criteria.andDictTypeEqualTo(dictReq.getDictType());
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(DictReq req) throws Exception {
        TDict oldDict = dictMapper.getByTypeAndCode(req.getDictType(), req.getDictCode());
        if(oldDict != null){
            throw new BizException(CodeCons.ERROR, "重复的数据，请修改类型或编码");
        }
        TDict defaultDict = null;
        if(req.getIsDefault() != null && req.getIsDefault().intValue() == 1){
            DictReq req1 = new DictReq();
            req1.setDictType(req.getDictType());
            List<TDict> list = dictMapper.getListByType(req1);
            for(TDict dict:list){
                if(dict.getIsDefault().intValue() == 1){
                    defaultDict = dict;
                    break;
                }
            }
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
        if(defaultDict != null){
            TDict updateDict = BizUtil.getUpdateInfo(new TDict(), defaultDict.getId(), req.getLoginName(), new Date());
            updateDict.setIsDefault(0);
            tDictMapper.updateByPrimaryKeySelective(updateDict);
        }
    }

    @Override
    public void update(DictReq req) throws Exception {
        TDict dict = BizUtil.getUpdateInfo(new TDict(), req.getId(), req.getLoginName(), new Date());
        if(req.getStatus() != null){
            if(req.getStatus().intValue() !=0 && req.getStatus().intValue() !=1){
                throw new BizException(CodeCons.ERROR, "状态值错误");
            }
            dict.setStatus(req.getStatus());
        }
        TDict defaultDict = null;
        if(req.getIsDefault() != null){
            if(req.getIsDefault().intValue() !=0 && req.getIsDefault().intValue() !=1){
                throw new BizException(CodeCons.ERROR, "默认值错误");
            }
            dict.setIsDefault(req.getIsDefault());
            if(req.getIsDefault().intValue() == 1){
                DictReq req1 = new DictReq();
                req1.setDictType(req.getDictType());
                List<TDict> list = dictMapper.getListByType(req1);
                for(TDict dict1:list){
                    if(dict1.getIsDefault().intValue() == 1 && dict1.getId().intValue() != req.getId()){
                        defaultDict = dict;
                        break;
                    }
                }
            }
        }
        int count = tDictMapper.updateByPrimaryKeySelective(dict);
        if(count > 0 && defaultDict != null){
            TDict updateDict = BizUtil.getUpdateInfo(new TDict(), defaultDict.getId(), req.getLoginName(), new Date());
            updateDict.setIsDefault(0);
            tDictMapper.updateByPrimaryKeySelective(updateDict);
        }
    }

}
