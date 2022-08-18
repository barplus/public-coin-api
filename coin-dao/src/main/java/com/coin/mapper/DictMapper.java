package com.coin.mapper;

import com.coin.entity.Dict;
import com.coin.req.DictReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {

    void addDict(Dict dict);

    void updateDict(Dict dict);

    List<Dict> getListByType(DictReq dictReq);

    Dict getByTypeAndCode(@Param("dictType")String dictType, @Param("dictCode")String dictCode);

}
