package com.sql;

import java.sql.*;
import com.mysql.*;

public class Test_mysql {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	static final String USER_NAME = "root";
	static final String USER_PASS = "123456";

	public static void main(String[] args) {
		try {

			Class.forName(JDBC_DRIVER);
			System.out.println("打开连接...");
			Connection conn = DriverManager.getConnection(DB_URL, USER_NAME,
					USER_PASS);

			Statement sqlStatement = conn.createStatement();
			ResultSet rs = sqlStatement
					.executeQuery("select * from course where 1=1");
			ResultSetMetaData metaData = rs.getMetaData();

			if (null != rs) {
				while (rs.next()) {
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						System.out.print(rs.getObject(i) + "\t");
					}
					System.out.println();
				}
			}
			System.out.println("关闭连接...");

			rs.close();
			sqlStatement.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
