package org.ldh.mybatisdemo.service;

import org.ldh.mybatisdemo.domain.SysUser;

import java.util.List;

/**
 * 用户信息接口
 */
public interface IUserService {
    /**
     * 获取用户信息
     * @param user
     * @return
     */
    public List<SysUser> selectUserList();
}
