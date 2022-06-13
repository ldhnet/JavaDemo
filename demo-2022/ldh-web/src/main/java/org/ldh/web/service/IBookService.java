package org.ldh.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ldh.web.domain.Book;
import java.util.List;

public interface IBookService extends IService<Book> {
      Boolean BatchSave(List<Book> books);
      IPage<Book> getPage(int currentPage,int pageSize);
      IPage<Book> getPage(int currentPage,int pageSize,Book book);
      List<Book> getAll();
      Book getById(Integer id);
}
