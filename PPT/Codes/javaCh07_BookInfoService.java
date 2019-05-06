package com.iflytek.booklib.service;

import java.util.List;

import com.iflytek.booklib.dao.BookInfoDao;
import com.iflytek.booklib.pojo.BookInfo;

public class BookInfoService {

	public int addBook(BookInfo bookInfo) {
		return new BookInfoDao().add(bookInfo);
	}

	public int deleteBook(String bookno) {
		return new BookInfoDao().delete(bookno);
	}

	public int updateBook(BookInfo bookInfo) {
		return new BookInfoDao().update(bookInfo);
	}

	public BookInfo queryBookByNo(String bookno) {
		return new BookInfoDao().queryByBookno(bookno);
	}

	public List<BookInfo> queryBookByTitle(String title) {
		return new BookInfoDao().queryByTitle(title);
	}

	public List<BookInfo> queryBookByAuthor(String author) {
		return new BookInfoDao().queryByAuthor(author);
	}

	public List<BookInfo> queryBookByCategory(String category) {
		return new BookInfoDao().queryByCategory(category);
	}

	public List<BookInfo> queryBookAll() {
		return new BookInfoDao().queryAll();
	}
}
