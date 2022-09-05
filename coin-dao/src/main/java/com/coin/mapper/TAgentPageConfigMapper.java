package com.coin.mapper;

import com.coin.entity.TAgentPageConfig;
import com.coin.entity.TAgentPageConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAgentPageConfigMapper {
    long countByExample(TAgentPageConfigExample example);

    int deleteByExample(TAgentPageConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAgentPageConfig row);

    int insertSelective(TAgentPageConfig row);

    List<TAgentPageConfig> selectByExample(TAgentPageConfigExample example);

    TAgentPageConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TAgentPageConfig row, @Param("example") TAgentPageConfigExample example);

    int updateByExample(@Param("row") TAgentPageConfig row, @Param("example") TAgentPageConfigExample example);

    int updateByPrimaryKeySelective(TAgentPageConfig row);

    int updateByPrimaryKey(TAgentPageConfig row);
}