package com.dao.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyna.com.MDU;


public class BaseDao {

	private static final String USER = "wm";
	private static final String PASSWORD = "wm";
	private static final String DRIVER_CLASS = "org.h2.Driver";

	/**
	 * 得到数据库连接
	 * 
	 * @param dbName
	 *            数据库名称
	 * @return 数据库连接
	 */
	public Connection getCon(String dbName) {
		String JDBC_URL = "jdbc:h2:"+MDU.mapStrObject.get("dbPath").toString()+dbName;
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接资源
	 * 
	 * @param con
	 *            连接
	 * @param sta
	 *            执行
	 * @param psta
	 *            预执行
	 * @param rs
	 *            结果集
	 */
	public void closeCon(Connection con, Statement sta, PreparedStatement psta,
			ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (psta != null) {
			try {
				psta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
