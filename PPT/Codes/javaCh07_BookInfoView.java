package com.iflytek.booklib.view;

import java.util.List;

import com.iflytek.booklib.pojo.BookInfo;
import com.iflytek.booklib.service.BookInfoService;

public class BookInfoView {
	// 显示所有图书
	public void showAllBook() {
		List<BookInfo> list = new BookInfoService().queryBookAll();
		if (null != list) {
			for (BookInfo book : list) {
				System.out.println(book.getBookno() + "\t" + book.getTitle()
						+ "\t" + book.getAuthor());
			}
		}
	}

	public void addBook() {
		BookInfo book = new BookInfo();
		book.setAuthor("jack");
		book.setBookno("9001");
		book.setCategory("健康");
		book.setPrice(29.9f);
		book.setStock(100);
		book.setTitle("颈椎病康复指南");
		book.setYear(2018);

		new BookInfoService().addBook(book);
	}

	public void updateBook() {
		BookInfo book = new BookInfo();
		book.setBookno("9001");
		book.setAuthor("张三丰");// 修改作者
		book.setCategory("健康");
		book.setPrice(29.9f);
		book.setStock(100);
		book.setTitle("颈椎病康复指南");
		book.setYear(2018);

		new BookInfoService().updateBook(book);
	}

	public void deleteBook() {
		String bookno = "9001";
		new BookInfoService().deleteBook(bookno);
	}
}
