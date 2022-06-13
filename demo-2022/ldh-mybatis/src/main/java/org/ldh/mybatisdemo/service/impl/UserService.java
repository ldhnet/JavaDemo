package org.ldh.mybatisdemo.service.impl;

import org.ldh.mybatisdemo.domain.SysUser;
import org.ldh.mybatisdemo.mapper.SysUserMapper;
import org.ldh.mybatisdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> selectUserList() {
        return userMapper.selectUserList();
    }
}