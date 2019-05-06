package com.sql;

import java.sql.*;

public class TestSqlPrepared {
	public static void main(String[] args) {
		try {
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			String DB_URL = "jdbc:mysql://localhost:3306/test";
			String USER_NAME = "root";
			String USER_PASS = "123456";
			Class.forName(JDBC_DRIVER);// 注册驱动

			System.out.println("打开连接...");
			Connection conn = DriverManager.getConnection(DB_URL, USER_NAME,
					USER_PASS);
			Statement stmt = conn.createStatement();

			String name = "jack";
			String password = "' OR 1=1#";
			String sql = "SELECT * FROM T_USER WHERE NAME='" + name
					+ "' AND PASSWORD='" + password + "'";

			ResultSet rs = stmt.executeQuery(sql);

			// 结果集列信息
			ResultSetMetaData rsmd = rs.getMetaData();

			if (null != rs) {
				while (rs.next()) {
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.print(rs.getString(i) + "\t");
					}
					System.out.println();
				}
			}

			System.out.println("关闭连接...");

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
