package com.coin.mapper;

import com.coin.entity.TSysLog;
import com.coin.entity.TSysLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysLogMapper {
    long countByExample(TSysLogExample example);

    int deleteByExample(TSysLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysLog row);

    int insertSelective(TSysLog row);

    List<TSysLog> selectByExample(TSysLogExample example);

    TSysLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TSysLog row, @Param("example") TSysLogExample example);

    int updateByExample(@Param("row") TSysLog row, @Param("example") TSysLogExample example);

    int updateByPrimaryKeySelective(TSysLog row);

    int updateByPrimaryKey(TSysLog row);
}