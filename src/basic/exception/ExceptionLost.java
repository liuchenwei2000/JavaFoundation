/**
 * 
 */
package exception;

/**
 * Javaȱ�ݣ��쳣��ʧ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-5
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
			// ����� a simple exception����VeryImportantException������
			System.out.println(e);
		}
		// ���򵥵�һ���쳣��ʧ������
//		try {
//			throw new RuntimeException();
//		} finally {
//			// return����finally���еĻ����������κ��쳣���׳�
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