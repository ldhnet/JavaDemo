package com.demo.mpweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.domain.Book;
import com.demo.mpweb.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<bookDao, Book> implements IBookService {
    @Autowired
    private bookDao bookDao;

    private HashMap<Integer,Book> _cache=new HashMap<>();

    @Override
//    @Cacheable(value = "cacheSpace",key = "#id")
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }
//    @Override
//    public Book getCacheById(Integer id) {
//        Book book=_cache.get(id);
//        if (book == null)
//        {
//            Book queryBook=bookDao.selectById(id);
//            _cache.put(id,queryBook);
//            return  queryBook;
//        }
//        return book;
//    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return bookDao.selectPage(page, null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage page = new Page(currentPage, pageSize);
        return bookDao.selectPage(page, lqw);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }//implements IBookService

    @Transactional
    @Override
    public Boolean BatchSave(List<Book> books) {
        int ret=0;
        for (Book book: books) {
            ret+= bookDao.insert(book);
        }
        return ret > 0;
    }
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

//
//    @Override
//    public List<Book> getAll() {
//        return bookDao.selectList(null);
//    }
//

}
