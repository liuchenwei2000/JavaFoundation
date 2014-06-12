/**
 * 
 */
package exception.inherit;

/**
 * �쳣��̳���ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-9
 */
public class ExceptionInheritDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Father s = new Son();
			s.test();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * ����
 */
class Father {
	
	public Father() throws Exception {
	}

	public void test() throws Exception {
		System.out.println("No Exception!");
	}
}

/**
 * ����
 */
class Son extends Father {
	
	/**
	 * �쳣���ƶԹ������������ã�Son�Ĺ��������׳��κ��쳣�� 
	 * ��Ϊ����Ĺ�����������ĳ�ַ�ʽ������ ���������๹�������쳣˵������������๹�������쳣˵�������ǲ��ܲ�����๹�����׳����쳣��
	 */
	public Son() throws Exception {
	}

	/**
	 * �����Ƿ�����ʱ��ֻ���׳��ڻ��෽�����쳣˵�����г����쳣 ��
	 * ��������Щ�쳣�������쳣��Ҳ���Բ��׳��κ��쳣(Ĭ���׳�����÷����������쳣)��
	 * ��������ʹ�õ�����ʹ�õĴ���Ӧ�õ�����������ʱ��һ���ܹ�������
	 */
	public void test() {
		System.out.println("Exception!");
		throw new RuntimeException();
	}
}