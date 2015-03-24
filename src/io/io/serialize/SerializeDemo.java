package io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "files/io.serialize/car.out";
		Car car = new Car("Benz", 4);
		System.out.println("car \n" + car);
		
		try {
			System.out.println("******************writeObjectToDisk*****************");
			writeObjectToDisk(car, filePath);
			
			System.out.println("******************readObjectFromDisk*****************");
			readObjectFromDisk(filePath);
			
			System.out.println("******************writeObjectToMemory*****************");
			byte[] result = writeObjectToMemory(car);
			
			System.out.println("******************readObjectFromMemory*****************");
			readObjectFromMemory(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���л����󵽴����ļ������Խ�����������л���ͬһ���ļ���
	 * <p>
	 * ���л�һ������Ĳ��裺
     * ����Ҫ����ĳЩ OutputStream ����Ȼ�����װ��һ�� ObjectOutputStream �����ڣ�
     * Ȼ��ֻ����� writeObject(object) ���ɽ��������л��������䷢�͸� OutputStream ��
	 */
	private static void writeObjectToDisk(Object object,String filePath) throws IOException{
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(filePath));
			out.writeObject("Object storage\n");// ���л��ַ���
			out.writeObject(object);// ���л���������
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * ���ļ��з����л�����
	 * <p>
	 * Ҫ��һ�����л�ԭΪһ������
     * ��Ҫ��һ�� InputStream ��װ�� ObjectInputStream �ڣ�Ȼ����� readObject()��
     * ����õ���һ������ת��Ϊ Object �����ã����Ա�������ת��Ϊ�������͡�
     * <p>
     * ע���ڶ�һ��Serializable������л�ԭ�Ĺ����У�û�е����κι�����������ȱʡ�Ĺ�������
     * �������л��������ֽڵģ���˲��� InputStream �� OutputStream ��νṹ��
	 */
	private static void readObjectFromDisk(String filePath) throws Exception{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(filePath));
			// ��ȡ����ʱ������ҪС�ĵĸ��ٴ洢�����������˳���Լ�����
			// ����readObject��ÿһ�ε��ö����ȡ����ΪObject����һ������
			String s = (String) in.readObject();// �����л���������ת��
			Car car = (Car) in.readObject();
			System.out.println(s + "object from file \n" + car);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
	
	/**
	 * ���л������ڴ�
	 */
	private static byte[] writeObjectToMemory(Object object) throws IOException{
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject("Object storage\n");
		out.writeObject(object);
		out.flush();
		
		return bout.toByteArray();
	}
	
	/**
	 * ���ڴ��з����л�����
	 */
	private static void readObjectFromMemory(byte[] bytes) throws Exception {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new ByteArrayInputStream(bytes));
			String s = (String) in.readObject();
			Car car3 = (Car) in.readObject();
			System.out.println(s + "car from byte array \n" + car3);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
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