/**
 * 
 */
package object.dispatch;

/**
 * ��̬����ɺͶ�̬��������ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2010-6-11
 */
public class DispatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		// ��̬�����
		father.operation(1);// ���ý���int���Ͳ����İ汾
		father.operation("1");// ���ý���String���Ͳ����İ汾
		// ��̬������
		father.action();// ����Father.action()
		son.action();// ����Son.action()
	}
}

class Father {

	public void operation(int a) {
		System.out.println("This is an integer " + a);
	}

	public void operation(String s) {
		System.out.println("This is an string " + s);
	}

	public void action() {
		System.out.println("Father.action()");
	}
}

class Son extends Father {

	public void action() {
		System.out.println("Son.action()");
	}
}