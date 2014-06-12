/**
 * 
 */
package object.clone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ǳ��¡��ʾ
 * <p>
 * ʹ��Java��׼���ArrayList��Ϊ���ӡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-6-5
 */
public class ShallowClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Int> v = new ArrayList<Int>();
		for (int i = 0; i < 10; i++) {
			v.add(new Int(i));
		}
		System.out.println("v: " + v);
		/*
		 * ArrayList��clone()�������������Զ���¡ ArrayList�а�����ÿ������
		 * ��¡��ArrayListֻ�ǽ�ԭArrayList�еĶ������������ͨ����Ϊǳ�㿽��(shallow copy)��
		 * ��Ϊ��ֻ���ƶ���"����"�Ĳ��֡�ʵ�ʵĶ��������¼�������ɣ�
		 * �����"����"���ɶ����������������ָ��Ķ����ټ�����Щ������ָ��Ķ��󣬵ȵȡ�
		 * ͨ����֮Ϊ"������"������Щȫ�����Ƽ�Ϊ��㿽��(deep copy)��
		 */
		ArrayList<?> v2 = (ArrayList<?>) v.clone();
		Iterator<?> e = v2.iterator();
		while (e.hasNext()) {
			((Int) e.next()).increment();
		}
		System.out.println("v: " + v);
	}
}

class Int {
	
	private int i;

	public Int(int i) {
		this.i = i;
	}

	public void increment() {
		i++;
	}

	public String toString() {
		return Integer.toString(i);
	}
}