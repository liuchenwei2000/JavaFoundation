/**
 * 
 */
package jdk7.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC4.1新特性
 * <p>
 * Java SE 7中Connection、ResultSet和Statement都实现了Closeable接口，所以可以使用  
 * try-with-resources 语句调用JDBC resources，从而可以自动关闭相关资源。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月22日
 */
public class TryWithResourcesInJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		doBeforeJDK1_7();
		doAfterJDK1_7();
	}

	/**
	 * 在Java SE 7之前，为了确保资源被关闭，可能会编写如下代码：
	 */
	private static void doBeforeJDK1_7() throws Exception {
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery("select * from user");
			// do with ResultSet
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
	
	/**
	 * 在Java SE 7中，可以用下面的代码来替换上面的代码了：
	 */
	private static void doAfterJDK1_7() throws Exception {
		try (Connection con = getConnection();
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery("select * from user")) {
			// do with ResultSet
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection() {
		return null;// 模拟返回数据库连接
	}
}
