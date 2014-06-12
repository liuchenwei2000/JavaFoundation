/**
 * 
 */
package primitive;

/**
 * double��װ����ʾ
 * <p>
 * ����������������float�İ�װ��ķ���������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-13
 */
public class DoubleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Double���еĳ���NaN(Not a Number)��ʾ����һ����
		 * �������������ȡһ��NaNֵ��������������һ��ֵ�Ƿ���NaN
		 * ���� NaN == NaN һֱ����false����ΪNaN����һ����
		 * ����ж�һ�����Ƿ���NaNӦ��ʹ��isNaN����
		 */
		Double d = 3.2;
		if (!d.isNaN())
			System.out.println(d + " is a number");
		if (Double.isNaN(0.0 / 0.0))
			System.out.println("0.0/0.0 is not a number");
		if (Double.NaN != Double.NaN)
			System.out.println("Double.NaN != Double.NaN");
		/*
		 * isInfinite���������ж�һ��double�Ƿ��������
		 */
		d = 1.0 / 0.0;
		if (d.isInfinite())
			System.out.println("1.0 / 0.0 is infinite");
		if (Double.isInfinite(d))
			System.out.println("1.0 / 0.0 is infinite");
		/*
		 * intValue�������ظ�����������ֵ(�൱��ǿ��ת����int)
		 */
		d = 3.6;
		System.out.println(d.intValue());
		d = -3.6;
		System.out.println(d.intValue());
	}
}