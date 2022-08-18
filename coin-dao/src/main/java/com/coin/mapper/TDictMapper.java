package com.coin.mapper;

import com.coin.entity.TDict;
import com.coin.entity.TDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDictMapper {
    long countByExample(TDictExample example);

    int deleteByExample(TDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDict row);

    int insertSelective(TDict row);

    List<TDict> selectByExample(TDictExample example);

    TDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TDict row, @Param("example") TDictExample example);

    int updateByExample(@Param("row") TDict row, @Param("example") TDictExample example);

    int updateByPrimaryKeySelective(TDict row);

    int updateByPrimaryKey(TDict row);
}