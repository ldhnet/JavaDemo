package com.demo.mpweb.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.domain.Book;
import com.demo.mpweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<bookDao, Book> implements IBookService {
    @Autowired
    private bookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(1, 5);
        return bookDao.selectPage(page, null);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }//implements IBookService

//
//    @Override
//    public Boolean save(Book book) {
//        return bookDao.insert(book) > 0;
//    }
//
//    @Override
//    public Boolean update(Book book) {
//        return bookDao.updateById(book) > 0;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        return  bookDao.deleteById(id) > 0;
//    }
//
//    @Override
//    public Book getById(Integer id) {
//        return bookDao.selectById(id);
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return bookDao.selectList(null);
//    }
//

}
