package com.wkd.util;

import java.sql.*;

/**
 * 数据库工具类
 * @author fxs
 *
 */
public class DBUtil {

	/**
	 * 获取Connection对象
	 * @return
	 */
	public static Connection getConnection(){
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");//注册数据库
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("未找到驱动类...");
		}
		try {
			//获取连接URL--uniform resource locator 主协议:子协议://服务器地址:端口号/数据库&字符集
			String url = "jdbc:mysql://127.0.0.1:3306/myblog";
			Connection conn = DriverManager
					.getConnection(url, "root", "123456");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库服务器错误...");
		}
		return null;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public static void closeAll(Connection conn,Statement stmt,PreparedStatement pStat,ResultSet rs){
		if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
		if (pStat != null) {
            try {
            	pStat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

	}
	
	public static void main(String[] args){
		Connection conn =DBUtil.getConnection();
		System.out.println(conn == null ? "failure" : "success");
	}
}
