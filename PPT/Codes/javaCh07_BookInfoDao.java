package com.iflytek.booklib.dao;

import java.sql.*;
import java.util.*;

import com.iflytek.booklib.pojo.BookInfo;
import com.iflytek.booklib.util.DbUtil;

public class BookInfoDao {
	private DbUtil db = new DbUtil();

	public int add(BookInfo bookInfo) {
		int rlt = 0;
		rlt = db.excuteUpdate(
				"INSERT INTO tb_bookinfo(bookno,title,year,author,category,price,stock) VALUES(?,?,?,?,?,?,?)",
				bookInfo.getBookno(), bookInfo.getTitle(), bookInfo.getYear(),
				bookInfo.getAuthor(), bookInfo.getCategory(),
				bookInfo.getPrice(), bookInfo.getStock());
		return rlt;
	}

	public int delete(String bookno) {
		int rlt = 0;
		rlt = db.excuteUpdate("DELETE FROM tb_bookinfo WHERE bookno=?", bookno);
		return rlt;
	}

	/**
	 * 根据bookno更新book实体信息
	 * 
	 * @param bookInfo
	 * @return
	 */
	public int update(BookInfo bookInfo) {
		int rlt = 0;
		rlt = db.excuteUpdate(
				"UPDATE tb_bookinfo SET title=?,year=?,author=?,category=?,price=?,stock=? WHERE bookno=?",
				bookInfo.getTitle(), bookInfo.getYear(), bookInfo.getAuthor(),
				bookInfo.getCategory(), bookInfo.getPrice(),
				bookInfo.getStock(), bookInfo.getBookno());
		return rlt;
	}

	/**
	 * 根据图书编号查询
	 * 
	 * @param bookno
	 * @return
	 */
	public BookInfo queryByBookno(String bookno) {
		ResultSet rs = null;
		BookInfo bookInfo = null;

		try {
			rs = db.query(
					"SELECT bookno,title,year,author,category,price,stock FROM tb_bookinfo WHERE bookno=?",
					bookno);
			bookInfo = convert2BookInfo(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close();
		}

		return bookInfo;
	}

	/**
	 * 根据图书名称查询
	 * 
	 * @param title
	 * @return
	 */
	public List<BookInfo> queryByTitle(String title) {
		List<BookInfo> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = db.query(
					"SELECT bookno,title,year,author,category,price,stock FROM tb_bookinfo WHERE title LIKE ?",
					"%" + title + "%");

			if (null != rs) {
				while (rs.next()) {
					list.add(convert2BookInfo(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close();
		}

		return list;
	}

	/**
	 * 根据图书作者查询
	 * 
	 * @param author
	 * @return
	 */
	public List<BookInfo> queryByAuthor(String author) {
		List<BookInfo> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = db.query(
					"SELECT bookno,title,year,author,category,price,stock FROM tb_bookinfo WHERE author LIKE ?",
					"%" + author + "%");
			if (null != rs) {
				while (rs.next()) {
					list.add(convert2BookInfo(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close();
		}

		return list;
	}

	/**
	 * 根据分类查询
	 * 
	 * @param category
	 * @return
	 */
	public List<BookInfo> queryByCategory(String category) {
		List<BookInfo> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = db.query(
					"SELECT bookno,title,year,author,category,price,stock FROM tb_bookinfo WHERE category LIKE ?",
					"%" + category + "%");
			if (null != rs) {
				while (rs.next()) {
					list.add(convert2BookInfo(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close();
		}

		return list;
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<BookInfo> queryAll() {
		List<BookInfo> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = db.query(
					"SELECT bookno,title,year,author,category,price,stock FROM tb_bookinfo ");
			if (null != rs) {
				while (rs.next()) {
					list.add(convert2BookInfo(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close();
		}

		return list;
	}

	/**
	 * 将结果集转换为对象
	 * 
	 * @param rs ResultSet结果集
	 * @return 返回实体对象
	 * @throws SQLException
	 */
	private BookInfo convert2BookInfo(ResultSet rs) throws SQLException {
		BookInfo bookInfo = null;

		bookInfo = new BookInfo();
		bookInfo.setAuthor(rs.getString("author"));
		bookInfo.setBookno(rs.getString("bookno"));
		bookInfo.setCategory(rs.getString("category"));
		bookInfo.setPrice(rs.getFloat("price"));
		bookInfo.setStock(rs.getInt("stock"));
		bookInfo.setTitle(rs.getString("title"));
		bookInfo.setYear(rs.getInt("year"));

		return bookInfo;
	}
}
