/**
 * 
 */
package object.clone;

/**
 * �ɹ���¡�ĵ���ʵ����ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-6-6
 */
public class SuccessfulClone {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyObject a = new MyObject(11);
		MyObject b = incrementPara(a);
		System.out.println("a == b: " + (a == b));
		System.out.println("a = " + a + ", b = " + b);
		MyObject c = new MyObject(47);
		MyObject d = incrementClonedPara(c);
		System.out.println("c == d: " + (c == d));
		System.out.println("c = " + c + ", d = " + d);
	}

	/**
	 * ���ز�������ִ��increment()������
	 */
	public static MyObject incrementPara(MyObject v) {
		v.increment();
		return v;
	}

	/**
	 * ���ز������󱻿�¡��Ķ���ִ��increment()������
	 */
	public static MyObject incrementClonedPara(MyObject v) {
		v = (MyObject) v.clone();
		v.increment();
		return v;
	}

}

/**
 * ʵ����Cloneable�ӿ�
 */
class MyObject implements Cloneable {

	private int n;

	public MyObject(int n) {
		this.n = n;
	}

	/**
	 * <li>1��Ϊ����clone()�������Ա����ʣ����뽫������Ϊpublic��
	 * <li>2����Ϊ����clone()�����ĳ�ʼ�����֣�Ӧ�õ��û����clone()��
	 */
	public Object clone() {
		Object o = null;
		/*
		 * ���뽫super.clone()���� try���ڣ��Բ���Ӧ�÷������쳣(��Ϊ�Ѿ�ʵ���� Cloneable�ӿ�)��
		 */
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("MyObject can't clone");
		}
		return o;
	}

	public int getValue() {
		return n;
	}

	public void setValue(int n) {
		this.n = n;
	}

	public void increment() {
		n++;
	}

	public String toString() {
		return Integer.toString(n);
	}
}