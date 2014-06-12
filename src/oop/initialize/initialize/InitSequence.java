/**
 * 
 */
package initialize;

/**
 * �̳��еĳ�ʼ��˳��
 * <p>
 * <li>1���Զ����ø���Ĺ��췽��</br>
 * (����super�����superָ���Ĺ��췽������û�����Զ����ø����޲ι��캯��)
 * <li>2����ʼ��ÿһ���ֶ�(û����ʽ��ʼ���ľ���Ĭ��ֵ��ʼ��)�ͳ�ʼ������</br>
 * (��ֵ�͵�Ĭ��ֵΪ0��boolean��Ĭ��ֵΪfalse��char��Ĭ��ֵΪ'\u0000'��ObjectĬ��ֵΪnull)
 * <li>3����˳��ִ�й��췽�����������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-1
 */
public class InitSequence {
	
	/**
	 * ��ʼ����ʵ�ʹ��̣� </br>
	 * <li>1���������κ����﷢��֮ǰ�������������Ĵ洢�ռ��ʼ���ɶ����Ƶ��� ��
	 * <li>2����Sandwich�����������������г�ʼ�� ��
	 * ע��</br>
	 * �ڸ���Ĺ��췽���е��õķ����Ƕ�̬�󶨵ģ������ڹ��췽���о�����������������(Ҫ����)��
	 */
	public static void main(String[] args) {
		new Son();
		new Son(20);
		// ����Ϊ��
//		Father() before show()
//		Son.show(),age = 0
//		Father() after show()
//		Son.Son(),age = 10
//		Father(int) before show()
//		Son.show(),age = 0
//		Father(int) after show()
//		Son.Son(int),age = 20
	}
}

abstract class Father {
	
	Father() {
		System.out.println("Father() before show()");
		show();
		System.out.println("Father() after show()");
	}

	Father(int n) {
		System.out.println("Father(int) before show()");
		show();
		System.out.println("Father(int) after show()");
	}
	
	abstract void show();
}

class Son extends Father {
	
	private int age = 10;

	Son() {
		System.out.println("Son.Son(),age = " + age);
	}

	Son(int n) {
		super(n);
		age = n;
		System.out.println("Son.Son(int),age = " + age);
	}

	void show() {
		System.out.println("Son.show(),age = " + age);
	}
}