package org.ldh.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ldh.web.domain.Book;

@Mapper
public interface bookDao extends BaseMapper<Book> {

}
