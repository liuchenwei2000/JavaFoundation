package io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * �������л���ʾ��
 * <p>
 * �������л��ر�"����"��һ���ط��������������˶����"ȫ��ͼ"��������׷�ٶ����ڰ������������ò�������Щ����
 * �������ܶ�ÿ�������Ķ����ڰ��������ý���׷�٣��Դ����ơ������������Ϊ"������"��
 * <p>
 * ���һ������Ա����л��������������඼�������л���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-26
 */
public class SerializeDemo {

	/**
	 * ���л�һ������Ĳ��裺
     * ����Ҫ����ĳЩOutputStream����Ȼ�����װ��һ��ObjectOutputStream�����ڣ�
     * Ȼ��ֻ�����writeObject()���ɽ��������л��������䷢�͸�OutputStream��
     * <p>
     * Ҫ��һ�����л�ԭΪһ������
     * ��Ҫ��һ��InputStream��װ��ObjectInputStream�ڣ�Ȼ�����readObject()��
     * ����õ���һ������ת��ΪObject�����ã����Ա�������ת��Ϊ�������͡�
     * <p>
     * ע���ڶ�һ��Serializable������л�ԭ�Ĺ����У�û�е����κι�����������ȱʡ�Ĺ�������
     * ����������ͨ����InputStream��ȡ�����ݻָ������Ķ������л��������ֽڵģ���˲���InputStream��OutputStream��νṹ��
     *  
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize/car.out";
		// �������󲢴�ӡ��Ϣ
		Car car = new Car("Benz", 4);
		System.out.println("car \n" + car);
		// ���л������ļ�(�������������л���ͬһ���ļ�)
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				fileName));
		out.writeObject("Car storage\n");// ���л��ַ���
		out.writeObject(car);// ���л�Car����
		out.close();
		// ���ļ��з����л�����
		// ��ȡ����ʱ������ҪС�ĵĸ��ٴ洢�Ķ�������������ǵ�˳���Լ����ǵ�����
		// ����readObject��ÿһ�ε��ö����ȡ����ΪObject����һ������
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				fileName));
		String s = (String) in.readObject();// �����л���������ת��
		Car car2 = (Car) in.readObject();
		in.close();
		System.out.println(s + "car from file \n" + car2);
		// ���л������ڴ�
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Car storage\n");
		out2.writeObject(car);
		out2.flush();
		// ���ڴ��з����л�����
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(
				bout.toByteArray()));
		s = (String) in2.readObject();
		Car car3 = (Car) in2.readObject();
		System.out.println(s + "car from byte array \n" + car3);
	}
}

/**
 * ������
 */
class Car implements Serializable {
	
	private static final long serialVersionUID = 126606150199829302L;

	private String name;// ����
	private int wheelsNumber;// ������
	private Wheel[] wheels;// ��������

	public Car() {
		System.out.println("Default constructor");
	}

	public Car(String name, int wheelsNumber) {
		System.out.println("Car constructor");
		this.name = name;
		this.wheelsNumber = wheelsNumber;
		this.wheels = new Wheel[wheelsNumber];
		for (int i = 0; i < wheelsNumber; i++) {
			wheels[i] = new Wheel(i + 1);
		}
	}

	public String toString() {
		String s = "This is " + name + " car.";
		s += "\nThis car has " + wheelsNumber + " wheels";
		for (int i = 0; i < wheels.length; i++) {
			s += "\n" + wheels[i];
		}
		return s + "\n";
	}
}

/**
 * ������
 */
class Wheel implements Serializable {
	
	private static final long serialVersionUID = -1088116744911728192L;

	private int position;// ���ӵ�λ��

	public Wheel(int position) {
		this.position = position;
	}

	public String toString() {
		return "the " + position + " wheel.";
	}
}