/**
 * 
 */
package lang;

/**
 * Math���һ�㷽��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class MathDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = -5.8;
		System.out.println(a + "�ľ���ֵ�� " + Math.abs(a));
		double b = 2.5;
		System.out.println(b + "���������룺 " + Math.round(b));
		System.out.println(b + "�Ķ������� " + Math.ceil(b));
		System.out.println(b + "�ĵ������� " + Math.floor(b));
		System.out.println(b + "��ƽ������ " + Math.sqrt(b));
		System.out.println(b + "���������� " + Math.cbrt(b));
		System.out.println(b + "����ӽ���������doubleֵ�� " + Math.rint(b));
		a = -1;
		b = 2;
		System.out.println(a + "��" + b + "�нϴ���ǣ�" + Math.max(a, b));
		System.out.println(a + "��" + b + "�н�С���ǣ�" + Math.min(a, b));
		System.out.println(b + "��" + a + "�η��� " + Math.pow(b, a));
		System.out.println("������0��1������ǣ� " + Math.random());
	}
}