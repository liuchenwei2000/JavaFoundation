/**
 * 
 */
package generic;

/**
 * ���͵ļ̳�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-8-3
 */
public class InheritInGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Car<Father>��Car<Son>����Carԭ�����͵����࣬����Car<Father>��Car<Son>֮��û���κι�ϵ
		// ���Father��Son�ļ̳в��û���κι�ϵ
		Car<Father> c1 = new Car<Father>();
		System.out.println(c1.getClass());
		Car<Son> c2 = new Car<Son>();
		System.out.println(c2.getClass());
		
		// SmallCar<Father>��SmallCar<Son>����SmallCarԭ�����͵�����
		SmallCar<Father> sc1 = new SmallCar<Father>();
		SmallCar<Son> sc2 = new SmallCar<Son>();
		// ֤��SmallCar<Father>��Car<Father>������
		c1 = sc1;
		// ֤��SmallCar<Son>��Car<Son>������
		c2 = sc2;
	}
}

class Car<T> {
}

class SmallCar<T> extends Car<T> {
}

class Father {
}

class Son extends Father {
}