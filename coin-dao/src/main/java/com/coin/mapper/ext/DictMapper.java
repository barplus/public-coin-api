package com.coin.mapper.ext;

import com.coin.entity.TDict;
import com.coin.req.DictReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {

    void addDict(TDict dict);

    int updateDict(TDict dict);

    List<TDict> getListByType(DictReq dictReq);

    TDict getByTypeAndCode(@Param("dictType")String dictType, @Param("dictCode")String dictCode);

    TDict getById(@Param("id")Integer id);

}
