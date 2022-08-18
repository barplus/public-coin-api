package com.coin.service.impl;

import com.coin.entity.Dict;
import com.coin.mapper.DictMapper;
import com.coin.req.DictReq;
import com.coin.service.DictService;
import com.coin.service.util.BizUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictMapper dictMapper;

    @Override
    public List<Dict> getListByType(DictReq dictReq) throws Exception {
        return dictMapper.getListByType(dictReq);
    }

    @Override
    public void add(DictReq req) throws Exception {
        Dict dict = BizUtil.getInsertInfo(new Dict(), req.getLoginName(), new Date());
        dict.setDictType(req.getDictType());
        dict.setDictCode(req.getDictCode());
        dict.setDictName(req.getDictName());
        dict.setDictVal(req.getDictVal());
        dict.setDictValBig(req.getDictValBig());
        dict.setParentDictCode(req.getParentDictCode());
        dictMapper.addDict(dict);
    }

}
