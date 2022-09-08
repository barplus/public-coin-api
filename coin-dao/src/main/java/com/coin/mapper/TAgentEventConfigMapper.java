package com.coin.mapper;

import com.coin.entity.TAgentEventConfig;
import com.coin.entity.TAgentEventConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAgentEventConfigMapper {
    long countByExample(TAgentEventConfigExample example);

    int deleteByExample(TAgentEventConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAgentEventConfig row);

    int insertSelective(TAgentEventConfig row);

    List<TAgentEventConfig> selectByExampleWithBLOBs(TAgentEventConfigExample example);

    List<TAgentEventConfig> selectByExample(TAgentEventConfigExample example);

    TAgentEventConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TAgentEventConfig row, @Param("example") TAgentEventConfigExample example);

    int updateByExampleWithBLOBs(@Param("row") TAgentEventConfig row, @Param("example") TAgentEventConfigExample example);

    int updateByExample(@Param("row") TAgentEventConfig row, @Param("example") TAgentEventConfigExample example);

    int updateByPrimaryKeySelective(TAgentEventConfig row);

    int updateByPrimaryKeyWithBLOBs(TAgentEventConfig row);

    int updateByPrimaryKey(TAgentEventConfig row);
}