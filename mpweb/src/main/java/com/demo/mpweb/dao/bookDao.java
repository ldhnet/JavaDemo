package com.demo.mpweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.mpweb.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookDao extends BaseMapper<Book> {

}
