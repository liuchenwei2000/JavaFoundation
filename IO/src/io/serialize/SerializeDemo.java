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
 * 对象序列化演示类
 * <p>
 * 对象序列化特别"聪明"的一个地方是它不仅保存了对象的"全景图"，而且能追踪对象内包含的所有引用并保存那些对象。
 * 接着又能对每个这样的对象内包含的引用进行追踪；以此类推。这种情况被称为"对象网"。
 * <p>
 * 如果一个类可以被序列化，它的所有子类都可以序列化。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-26
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
	 * 序列化对象到磁盘文件（可以将多个对象序列化到同一个文件）
	 * <p>
	 * 序列化一个对象的步骤：
     * 首先要创建某些 OutputStream 对象，然后将其封装在一个 ObjectOutputStream 对象内，
     * 然后只需调用 writeObject(object) 即可将对象序列化，并将其发送给 OutputStream 。
	 */
	private static void writeObjectToDisk(Object object,String filePath) throws IOException{
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(filePath));
			out.writeObject("Object storage\n");// 序列化字符串
			out.writeObject(object);// 序列化参数对象
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
	 * 从文件中反序列化对象
	 * <p>
	 * 要将一个序列还原为一个对象：
     * 需要将一个 InputStream 封装在 ObjectInputStream 内，然后调用 readObject()，
     * 最后获得的是一个向上转型为 Object 的引用，所以必须向下转型为具体类型。
     * <p>
     * 注意在对一个 Serializable 对象进行还原的过程中，没有调用任何构造器，包括缺省的构造器。
     * 对象序列化是面向字节的，因此采用 InputStream 和 OutputStream 层次结构。
	 */
	private static void readObjectFromDisk(String filePath) throws Exception{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(filePath));
			// 读取对象时，必须要小心的跟踪存储对象的数量、顺序以及类型
			// 对于 readObject 的每一次调用都会读取类型为 Object 的下一个对象
			String s = (String) in.readObject();// 反序列化对象并向下转型
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
	 * 序列化对象到内存
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
	 * 从内存中反序列化对象
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
 * 汽车类
 */
class Car implements Serializable {
	
	private static final long serialVersionUID = 126606150199829302L;

	private String name;// 名称
	private int wheelsNumber;// 车轮数
	private Wheel[] wheels;// 车轮数组

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
 * 车轮类
 */
class Wheel implements Serializable {
	
	private static final long serialVersionUID = -1088116744911728192L;

	private int position;// 轮子的位置

	public Wheel(int position) {
		this.position = position;
	}

	public String toString() {
		return "the " + position + " wheel.";
	}
}
