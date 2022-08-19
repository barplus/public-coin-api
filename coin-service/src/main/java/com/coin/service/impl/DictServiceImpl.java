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
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(DictReq req) throws Exception {
        TDict oldDict = this.getByTypeAndCode(req.getDictType(), req.getDictCode());
        if(oldDict != null){
            throw new BizException(CodeCons.ERROR, "重复的数据，请修改类型或编码");
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
                throw new BizException(CodeCons.ERROR, "状态值错误");
            }
            dict.setStatus(req.getStatus());
        }
        if(req.getIsDefault() != null){
            if(req.getIsDefault().intValue() !=0 && req.getIsDefault().intValue() !=1){
                throw new BizException(CodeCons.ERROR, "默认值错误");
            }
            dict.setIsDefault(req.getIsDefault());
        }
        if(req.getSortNum() != null){
            dict.setSortNum(req.getSortNum());
        }
        int count = tDictMapper.updateByPrimaryKeySelective(dict);
        if(count > 0 && req.getIsDefault() != null && req.getIsDefault().intValue() == 1){
            TDict oldDict = tDictMapper.selectByPrimaryKey(req.getId());
            this.clearDefault(oldDict.getDictType(), oldDict.getId(), req.getLoginName());
        }
    }

    /**
     * 清除指定类型的字典当前默认项
     * @param dictType 类型
     * @param excludeId 需要排除的id
     * @param updateUser 修改人
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
