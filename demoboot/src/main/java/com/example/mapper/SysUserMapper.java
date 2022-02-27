package com.example.mapper;

import com.example.web.models.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    List<SysUser> selectUserList();
    void addUser(@Param("user")SysUser user);
    SysUser getUserByName(@Param("name")String name);
    SysUser selectUserById(@Param("id")Integer id);
}
