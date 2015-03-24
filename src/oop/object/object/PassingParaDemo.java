/**
 * 
 */
package object;

import java.util.Arrays;

/**
 * �����Ĳ�������
 * <p>
 * ����Ĵ��ݺͷ��أ�</br>
 * <li>1����Ҫ����ͬ������������ͬһ������Ķ������</br>
 * ��һ�����ô���ĳ������֮������Ȼָ��ԭ���Ķ���
 * <li>2��һ����ԣ����÷�����Ϊ�˲�������ֵ��������Ϊ�˸ı䱻������(ĳ����)��״̬</br>
 * ͨ������Ϊ�˴�������������÷�������ñ����޸Ĳ�����
 * <li>3�����ȷʵҪ�ڷ����������޸Ĳ����������ֲ�ϣ���޸��ⲿ������
 * �Ǿ�Ӧ���ڷ����ڲ�����һ�ݲ����ĸ������Ա���ԭ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-10-8
 */
public class PassingParaDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 8;
		System.out.println("before changing : a = " + a);
		changeInt(a);
		System.out.println("after changing : a = " + a);
		System.out.println();

		String s = "out";
		System.out.println("before changing : s = " + s);
		changeString(s);
		System.out.println("after changing : s = " + s);
		System.out.println();

		Person p = new Person("old");
		System.out.println("before changing : p.getname() = " + p.getName());
		changeObject(p);
		System.out.println("after changing : p.getname() = " + p.getName());
		System.out.println();
		
		System.out.println("before changing : p.getname() = " + p.getName());
		changeObjectAttribute(p);
		System.out.println("after changing : p.getname() = " + p.getName());
		System.out.println();

		int[] array = { 2, 6, 4, 9, 8 };
		System.out.print("before changing : array = ");
		System.out.println(Arrays.toString(array));
		changeArray(array);
		System.out.print("after changing : array = ");
		System.out.println(Arrays.toString(array));
		System.out.println();

		System.out.print("before changing : array = ");
		System.out.println(Arrays.toString(array));
		changeArrayElement(array);
		System.out.print("after changing : array = ");
		System.out.println(Arrays.toString(array));
	}

	/**
	 * ���ڻ������͵Ĳ������������ݵĶ���һ���������������JavaΪʲô���ܹ�ʵ�־���swap(int a,int b)������
	 */
	private static void changeInt(int a) {
		// �����aֻ�ǲ���a��һ�������������Ĳ�����û�иı�
		a = 0;
		System.out.println("inside changeInt : a = " + a);
	}

	/**
	 * ��һ�����ô���ĳ������֮������Ȼָ��ԭ���Ķ���
	 */
	private static void changeString(String s) {
		// ���������Ҳ��һ�������Ŀ���
		s = "changed";
		System.out.println("inside changeString : s = " + s);
	}

	/**
	 * ��һ�����ô���ĳ������֮������Ȼָ��ԭ���Ķ���
	 */
	private static void changeObject(Person p) {
		p = new Person("new");
		System.out.println("inside changeObject : p.getName() = " + p.getName());
	}

	/**
	 * ��Ȼ�����Ըı����ã����ǿ��Ըı��������õĶ��������
	 */
	private static void changeObjectAttribute(Person p) {
		p.setName("changed");
		System.out.println("inside changeObjectAttribute : p.getName() = "
				+ p.getName());
	}

	/**
	 * ������ݵĲ��������飬�����ı䲻����������������Ķ���
	 */
	private static void changeArray(int[] array) {
		array = new int[3];
		array[0] = 0;
		array[1] = 0;
		array[2] = 0;
		System.out.print("inside changeArray : array = ");
		System.out.println(Arrays.toString(array));
	}

	/**
	 * ������ݵĲ���������,���Ըı�������Ԫ�ص�ֵ
	 */
	private static void changeArrayElement(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		System.out.print("inside changeArrayElement : array = ");
		System.out.println(Arrays.toString(array));
	}
}

class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}