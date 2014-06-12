/**
 * 
 */
package initialize.staticmbers;

/**
 * Cup��(��ʾ��̬�����;�̬����)
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-8-28
 */
public class Cup {
	
	/** ��̬�����᳣פ�ڴ棬ֱ����������ñ�������������������(share)��һ��*/
	private static int counter = initCounter();
	/** ʵ��������Ϊÿ�������ṩһ������ */
	private String number = initNumber();
	
	public Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
		counter++;
		number = counter + "";
	}

	public void f(int marker)
    {
    	System.out.println("f("+marker+")");
    }
    
    /**
	 * The advantage of private static methods is that they can be reused later
	 * if you need to reinitialize the class variable
	 */
	private static int initCounter() {
		return 0;
	}
    
	/**
	 * ������ʼ��ʵ���������Է�ֹ���า�Ǹ÷���
	 */
	protected final String initNumber() {
		return getCounter() + "";
	}
	
    /**
	 * ��̬������һ��������Ϊ�˷��ʾ�̬����
	 */
    public static int getCounter() {
    	return counter;
    }
    
    public String getNumber() {
    	return number;
    }
}