package com.coin.service.impl;

import com.coin.entity.TSysDomain;
import com.coin.entity.TSysDomainExample;
import com.coin.mapper.TSysDomainMapper;
import com.coin.req.SysDomainReq;
import com.coin.service.SysDomainService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysDomainServiceImpl implements SysDomainService {

    @Resource
    private TSysDomainMapper tSysDomainMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createBatch(SysDomainReq req) throws Exception {
        if(req.getNum() > 100){
            throw new BizException(CodeCons.ERROR, "单次批量生成数量不能超过100个");
        }
        int startNum = 1;
        List<TSysDomain> existInfos = this.getListBySysName(req.getSysName(), " id desc");
        if(!CollectionUtils.isEmpty(existInfos)){
            startNum = Integer.parseInt(StrUtil.getUrlParamVal(existInfos.get(0).getDomainUrl(), "code"))+1;
        }
        TSysDomain sysDomain = BizUtil.getInsertInfo(new TSysDomain(), req.getLoginName(), new Date());
        sysDomain.setSysName(req.getSysName());
        if(StringUtils.isNotBlank(req.getBelongUser())){
            sysDomain.setBelongUser(req.getBelongUser());
        }
        sysDomain.setRemark(req.getRemark());
        sysDomain.setStatus(req.getStatus());
        for(int i=startNum; i<startNum+req.getNum(); i++){
            String paramStr = req.getDomainUrl().indexOf("?") != -1?"&code="+i:"?code="+i;
            sysDomain.setDomainUrl(req.getDomainUrl() + paramStr);
            tSysDomainMapper.insertSelective(sysDomain);
        }
    }

    @Override
    public void update(SysDomainReq req) throws Exception {
        TSysDomain updateDomain = BizUtil.getUpdateInfo(new TSysDomain(), req.getId(), req.getLoginName(), new Date());
        if(StringUtils.isNotBlank(req.getBelongUser())){
            updateDomain.setBelongUser(req.getBelongUser());
        }
        updateDomain.setRemark(req.getRemark());
        updateDomain.setStatus(req.getStatus());
        tSysDomainMapper.updateByPrimaryKeySelective(updateDomain);
    }

    @Override
    public PageInfo<TSysDomain> pageList(SysDomainReq req) throws Exception {
        TSysDomainExample example = new TSysDomainExample();
        TSysDomainExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getSysName())){
            criteria.andSysNameEqualTo(req.getSysName());
        }
        if(StringUtils.isNotBlank(req.getBelongUser())){
            criteria.andBelongUserEqualTo(req.getBelongUser());
        }
        if(req.getIsUsed() != null){
            if(req.getIsUsed() == 1){
                criteria.andBelongUserIsNotNull();
            }
            if(req.getIsUsed() == 0){
                criteria.andBelongUserIsNull();
            }
        }
        example.setOrderByClause(" id desc");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TSysDomain> domains = tSysDomainMapper.selectByExample(example);
        PageInfo<TSysDomain> page = new PageInfo<>(domains);
        return page;
    }

    @Override
    public List<TSysDomain> getListBySysName(String SysName, String orderBy) throws Exception {
        TSysDomainExample example = new TSysDomainExample();
        example.createCriteria().andSysNameEqualTo(SysName);
        if(StringUtils.isNotBlank(orderBy)){
            example.setOrderByClause(orderBy);
        }
        List<TSysDomain> list = tSysDomainMapper.selectByExample(example);
        return list;
    }

}
