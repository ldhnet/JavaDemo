package com.example.service;

import com.example.web.models.SysUser;

import java.util.List;

/**
 * 用户信息接口
 */
public interface IUserInterface {
    /**
     * 获取用户信息
     * @param user
     * @return
     */
    public List<SysUser> selectUserList();
}
