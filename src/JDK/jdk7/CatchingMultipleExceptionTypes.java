/**
 * 
 */
package jdk7;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 6��ͬʱ�������쳣����
 * <p>
 * ��Java SE 7�У�����ʹ�õ���catch���鴦��һ�ֻ�������͵��쳣�����ԸĽ����쳣���ͼ�鷽ʽ�������׳��쳣��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��19��
 */
public class CatchingMultipleExceptionTypes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		doBeforeJDK1_7();
		doAfterJDK1_7();
	}

	/**
	 * ��Java SE 7֮ǰ�������쳣����e���ڲ�ͬ�����ͣ������Ҫ����һ����������������ظ��Ĵ����Ƿǳ����ѵġ�
	 */
	private static void doBeforeJDK1_7() {
		try {
			boolean b = true;
			if (b) {
				throw new SQLException();
			} else {
				throw new IOException();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ʹ�õ���catch���鴦������쳣���ͱ�ʹ�ö��catch���飬ÿ������ֻ����һ�����͵��쳣���������ɵ��ֽ����С�����Ҳ���á�
	 */
	private static void doAfterJDK1_7() {
		try {
			boolean b = true;
			if (b) {
				throw new SQLException();
			} else {
				throw new IOException();
			}
		} catch (SQLException | IOException e) { //����쳣����֮����"|"����
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	static class FirstException extends Exception {

		private static final long serialVersionUID = 1L;
	}

	static class SecondException extends Exception {
		
		private static final long serialVersionUID = 1L;
	}

	public static void rethrowExceptionBeforeJDK1_7(String exceptionName) throws Exception {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * ����ǰ�汾��ȣ�Java SE 7 �ı������ܹ����ٴ��׳����쳣(rethrown exception)��������ȷ�ķ�����
	 * ��ʹ���������һ������������throws�Ӿ���ָ����������쳣���͡�
	 */
	public static void rethrowExceptionAfterJDK1_7(String exceptionName)
			throws FirstException, SecondException {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
