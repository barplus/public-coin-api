package com.coin.mapper;

import com.coin.entity.TContestInformation;
import com.coin.entity.TContestInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContestInformationMapper {
    long countByExample(TContestInformationExample example);

    int deleteByExample(TContestInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TContestInformation row);

    int insertSelective(TContestInformation row);

    List<TContestInformation> selectByExample(TContestInformationExample example);

    TContestInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TContestInformation row, @Param("example") TContestInformationExample example);

    int updateByExample(@Param("row") TContestInformation row, @Param("example") TContestInformationExample example);

    int updateByPrimaryKeySelective(TContestInformation row);

    int updateByPrimaryKey(TContestInformation row);
}