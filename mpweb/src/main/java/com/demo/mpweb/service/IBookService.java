package com.demo.mpweb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.mpweb.domain.Book;
import java.util.List;

public interface IBookService extends IService<Book> {
//    Boolean save(Book book);
//    Boolean update(Book book);
//    Boolean delete(Integer id);
//    Book getById(Integer id);
//    List<Book> getAll();
      Boolean BatchSave(List<Book> books);
      IPage<Book> getPage(int currentPage,int pageSize);
      List<Book> getAll();
      Book getCacheById(Integer id);
      Book getById(Integer id);
}
