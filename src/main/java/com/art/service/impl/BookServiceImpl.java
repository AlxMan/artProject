package com.art.service.impl;

import com.art.dao.BookDao;
import com.art.bean.entity.Book;
import com.art.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
　* @Description:
　* @user wangxianchao
　* @date 2018/9/26 18:02 
*/
@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  public Book getById(long bookId) {
    return bookDao.queryById(bookId);
  }

  public List<Book> getList(int start, int pageNum) {
    return bookDao.queryAll(start, pageNum);
  }

  public int addBook(Book book) {
    return bookDao.addBook(book);
  }

  public int updateBook(Book book) {
    return bookDao.updateBook(book);
  }

  public int deleteBookById(long id) {
    return bookDao.deleteBookById(id);
  }

  public int countNum() {
    return bookDao.countNum();
  }

  public List<Book> getListPlug() {
    return bookDao.queryAllPlug();
  }
}
