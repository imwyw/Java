package com.iflytek.booklib.pojo;

public class BookInfo {
	private String bookno; // 图书编号
	private String title; // 图书名
	private int year; // 出版年份
	private String author; // 作者
	private String category; // 分类
	private float price; // 价格
	private int stock; // 库存量

	public String getBookno() {
		return bookno;
	}

	public void setBookno(String bookno) {
		this.bookno = bookno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "BookInfo [bookno=" + bookno + ", title=" + title + ", year="
				+ year + ", author=" + author + ", category=" + category
				+ ", price=" + price + ", stock=" + stock + "]";
	}

}
