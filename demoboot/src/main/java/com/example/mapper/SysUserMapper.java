package com.example.mapper;

import com.example.web.models.SysUser;

import java.util.List;

public interface SysUserMapper {
    List<SysUser> selectUserList();
    SysUser selectUserById(Integer id);
}
