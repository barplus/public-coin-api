package com.coin.mapper;

import com.coin.entity.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {

    void addDict(Dict dict);

    void updateDict(Dict dict);

    List<Dict> getListByType(@Param("dictType")String dictType);

    Dict getByTypeAndCode(@Param("dictType")String dictType, @Param("dictCode")String dictCode);

}
