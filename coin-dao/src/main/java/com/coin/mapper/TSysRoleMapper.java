package com.coin.mapper;

import com.coin.entity.TSysRole;
import com.coin.entity.TSysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysRoleMapper {
    long countByExample(TSysRoleExample example);

    int deleteByExample(TSysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysRole row);

    int insertSelective(TSysRole row);

    List<TSysRole> selectByExample(TSysRoleExample example);

    TSysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TSysRole row, @Param("example") TSysRoleExample example);

    int updateByExample(@Param("row") TSysRole row, @Param("example") TSysRoleExample example);

    int updateByPrimaryKeySelective(TSysRole row);

    int updateByPrimaryKey(TSysRole row);
}