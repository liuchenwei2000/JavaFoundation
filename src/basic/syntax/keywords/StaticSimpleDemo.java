/**
 * 
 */
package syntax.keywords;

/**
 * ��̬��Ա��ʾ��
 * <p>
 * static������ĳ���ֶ�ʱ��ı����ݴ����ķ�ʽ����Ϊһ��static�ֶζ�ÿ������˵��ֻ��һ�ݴ洢�ռ䣬����static�ֶ����Ƕ�ÿ��������һ���洢�ռ䡣
 * </br>
 * ���static������ĳ������������Ϊ���ڲ������κζ����ǰ���µ���������������κζ�����ø÷�����Ч��һ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-11-8
 */
public class StaticSimpleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Share share1 = new Share();
		System.out.println(Share.a);
		share1.add();
		Share share2 = new Share();
		System.out.println(Share.a);
		share2.add();
		System.out.println(Share.a);
	}
}

class Share {
	
	static int a = 0;// ���еĶ������һ��

	public void add() {
		a++;
	}
}