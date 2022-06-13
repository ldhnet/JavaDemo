package org.ldh.mybatisdemo.mapper;


import org.apache.ibatis.annotations.Param;
import org.ldh.mybatisdemo.domain.SysUser;

import java.util.List;

public interface SysUserMapper {
    List<SysUser> selectUserList();
    void addUser(@Param("user")SysUser user);
    SysUser getUserByName(@Param("name")String name);
    SysUser selectUserById(@Param("id")Integer id);
}
