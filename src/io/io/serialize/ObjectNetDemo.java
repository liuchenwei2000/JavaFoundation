/**
 * 
 */
package io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ������ϸ����ʾ
 * <p>
 * ���������������ָ���������������õĶ���������л����ᷢ��ʲô�����
 * �������ǵ����л�״̬�ָ�����������ʱ�������������ֻ����һ����
 * ������������������л��ɶ������ļ���Ȼ���ڴ���Ĳ�ͬ���ֶ����ǽ��з����л����ֻ������� 
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-27
 */
public class ObjectNetDemo {

	/**
	 * ����ͨ���������������鿴������Ч��
	 * 
	 * ����������Щ�������л���ԭ��Ķ����ַ��ԭ���ĵ�ַ��ͬ(������ܻ��ƻ��ڴ�)
	 * ���� animals1 �� animals2 ��ȴ��������ͬ�ĵ�ַ���������߹�����Ǹ�ָ��house������
	 * ��һ���棬���ָ� animals3 ʱ��ϵͳ�޷�֪����һ�����ڵĶ����ǵ�һ�����ڶ���ı���
	 * ��������������ȫ��ͬ�Ķ�������ֻҪ���κζ������л�����һ����
	 * �Ϳ��Իָ�����д��ʱһ���Ķ�����������û���κ������ظ����Ƴ��Ķ���
	 * 
	 * ����뱣��ϵͳ״̬���ȫ�������ǽ�����Ϊ"ԭ��"�����������л�
	 * ������л���ĳЩ��������ȥ������һЩ�������������л�����Ķ���
	 * ��˵ȵȣ���ô���޷���ȫ�ر���ϵͳ״̬
	 * ȡ����֮���ǣ�������ϵͳ״̬�����ж�������ĳ����һ����(��List)��
	 * ����һ�������н�������ֱ��д����Ȼ��ͬ��ֻ��һ�η������ã������Խ���ָ�
	 * ��ֻ����һ�� writObject(Collection) �� readObject()����
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		// ������Animal��������ͬһ��house����
		animals.add(new Animal("Dog", house));
		animals.add(new Animal("Cat", house));
		animals.add(new Animal("Bird", house));
		System.out.println("animals��\n" + animals);
		// �����List���л����ڴ��1
		ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(buffer1);
		// List��д��������
		oos.writeObject(animals);
		oos.writeObject(animals); 
		oos.close();
		// �����List���л����ڴ��2
		ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(buffer2);
		oos.writeObject(animals);
		oos.close();
		// �����л�����List
		ObjectInputStream ois1 = new ObjectInputStream(
				new ByteArrayInputStream(buffer1.toByteArray()));
		ObjectInputStream ois2 = new ObjectInputStream(
				new ByteArrayInputStream(buffer2.toByteArray()));
		// ��ȡ�ڴ��1�ĵ�һ������
		List<?> animals1 = (List<?>) ois1.readObject();
		// ��ȡ�ڴ��1�ĵڶ�������
		List<?> animals2 = (List<?>) ois1.readObject();
		// ��ȡ�ڴ��2��List����
		List<?> animals3 = (List<?>) ois2.readObject();
		ois1.close();
		ois2.close();
		System.out.println("animals1��\n" + animals1);
		System.out.println("animals2��\n" + animals2);
		System.out.println("animals3��\n" + animals3);
	}

}

class House implements Serializable {

	private static final long serialVersionUID = 7111825389860589381L;
}

class Animal implements Serializable {

	private static final long serialVersionUID = 1944038041155987297L;

	private String name;
	private House house;

	Animal(String name, House house) {
		this.name = name;
		this.house = house;
	}

	public String toString() {
		return name + "(" + super.toString() + ") in " + house + "\n";
	}
}