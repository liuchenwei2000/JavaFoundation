/**
 * 
 */
package initialize.staticmbers;

/**
 * Cups��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-8-28
 */
public class Cups {
	
	static Cup c1;
	static Cup c2;
	
	/*
	 * ��̬��ʼ�����飬�൱�ڶ����̬��� ��
	 * 
	 * ��δ����ִ��һ�Σ�
	 * ���״�����������һ������ʱ�����״η������������ľ�̬���ݳ�Աʱ����ʹ��δ���ɹ�����Ķ���ʱִ�С�
	 * ֻ�����ڿ��з���static�ֶκͱ��������Ҳ������׳��κ��ܲ��쳣��
	 */
	static {
		c1 = new Cup(1);
		c2 = new Cup(2);
	}

	public Cups() {
		System.out.println("Cups()");
	}
}