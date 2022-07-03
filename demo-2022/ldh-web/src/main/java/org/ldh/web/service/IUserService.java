package org.ldh.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ldh.web.domain.Book;
import org.ldh.web.domain.User;

import java.util.List;

public interface IUserService extends IService<User> {

      List<User> getAll();
      User getById(Integer id);
      List<User> queryUserByName(String userName);

      IPage<User> getUserPageList(int currentPage, int pageSize);
      IPage<User> getQueryUserPageList(int currentPage,int pageSize,User user);
}
