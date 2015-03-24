/**
 * 
 */
package exception;

/**
 * �����׳��µ��쳣(��װ�쳣)��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-21
 */
public class RethrowNewException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			throwTwoExceptionUnknown();
		} catch (TwoException e) {
			// ���쳣��֪���Լ�����throwTwoException����֪��throwOneException
			System.out.println("catch TwoException in main()");
			e.printStackTrace(System.out);
		}
		System.out.println("******************************************");
		
		try {
			throwTwoExceptionKnown();
		} catch (TwoException e) {
			// ���쳣����֪���Լ�����throwTwoException���һ�֪��throwOneException
			System.out.println("catch TwoException in main()");
			e.printStackTrace(System.out);
			// �������쳣ʱ���Ϳ���ʹ��getCause()���ԭʼ�쳣
			System.out.println("cause : " + e.getCause().getMessage());
		}
		throwExceptionNotAllowed();
	}

	private static void throwOneException() throws OneException {
		System.out.println("originating OneException in throwOneException()");
		throw new OneException("thrown from throwOneException()");
	}

	private static void throwTwoExceptionUnknown() throws TwoException {
		try {
			throwOneException();
		} catch (OneException e) {
			System.out.println("catch OneException in throwTwoException()");
			e.printStackTrace(System.out);
			// ��һ��catch�Ӿ��У�Ҳ�����׳�һ�����쳣����������Ŀ����ϣ���ı��쳣������
			throw new TwoException("thrown from throwTwoException()");
		}
	}
	
	private static void throwTwoExceptionKnown() throws TwoException {
		try {
			throwOneException();
		} catch (OneException e) {
			System.out.println("catch OneException in throwTwoException()");
			e.printStackTrace(System.out);
			/*
			 * �쳣������
			 * 
			 * �����Ҫ�ڲ���һ���쳣���׳���һ���쳣������ϣ����ԭʼ�쳣����Ϣ��������������Ҫʹ���쳣����
			 * ʹ��initCause(Throwable)�������԰�ԭʼ�쳣���ݸ��µ��쳣��ʹ�ü�ʹ�ڵ�ǰλ��
			 * �������׳����µ��쳣��Ҳ��ͨ������쳣��׷�ٵ��쳣���������λ�á�
			 */
			TwoException te = new TwoException("thrown from throwTwoException()");
			te.initCause(e);
			throw te;
		}
	}
	
	/**
	 * ���һ�������г���һ�� �Ѽ���쳣�����������׳�������ô��װ������ʮ�����ã�
	 * ���Բ�������Ѽ���쳣����������װ������ʱ�쳣��
	 */
	private static void throwExceptionNotAllowed() {
		try {
			throwOneException();
		} catch (OneException e) {
			throw new RuntimeException(e);
		}
	}
}

class OneException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public OneException(String msg) {
		super(msg);
	}
}

class TwoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TwoException(String msg) {
		super(msg);
	}
}