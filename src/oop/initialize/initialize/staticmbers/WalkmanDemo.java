/**
 * 
 */
package initialize.staticmbers;

/**
 * ��ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-8
 */
public class WalkmanDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Walkman w1 = WalkmanFactory.createWalkman();
		System.out.println(w1.toString());
		Walkman w2 = WalkmanFactory.createWalkman();
		System.out.println(w2.toString());
		Walkman w3 = WalkmanFactory.createWalkman();
		System.out.println(w3.toString());
		Walkman w4 = WalkmanFactory.createWalkman();
		System.out.println(w4.toString());
		Walkman w5 = WalkmanFactory.createWalkman();
		System.out.println(w5.toString());
	}
}