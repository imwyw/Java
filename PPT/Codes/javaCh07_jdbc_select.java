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

			ResultSet rs = stmt
					.executeQuery("SELECT NO,NAME,SEX,SALARY FROM EMPLOYEE;");

			if (null != rs) {
				while (rs.next()) {
					// 使用指定列的值或者指定列的名进行访问
					System.out.print("NO：" + rs.getString(1));
					System.out.println("\tNAME：" + rs.getString("NAME"));
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
