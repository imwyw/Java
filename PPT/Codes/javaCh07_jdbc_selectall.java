package com.sql;

import java.sql.*;

public class EmpCreateTable {
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

			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE;");

			// 结果集列信息
			ResultSetMetaData rsmd = rs.getMetaData();

			if (null != rs) {
				System.out.print(rsmd.getColumnName(1) + "\t");
				System.out.print(rsmd.getColumnName(2) + "\t");
				System.out.print(rsmd.getColumnName(3) + "\t");
				System.out.print(rsmd.getColumnName(4) + "\t");
				System.out.println();

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
