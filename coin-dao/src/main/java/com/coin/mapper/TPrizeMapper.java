package com.coin.mapper;

import com.coin.entity.TPrize;
import com.coin.entity.TPrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPrizeMapper {
    long countByExample(TPrizeExample example);

    int deleteByExample(TPrizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPrize row);

    int insertSelective(TPrize row);

    List<TPrize> selectByExample(TPrizeExample example);

    TPrize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TPrize row, @Param("example") TPrizeExample example);

    int updateByExample(@Param("row") TPrize row, @Param("example") TPrizeExample example);

    int updateByPrimaryKeySelective(TPrize row);

    int updateByPrimaryKey(TPrize row);
}