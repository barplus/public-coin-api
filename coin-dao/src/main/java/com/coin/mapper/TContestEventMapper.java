package com.coin.mapper;

import com.coin.entity.TContestEvent;
import com.coin.entity.TContestEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContestEventMapper {
    long countByExample(TContestEventExample example);

    int deleteByExample(TContestEventExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TContestEvent row);

    int insertSelective(TContestEvent row);

    List<TContestEvent> selectByExample(TContestEventExample example);

    TContestEvent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TContestEvent row, @Param("example") TContestEventExample example);

    int updateByExample(@Param("row") TContestEvent row, @Param("example") TContestEventExample example);

    int updateByPrimaryKeySelective(TContestEvent row);

    int updateByPrimaryKey(TContestEvent row);
}