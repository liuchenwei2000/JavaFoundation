/**
 * 
 */
package puzzler;

/**
 * int��������ĳ���(�ͳ˷�)
 * <p>
 * �ڲ��������л�������ݶ�ʧ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-6
 */
public class DivisionBetweenInts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 8;
		int b = 5;
		double result = a/b;
		/*
		 * �����8/5 = 1.0 
		 * ��Ϊ������a/bʱ������int�����������������Ľ������int��������
		 * �����int�������ڸ�ֵ��resultʱ�ᱻ������double�ͣ����������Ѿ���׼ȷ�ˡ�
		 */
		System.out.println(a + "/" + b + " = " + result);
		
		/** ������� */
		/*
		 * �ڳ�������֮ǰ����int������Ϊdouble�ͣ����������Ľ������׼ȷ��double��ֵ��
		 */
		result = (double)a/b;
		System.out.println(a + "/" + b + " = " + result);
		
		/*********ͬ����int���������������************/
		long la = 24 * 60 * 60 * 1000 * 1000;
		/*
		 * �����la = 500654080
		 * ͬ������Ϊ�����˷�����ʱ����int�͵����������Ľ��86400000000�Ѿ�����int�ͱ�ʾ�����ޡ�
		 * ������������ˣ����õ�����ȷ�Ľ����
		 */
		System.out.println("la = " + la);
		
		/** ������� */
		/*
		 *�ڳ˷�����֮ǰ��int������������long��
		 */
		la = 24L * 60 * 60 * 1000 * 1000;
		System.out.println("la = " + la);
	}
}