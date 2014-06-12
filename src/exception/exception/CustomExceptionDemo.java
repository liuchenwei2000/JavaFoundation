/**
 * 
 */
package exception;

/**
 * �Զ����쳣��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class CustomExceptionDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10, b = 0;
		try {
			if (b == 0) {
				throw new DivisorIsZeroException();
			}
			int c = a / b;
			System.out.println(c);
		} catch (DivisorIsZeroException e) {
			// ��׼��������ӡ���쳣��������Ϣ
			System.err.println("�쳣 : " + e.getMessage());
			// ��ջ����(stack trace)��һ���������ù��̵��б��������˳���ִ���з����ĵ��ô���
			e.printStackTrace();
		} 
	}
}

/**
 * ����Ϊ0�쳣(�Զ����쳣)
 * <p>
 * ���������׼�쳣�඼���ܹ���ֵ�������������⣬��ô����Ҫ�����Լ����쳣���ˡ�
 * ��Ҫ����ֻ�Ƕ���һ��������Exception���࣬����������Exception������ࡣ
 * ϰ���ϣ��������Ӧ�ð���������������һ����Ĭ�Ϲ���������һ���Ǵ�����ϸ������Ϣ�Ĺ�������
 */
class DivisorIsZeroException extends RuntimeException {
	
	private static final long serialVersionUID = 1947531179165400147L;
	
	/** �쳣��ʾ��Ϣ */
	private static final String message = "��������Ϊ0!";

	public DivisorIsZeroException() {
		super();
	}

	public DivisorIsZeroException(String message) {
		super(message);
	}

	public DivisorIsZeroException(Throwable e) {
		super(e);
	}

	public DivisorIsZeroException(String message, Throwable e) {
		super(message, e);
	}

	public String getMessage() {
		return message;
	}
}