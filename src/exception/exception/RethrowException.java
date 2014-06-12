/**
 * 
 */
package exception;

/**
 * �����׳��쳣��ʾ
 * <p>
 * �����쳣����쳣�׸���һ�������е��쳣�������ͬһ��try��������catch�־佫�ᱻ���ԡ�
 * �쳣�����������Ϣ�����Ա��֣����Ը�һ�������в�����쳣�Ĵ��������Եõ�����������Ϣ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-21
 */
public class RethrowException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			notFillStackTrace();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		try {
			fillStackTrace();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	}

	private static void original() throws Exception {
		System.out.println("originating the exception in original()");
		throw new Exception("Message : thrown from original()");
	}
	
	/**
	 * ���ֻ�ǰѵ�ǰ�쳣���������׳�����ôprintStackTrace()���� 
	 * ��ʾ����ԭ���쳣�׳���ĵ���ջ��Ϣ���������������׳������Ϣ
	 */
	private static void notFillStackTrace() throws Exception {
		try {
			original();
		} catch (Exception e) {
			System.out.println("Inside notFillStackTrace().e.printStacktrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}

	/**
	 * Ҫ����������Ϣ�����Ե���fillStackTrace()��������һ��Throwable���� 
	 * ����ͨ���ѵ�ǰ����ջ��Ϣ����ԭ���Ǹ��쳣�����������
	 * ����fillStackTrace()����һ�оͳ����쳣���·�������
	 */
	private static void fillStackTrace() throws Exception {
		try {
			original();
		} catch (Exception e) {
			System.out.println("Inside fillStackTrace().e.printStacktrace()");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}
}