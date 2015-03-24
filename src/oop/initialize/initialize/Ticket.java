/**
 * 
 */
package initialize;

/**
 * Ʊ��(��ʼ��������ʾ)
 * <p>
 * ��ʼ������һ�����������ڲ���ĳ�ʼ��(��Ϊ��Щ��û�й��캯��)��Ҳ��������ִ�й��캯������Ҫִ�е���䡣
 * �������ֳ�ʼ�������ǲ����ᳫ��(�ƻ�����ƺͿɶ���)����������˹��캯�����ܵ���������������ʹ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-11-8
 */
public class Ticket {
	
	private static int code = 0;// ���
	
	/*
	 * ��ʼ���������ڸ��ӵĳ�ʼ��(����Ϊ��ʾ)
	 * 
	 * ������齫���ڹ��췽����ִ�У��������ĳ�ʼ�����һ������˳��ִ�С�
	 * ��������л�����ܲ��쳣����ô���еĹ��췽����Ӧ�������׳����쳣��
	 */
	{
		if(code < 0)
			throw new Exception();
		code++;
		System.out.print("Ticket code:");
	}
	
	/*
	 * static��ʼ�������в�׼���׳��ܲ��쳣����ʹ�ڹ��췽���������׳��쳣Ҳ�����ԡ�
	 */
	static {
		if (code < 0) {
			// throw new Exception();
		}
	}
	
	public Ticket() throws Exception{
		System.out.println(code);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Ticket();
			new Ticket();
			new Ticket();
			new Ticket();
			new Ticket();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}