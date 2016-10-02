package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 第一步：加载MySQL的JDBC的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 取得连接的 url,能访问MySQL数据库的用户名,密码；数据库名
			String url = "jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
			String user = "root";
			String password = "7758521";
			// 第二步：创建与MySQL数据库的连接类的实例
			conn = DriverManager.getConnection(url, user, password);
			// 第三步：用conn创建Statement对象类实例 stmt
			stmt = conn.createStatement();
			// 第四步：执行查询，用ResultSet类的对象，返回查询的结果
			String sql = "select * from age";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("id")); // 取得数据库中的数据
				System.out.println(rs.getString("desc"));
			}
		} catch (ClassNotFoundException e) {
			// 加载JDBC错误,所要用的驱动没有找到
			System.out.println("驱动加载错误");
		} catch (SQLException ex) {
			// 显示数据库连接错误或查询错误
			System.err.println("SQLException:" + ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.err.println("SQLException:" + e.getMessage());
			}
		}
	}
}