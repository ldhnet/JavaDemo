package org.ldh.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ldh.web.domain.User;

import java.util.List;

public interface IUserService extends IService<User> {

      List<User> getAll();
      User getById(Integer id);
}
