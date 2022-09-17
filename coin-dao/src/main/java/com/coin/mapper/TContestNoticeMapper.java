package com.coin.mapper;

import com.coin.entity.TContestNotice;
import com.coin.entity.TContestNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContestNoticeMapper {
    long countByExample(TContestNoticeExample example);

    int deleteByExample(TContestNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TContestNotice row);

    int insertSelective(TContestNotice row);

    List<TContestNotice> selectByExample(TContestNoticeExample example);

    TContestNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TContestNotice row, @Param("example") TContestNoticeExample example);

    int updateByExample(@Param("row") TContestNotice row, @Param("example") TContestNoticeExample example);

    int updateByPrimaryKeySelective(TContestNotice row);

    int updateByPrimaryKey(TContestNotice row);
}