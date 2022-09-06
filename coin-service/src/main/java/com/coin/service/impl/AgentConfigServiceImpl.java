package com.coin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.coin.entity.TAgentPageConfig;
import com.coin.entity.TAgentPageConfigExample;
import com.coin.entity.TDict;
import com.coin.mapper.TAgentPageConfigMapper;
import com.coin.mapper.ext.AgentPageConfigMapper;
import com.coin.req.AgentConfigReq;
import com.coin.req.DictReq;
import com.coin.rsp.AgentConfigRsp;
import com.coin.service.AgentConfigService;
import com.coin.service.DictService;
import com.coin.service.SysLogService;
import com.coin.service.constant.CodeCons;
import com.coin.service.enums.LogTypeEnum;
import com.coin.service.exception.BizException;
import com.coin.service.util.BizUtil;
import com.coin.service.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentConfigServiceImpl implements AgentConfigService {

    private static final Logger logger = LoggerFactory.getLogger(AgentConfigServiceImpl.class);

    @Resource
    private TAgentPageConfigMapper tAgentPageConfigMapper;
    @Resource
    private AgentPageConfigMapper agentPageConfigMapper;
    @Resource
    private SysLogService sysLogService;
    @Resource
    private DictService dictService;

    @Override
    public PageInfo<AgentConfigRsp> pageList(AgentConfigReq req) {
        TAgentPageConfigExample example = new TAgentPageConfigExample();
        TAgentPageConfigExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(req.getUserName())){
            criteria.andUserNameEqualTo(req.getUserName());
        }
        if(StringUtils.isNotBlank(req.getTelegram())){
            criteria.andTelegramEqualTo(req.getTelegram());
        }
        if(StringUtils.isNotBlank(req.getFlygram())){
            criteria.andFlygramEqualTo(req.getFlygram());
        }
        if(StringUtils.isNotBlank(req.getQq())){
            criteria.andQqEqualTo(req.getQq());
        }
        if(StringUtils.isNotBlank(req.getLetstalk())){
            criteria.andLetstalkEqualTo(req.getLetstalk());
        }
        if(StringUtils.isNotBlank(req.getAgentRegisterLink())){
            criteria.andAgentRegisterLinkEqualTo(req.getAgentRegisterLink());
        }
        if(StringUtils.isNotBlank(req.getPlatformRegisterLink())){
            criteria.andPlatformRegisterLinkEqualTo(req.getPlatformRegisterLink());
        }
        if(StringUtils.isNotBlank(req.getActivityLink())){
            criteria.andActivityLinkEqualTo(req.getActivityLink());
        }
        example.setOrderByClause(" id");
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<TAgentPageConfig> list = tAgentPageConfigMapper.selectByExample(example);
        PageInfo<TAgentPageConfig> page = new PageInfo<>(list);
        List<AgentConfigRsp> rspList = list.stream().map(agentPageConfig->this.convertRsp(agentPageConfig)).collect(Collectors.toList());
        return PageUtil.pageInfo2PageRsp(page, rspList);
    }

    @Override
    public AgentConfigRsp getByAgentCode(AgentConfigReq req) throws Exception {
        TAgentPageConfigExample example = new TAgentPageConfigExample();
        TDict dict = dictService.getByTypeAndCode("PAGE_DOMAIN", "AGENT_CONFIG_PAGE");
        String url = dict.getDictVal() + "?code="+req.getAgentCode();
        example.createCriteria().andActivityLinkEqualTo(url);
        List<TAgentPageConfig> list = tAgentPageConfigMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        AgentConfigRsp rsp = new AgentConfigRsp();
        BeanUtils.copyProperties(list.get(0), rsp);
        return rsp;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(AgentConfigReq req) throws Exception {
        TAgentPageConfig agentPageConfig = BizUtil.getInsertInfo(new TAgentPageConfig(), req.getLoginName(), new Date());
        agentPageConfig.setUserName(req.getUserName());
        agentPageConfig.setTelegram(req.getTelegram());
        agentPageConfig.setFlygram(req.getFlygram());
        agentPageConfig.setQq(req.getQq());
        agentPageConfig.setLetstalk(req.getLetstalk());
        agentPageConfig.setAgentRegisterLink(req.getAgentRegisterLink());
        agentPageConfig.setPlatformRegisterLink(req.getPlatformRegisterLink());
        TDict dict = dictService.getByTypeAndCode("PAGE_DOMAIN", "AGENT_CONFIG_PAGE");
        int num = Integer.parseInt(dict.getDictValBig()) + 1;
        agentPageConfig.setActivityLink(dict.getDictVal() + "?code="+num);
        String afterVal = this.getLogJSONStr(agentPageConfig);
        int count = sysLogService.addSysLog(null, LogTypeEnum.AGENT_CONFIG_ADD, "", "", afterVal, "", 1, req.getLoginName());
        if(count < 1){
            throw new BizException(CodeCons.ERROR, "信息记录失败，请稍后重试");
        }
        DictReq dictReq = new DictReq();
        dictReq.setLoginName(req.getLoginName());
        dictReq.setId(dict.getId());
        dictReq.setDictValBig(""+num);
        dictService.update(dictReq);
        tAgentPageConfigMapper.insertSelective(agentPageConfig);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(AgentConfigReq req) throws Exception {
        TAgentPageConfig oldAgentConfig = tAgentPageConfigMapper.selectByPrimaryKey(req.getId());
        TAgentPageConfig agentPageConfig = BizUtil.getUpdateInfo(new TAgentPageConfig(), req.getId(), req.getLoginName(), new Date());
        agentPageConfig.setUserName(req.getUserName());
        agentPageConfig.setTelegram(req.getTelegram());
        agentPageConfig.setFlygram(req.getFlygram());
        agentPageConfig.setQq(req.getQq());
        agentPageConfig.setLetstalk(req.getLetstalk());
        agentPageConfig.setAgentRegisterLink(req.getAgentRegisterLink());
        agentPageConfig.setPlatformRegisterLink(req.getPlatformRegisterLink());
        agentPageConfig.setActivityLink(oldAgentConfig.getActivityLink());
        String beforeVal = this.getLogJSONStr(oldAgentConfig);
        String afterVal = this.getLogJSONStr(agentPageConfig);
        if(!beforeVal.equals(afterVal)){
            int count = sysLogService.addSysLog(null, LogTypeEnum.AGENT_CONFIG_UPDATE, beforeVal, "", afterVal, "", 1, req.getLoginName());
            if(count < 1){
                throw new BizException(CodeCons.ERROR, "信息记录失败，请稍后重试");
            }
        }
        tAgentPageConfigMapper.updateByPrimaryKeySelective(agentPageConfig);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id, String updateUser) throws Exception {
        TAgentPageConfig agentPageConfig = tAgentPageConfigMapper.selectByPrimaryKey(id);
        String beforeVal = this.getLogJSONStr(agentPageConfig);
        int count = sysLogService.addSysLog(null, LogTypeEnum.AGENT_CONFIG_DELETE, beforeVal, "", "", "", 1, updateUser);
        if(count < 1){
            throw new BizException(CodeCons.ERROR, "信息记录失败，请稍后重试");
        }
        tAgentPageConfigMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importAgentConfigList(List<AgentConfigRsp> list, String createUser, String fileName) throws Exception {
        if(list.size() == 0 || list.size() > 1000){
            throw new BizException(CodeCons.ERROR, "请将单次上传的数量控制在1-1000条之间");
        }
        int count = sysLogService.addSysLog(null, LogTypeEnum.AGENT_CONFIG_BATCH_IMPORT, null, fileName, "", "", 1, createUser);
        if(count < 1){
            throw new BizException(CodeCons.ERROR, "信息记录失败，请稍后重试");
        }
        Date now = new Date();
        TDict dict = dictService.getByTypeAndCode("PAGE_DOMAIN", "AGENT_CONFIG_PAGE");
        int num = Integer.parseInt(dict.getDictValBig());
        for(AgentConfigRsp agent:list){
            num++;
            BizUtil.getInsertInfo(agent, createUser, now);
            agent.setActivityLink(dict.getDictVal() + "?code="+num);
        }
        DictReq dictReq = new DictReq();
        dictReq.setLoginName(createUser);
        dictReq.setId(dict.getId());
        dictReq.setDictValBig(""+num);
        dictService.update(dictReq);
        agentPageConfigMapper.createBatch(list);
    }

    private AgentConfigRsp convertRsp(TAgentPageConfig agentPageConfig){
        AgentConfigRsp rsp = new AgentConfigRsp();
        BeanUtils.copyProperties(agentPageConfig, rsp);
        return rsp;
    }

    private String getLogJSONStr(TAgentPageConfig agentPageConfig){
        JSONObject json = new JSONObject();
        json.put("id", agentPageConfig.getId());
        json.put("userName", agentPageConfig.getUserName());
        json.put("telegram", agentPageConfig.getTelegram());
        json.put("flygram", agentPageConfig.getFlygram());
        json.put("qq", agentPageConfig.getQq());
        json.put("letstalk", agentPageConfig.getLetstalk());
        json.put("agentRegisterLink", agentPageConfig.getAgentRegisterLink());
        json.put("platformRegisterLink", agentPageConfig.getPlatformRegisterLink());
        return json.toJSONString();
    }

}
