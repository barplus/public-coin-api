package com.coin.mapper;

import com.coin.entity.TSysUser;
import com.coin.entity.TSysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysUserMapper {
    long countByExample(TSysUserExample example);

    int deleteByExample(TSysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysUser row);

    int insertSelective(TSysUser row);

    List<TSysUser> selectByExample(TSysUserExample example);

    TSysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TSysUser row, @Param("example") TSysUserExample example);

    int updateByExample(@Param("row") TSysUser row, @Param("example") TSysUserExample example);

    int updateByPrimaryKeySelective(TSysUser row);

    int updateByPrimaryKey(TSysUser row);
}