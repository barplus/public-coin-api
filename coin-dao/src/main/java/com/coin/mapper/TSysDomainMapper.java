package com.coin.mapper;

import com.coin.entity.TSysDomain;
import com.coin.entity.TSysDomainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysDomainMapper {
    long countByExample(TSysDomainExample example);

    int deleteByExample(TSysDomainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysDomain row);

    int insertSelective(TSysDomain row);

    List<TSysDomain> selectByExample(TSysDomainExample example);

    TSysDomain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TSysDomain row, @Param("example") TSysDomainExample example);

    int updateByExample(@Param("row") TSysDomain row, @Param("example") TSysDomainExample example);

    int updateByPrimaryKeySelective(TSysDomain row);

    int updateByPrimaryKey(TSysDomain row);
}