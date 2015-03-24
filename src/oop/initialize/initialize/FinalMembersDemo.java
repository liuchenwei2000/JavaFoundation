/**
 * 
 */
package initialize;

/**
 * final �����ֶεĳ�ʼ��ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-8
 */
public class FinalMembersDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle circle = new Circle(1);
		System.out.println(circle.getArea());
	}
}

/**
 * Բ��
 * <p>
 * һ���ֶα�final������Ҫ���㣺</br>
 * <li>1���ֶ����������������ǲ��ɱ�ģ�
 * <li>2�������󱻴�����ʱ����ֶε�ֵ�ǿɵõģ�
 * <li>3�������󱻴�����ʱ����ֶξͿ��Ա���ֵ��ʼ����
 */
class Circle {

	/** final static ���ε��ֶ������ʼ����ʱ���Ӧ�ñ���ʼ�� */
	private static final double PI = getPI();
	/** final �������ε��ֶ��ڶ��󱻴�����ʱ���Ӧ�ñ���ʼ�� */
	private final double r;

	public Circle(int r) {
		this.r = r;
	}

	private static double getPI() {
		return Math.PI;
	}

	public double getR() {
		return r;
	}

	/**
	 * ���
	 */
	public double getArea() {
		return PI * r * r;
	}
}