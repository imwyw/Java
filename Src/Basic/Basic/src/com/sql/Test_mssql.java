package com.sql;

import java.sql.*;

public class Test_mssql {
	public static void main(String[] args) {
		try {
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=db_movie";
			String dbUser = "sa";
			String dbPassword = "123456";

			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(dbUrl, dbUser,
					dbPassword);

			Statement sqlStatement = conn.createStatement();
			ResultSet rs = sqlStatement
					.executeQuery("select * from t_movie_ex where 1=1");
			ResultSetMetaData metaData = rs.getMetaData();

			if (null != rs) {
				while (rs.next()) {
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						System.out.print(rs.getObject(i) + "\t");
					}
					System.out.println();
				}
			}
			System.out.println("完成");

			sqlStatement.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
