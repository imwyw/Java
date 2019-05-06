package com.iflytek.booklib.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * 封装db常用操作
 *
 */
public class DbUtil {
	private Connection conn;// 数据库连接
	private PreparedStatement pstmt;// 预编译SQL语句对象

	private String DB_URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=utf8";
	private String USER_NAME = "root";
	private String USER_PASS = "123456";

	/**
	 * static 静态代码块 在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次。
	 */
	static {
		try {
			// 注册jdbc驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @return 数据库连接对象
	 */
	private Connection getConnection() {
		try {
			if (null == conn || conn.isClosed()) {
				conn = DriverManager.getConnection(DB_URL, USER_NAME,
						USER_PASS);
			}
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException("获取数据库连接失败", e);
		}
	}

	/**
	 * 创建预编译的SQL语句对象
	 * 
	 * @param sql    SQL语句
	 * @param params 参数
	 * @return 预编译语句对象
	 * @throws SQLException
	 */
	private PreparedStatement preparedStatement(String sql, Object... params)
			throws SQLException {
		pstmt = conn.prepareStatement(sql);
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		return pstmt;
	}

	/**
	 * 执行增、删、改操作
	 * 
	 * @param sql    SQL语句
	 * @param params 参数
	 * @return 执行结果
	 */
	public int excuteUpdate(String sql, Object... params) {
		try {
			getConnection();
			pstmt = preparedStatement(sql, params);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("执行SQL语句发生异常", e);
		} finally {
			close();
		}
	}

	/**
	 * 执行查询
	 * 
	 * @param sql    SQL语句
	 * @param params 参数
	 * @return 查询结果集
	 */
	public ResultSet query(String sql, Object... params) {
		ResultSet rs = null;
		try {
			getConnection();
			pstmt = preparedStatement(sql, params);
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			throw new RuntimeException("执行SQL语句发生异常", e);
		}
	}

	/**
	 * 关闭连接，释放资源
	 */
	public void close() {
		// 先关闭释放预编译查询对象
		if (null != pstmt) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 最后关闭释放数据库连接对象
		try {
			if (null != conn && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭结果集对象，释放资源
	 * 
	 * @param rs 结果集对象
	 */
	public void close(ResultSet rs) {
		// 如有ResultSet对象需要先关闭
		if (null != rs) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将结果集转换成实体对象集合
	 * 
	 * @param res 结果集
	 * @param c   实体对象映射类
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static List Populate(ResultSet rs, Class cc) throws SQLException,
			InstantiationException, IllegalAccessException {

		// 结果集 中列的名称和类型的信息
		ResultSetMetaData rsm = rs.getMetaData();
		int colNumber = rsm.getColumnCount();
		List list = new ArrayList();
		// 获取cc类型的所有声明字段，包括public、private和protected
		Field[] fields = cc.getDeclaredFields();

		// 遍历每条记录
		while (rs.next()) {
			// 实例化对象
			Object obj = cc.newInstance();
			// 取出每一个字段进行赋值
			for (int i = 1; i <= colNumber; i++) {
				Object value = rs.getObject(i);
				// 匹配实体类中对应的属性
				for (int j = 0; j < fields.length; j++) {
					Field f = fields[j];
					// 数据库表字段名和类字段名称匹配时，进行赋值
					if (f.getName().equals(rsm.getColumnName(i))) {
						// 记录字段是否为私有，私有字段无法赋值，修改后才可反射赋值
						boolean flag = f.isAccessible();
						f.setAccessible(true);
						f.set(obj, value);
						f.setAccessible(flag);
						break;
					}
				}

			}
			list.add(obj);
		}
		return list;
	}
}
