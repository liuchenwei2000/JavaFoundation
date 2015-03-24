/**
 * 
 */
package exception;

/**
 * Java缺陷：异常丢失
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-5
 */
public class ExceptionLost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExceptionLost el = new ExceptionLost();
			try {
				el.test();
			} finally {
				el.dispose();
			}
		} catch (Exception e) {
			// 输出是 a simple exception，而VeryImportantException不见了
			System.out.println(e);
		}
		// 更简单的一种异常丢失的情形
//		try {
//			throw new RuntimeException();
//		} finally {
//			// return放在finally块中的话不会再有任何异常被抛出
//			return;
//		}
	}

	private void test() throws Exception {
		throw new VeryImportantException();
	}

	private void dispose() throws Exception {
		throw new SimpleException();
	}
}

class VeryImportantException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "a very important exception";
	}
}

class SimpleException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "a simple exception";
	}
}