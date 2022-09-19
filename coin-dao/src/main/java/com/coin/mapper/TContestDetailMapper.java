package com.coin.mapper;

import com.coin.entity.TContestDetail;
import com.coin.entity.TContestDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContestDetailMapper {
    long countByExample(TContestDetailExample example);

    int deleteByExample(TContestDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TContestDetail row);

    int insertSelective(TContestDetail row);

    List<TContestDetail> selectByExample(TContestDetailExample example);

    TContestDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TContestDetail row, @Param("example") TContestDetailExample example);

    int updateByExample(@Param("row") TContestDetail row, @Param("example") TContestDetailExample example);

    int updateByPrimaryKeySelective(TContestDetail row);

    int updateByPrimaryKey(TContestDetail row);
}