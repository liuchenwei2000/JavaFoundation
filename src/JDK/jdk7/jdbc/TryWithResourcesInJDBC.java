/**
 * 
 */
package jdk7.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC4.1������
 * <p>
 * Java SE 7��Connection��ResultSet��Statement��ʵ����Closeable�ӿڣ����Կ���ʹ��  
 * try-with-resources ������JDBC resources���Ӷ������Զ��ر������Դ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��22��
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
	 * ��Java SE 7֮ǰ��Ϊ��ȷ����Դ���رգ����ܻ��д���´��룺
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
	 * ��Java SE 7�У�����������Ĵ������滻����Ĵ����ˣ�
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
		return null;// ģ�ⷵ�����ݿ�����
	}
}
