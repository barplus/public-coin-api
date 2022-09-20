package com.coin.service.impl;

import com.coin.entity.TContestDetail;
import com.coin.entity.TContestDetailExample;
import com.coin.mapper.TContestDetailMapper;
import com.coin.service.ContestDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContestDetailServiceImpl implements ContestDetailService {

    private static final Logger logger = LoggerFactory.getLogger(ContestDetailServiceImpl.class);

    @Resource
    private TContestDetailMapper tContestDetailMapper;

    @Override
    public TContestDetail getByPid(Integer pid) throws Exception {
        TContestDetailExample example = new TContestDetailExample();
        example.createCriteria().andPIdEqualTo(pid);
        List<TContestDetail> list = tContestDetailMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

}
