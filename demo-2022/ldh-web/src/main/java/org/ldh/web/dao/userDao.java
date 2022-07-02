package org.ldh.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ldh.web.domain.User;

@Mapper
public interface userDao extends BaseMapper<User>{

}
