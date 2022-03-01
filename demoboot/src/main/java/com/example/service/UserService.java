package com.example.service;

import com.example.mapper.SysUserMapper;
import com.example.web.models.SysUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements IUserInterface{

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> selectUserList() {
        return userMapper.selectUserList();
    }
}
