/**
 * 
 */
package syntax;

/**
 * ���������ʾ��
 * <p>
 * ���� ++ ����Ԫ������ ?:
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-11-5
 */
public class SpecialOperatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1;
		System.out.println("now a is " + a);
		int b = (++a) * 3;// ��ִ�� ++ ������ִ������
		System.out.println("a after ++a is " + a);
		System.out.println("b = (++a) * 3 is " + b);
		System.out.println();
		
		a = 1;
		System.out.println("now a is " + a);
		b = (a++) * 3;// ��ִ���������ִ�� ++
		System.out.println("a after a++ is " + a);
		System.out.println("b = (a++) * 3 is " + b);
		
		/*
		 * ��Ԫ�����?:��ʹ�ø�ʽ��booleanExpression ? value1 : value2
		 * ��booleanExpressionΪtrue����value1�����򷵻�value2��
		 * ������Ԫ������ķ���ֵ���뱻��ȡ�򱻱��档
		 * 
		 */
		System.out.println(a + "," + b + "�нϴ���� " + (a > b ? a : b));
	}
}