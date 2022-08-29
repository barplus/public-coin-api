package com.coin.mapper;

import com.coin.entity.TSysRoleResource;
import com.coin.entity.TSysRoleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysRoleResourceMapper {
    long countByExample(TSysRoleResourceExample example);

    int deleteByExample(TSysRoleResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysRoleResource row);

    int insertSelective(TSysRoleResource row);

    List<TSysRoleResource> selectByExample(TSysRoleResourceExample example);

    TSysRoleResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TSysRoleResource row, @Param("example") TSysRoleResourceExample example);

    int updateByExample(@Param("row") TSysRoleResource row, @Param("example") TSysRoleResourceExample example);

    int updateByPrimaryKeySelective(TSysRoleResource row);

    int updateByPrimaryKey(TSysRoleResource row);
}