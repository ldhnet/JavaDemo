package org.ldh.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.ldh.web.dao.bookDao;
import org.ldh.web.domain.Book;
import org.ldh.web.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }
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
    }

    @Transactional
    @Override
    public Boolean BatchSave(List<Book> books) {
        int ret=0;
        for (Book book: books) {
            ret+= bookDao.insert(book);
        }
        return ret > 0;
    }
}
