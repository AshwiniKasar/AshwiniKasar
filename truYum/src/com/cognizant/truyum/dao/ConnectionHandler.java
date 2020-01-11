package com.cognizant.truyum.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	public static Connection getConnection() {
		BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");
		Properties pro = new Properties();
		try {
			pro.load(bufferedInputStream);
		} catch (IOException e) {
			System.out.println("unable to load connection.properties file");
		}
		String driver = (String) pro.get("driver");
		System.out.println("Driver Name " + driver);
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("unable to load mysql driver" + e.getMessage());

		}
		String user = (String) pro.get("user");
		String password = (String) pro.get("password");
		String url = (String) pro.get("connection-url");
		System.out.println("DB Details ->" + user + "------" + password + "-------" + url);
		Connection connection = null;

		try {
			// Connection with specific server
			// driver manager class will attempt attempt to load
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);

		} catch (SQLException e) {
			System.out.println("unable to connect database");
		}
		return connection;
	}

}
