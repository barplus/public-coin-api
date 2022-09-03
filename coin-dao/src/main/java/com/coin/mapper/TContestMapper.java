package com.coin.mapper;

import com.coin.entity.TContest;
import com.coin.entity.TContestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContestMapper {
    long countByExample(TContestExample example);

    int deleteByExample(TContestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TContest row);

    int insertSelective(TContest row);

    List<TContest> selectByExample(TContestExample example);

    TContest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TContest row, @Param("example") TContestExample example);

    int updateByExample(@Param("row") TContest row, @Param("example") TContestExample example);

    int updateByPrimaryKeySelective(TContest row);

    int updateByPrimaryKey(TContest row);
}