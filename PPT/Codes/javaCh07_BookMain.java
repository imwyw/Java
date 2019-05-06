package com.iflytek.booklib.view;

public class BookMain {
	public static void main(String[] args) {
		new BookInfoView().addBook();
		new BookInfoView().updateBook();
		new BookInfoView().showAllBook();
		new BookInfoView().deleteBook();
	}
}
