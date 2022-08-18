package com.coin.mapper.ext;

import com.coin.entity.TSysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    TSysUser getUserByLoginName(@Param("loginName") String loginName);

}
