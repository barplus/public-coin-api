package com.coin.service;

import com.coin.entity.Dict;

import java.util.List;

public interface DictService {

    List<Dict> getListByType(String dictType) throws Exception;

}
