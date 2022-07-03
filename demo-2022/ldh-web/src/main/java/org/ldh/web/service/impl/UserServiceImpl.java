package org.ldh.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.ldh.web.dao.userDao;
import org.ldh.web.domain.Book;
import org.ldh.web.domain.User;
import org.ldh.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<userDao, User> implements IUserService {
    @Autowired
    private userDao userDao;

    private HashMap<Integer,User> _cache=new HashMap<>();

    @Override
    public User getById(Integer id) {
        return userDao.selectById(id);
    }
    @Override
    public List<User> queryUserByName(String userName) {
        User _user=new User();
        _user.setUserName(userName);
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(_user.getUserName()),User::getUserName,_user.getUserName());
        return userDao.selectList(lqw);
    }
    @Override
    public List<User> getAll() {
        User _user=new User();
        _user.setUserName("张");
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(_user.getUserName()),User::getUserName,_user.getUserName());
        return userDao.selectList(lqw);
    }
    @Override
    public IPage<User> getUserPageList(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return userDao.selectPage(page, null);
    }
    @Override
    public IPage<User> getQueryUserPageList(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(user.getUserName()),User::getUserName,user.getUserName());
        IPage page = new Page(currentPage, pageSize);
        return userDao.selectPage(page, lqw);
    }

}
