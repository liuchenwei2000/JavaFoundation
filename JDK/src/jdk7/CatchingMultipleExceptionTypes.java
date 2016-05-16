/**
 * 
 */
package jdk7;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 6，同时捕获多个异常类型
 * <p>
 * 在Java7中，可以使用单个catch语句块处理一种或多种类型的异常，并以改进的异常类型检查方式来重新抛出异常。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月19日
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
	 * 在Java SE 7之前，由于异常变量e存在不同的类型，因此想要创建一个公共方法来清除重复的代码是非常困难的。
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
	 * 使用单个catch语句块处理多种异常类型比使用多个catch语句块，每个语句块只处理一种类型的异常所编译生成的字节码更小，因此也更好。
	 */
	private static void doAfterJDK1_7() {
		try {
			boolean b = true;
			if (b) {
				throw new SQLException();
			} else {
				throw new IOException();
			}
		} catch (SQLException | IOException e) { //多个异常类型之间用"|"隔开
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
	 * 与以前版本相比，Java SE 7 的编译器能够对再次抛出的异常(rethrown exception)做出更精确的分析。
	 * 这使得你可以在一个方法声明的throws从句中指定更具体的异常类型。
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
