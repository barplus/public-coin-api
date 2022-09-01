package com.coin.mapper.ext;

import com.coin.entity.TSysRoleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleResourceMapper {

    void addBatch(List<TSysRoleResource> list) throws Exception;

    void delBatch(@Param("roleCode") String roleCode, List<String> resourceCodes) throws Exception;

}
