package com.coin.mapper;

import com.coin.entity.TSysResource;
import com.coin.entity.TSysResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysResourceMapper {
    long countByExample(TSysResourceExample example);

    int deleteByExample(TSysResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysResource row);

    int insertSelective(TSysResource row);

    List<TSysResource> selectByExample(TSysResourceExample example);

    TSysResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TSysResource row, @Param("example") TSysResourceExample example);

    int updateByExample(@Param("row") TSysResource row, @Param("example") TSysResourceExample example);

    int updateByPrimaryKeySelective(TSysResource row);

    int updateByPrimaryKey(TSysResource row);
}