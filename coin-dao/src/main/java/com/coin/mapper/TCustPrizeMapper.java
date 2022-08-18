package com.coin.mapper;

import com.coin.entity.TCustPrize;
import com.coin.entity.TCustPrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCustPrizeMapper {
    long countByExample(TCustPrizeExample example);

    int deleteByExample(TCustPrizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCustPrize row);

    int insertSelective(TCustPrize row);

    List<TCustPrize> selectByExample(TCustPrizeExample example);

    TCustPrize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TCustPrize row, @Param("example") TCustPrizeExample example);

    int updateByExample(@Param("row") TCustPrize row, @Param("example") TCustPrizeExample example);

    int updateByPrimaryKeySelective(TCustPrize row);

    int updateByPrimaryKey(TCustPrize row);
}