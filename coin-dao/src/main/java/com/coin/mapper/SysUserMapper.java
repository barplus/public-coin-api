package com.coin.mapper;

import com.coin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    SysUser getUserByLoginName(@Param("loginName") String loginName);

}
