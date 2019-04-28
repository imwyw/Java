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

			// 创建员工表
			int res = stmt.executeUpdate(
					"INSERT INTO EMPLOYEE (NO,NAME,SEX,SALARY) VALUES ('1','JACK','M',5000)"
							+ ",('2','LUCY','F',6000)");

			if (res > 0) {
				// 返回受影响的行数
				System.out.println("添加成功！");
			}

			System.out.println("关闭连接...");

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
