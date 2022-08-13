package com.coin.service.impl;

import com.coin.entity.Dict;
import com.coin.mapper.DictMapper;
import com.coin.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictMapper dictMapper;

    @Override
    public List<Dict> getListByType(String dictType) throws Exception {
        return dictMapper.getListByType(dictType);
    }

}
