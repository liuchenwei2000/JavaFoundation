package io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
	 * 序列化一个对象的步骤：
     * 首先要创建某些OutputStream对象，然后将其封装在一个ObjectOutputStream对象内，
     * 然后只需调用writeObject()即可将对象序列化，并将其发送给OutputStream。
     * <p>
     * 要将一个序列还原为一个对象：
     * 需要将一个InputStream封装在ObjectInputStream内，然后调用readObject()，
     * 最后获得的是一个向上转型为Object的引用，所以必须向下转型为具体类型。
     * <p>
     * 注意在对一个Serializable对象进行还原的过程中，没有调用任何构造器，包括缺省的构造器。
     * 整个对象都是通过从InputStream中取得数据恢复而来的对象序列化是面向字节的，因此采用InputStream和OutputStream层次结构。
     *  
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize/car.out";
		// 创建对象并打印信息
		Car car = new Car("Benz", 4);
		System.out.println("car \n" + car);
		// 序列化对象到文件(将两个对象序列化到同一个文件)
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				fileName));
		out.writeObject("Car storage\n");// 序列化字符串
		out.writeObject(car);// 序列化Car对象
		out.close();
		// 从文件中反序列化对象
		// 读取对象时，必须要小心的跟踪存储的对象的数量、它们的顺序以及它们的类型
		// 对于readObject的每一次调用都会读取类型为Object的另一个对象
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				fileName));
		String s = (String) in.readObject();// 反序列化对象并向下转型
		Car car2 = (Car) in.readObject();
		in.close();
		System.out.println(s + "car from file \n" + car2);
		// 序列化对象到内存
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Car storage\n");
		out2.writeObject(car);
		out2.flush();
		// 从内存中反序列化对象
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(
				bout.toByteArray()));
		s = (String) in2.readObject();
		Car car3 = (Car) in2.readObject();
		System.out.println(s + "car from byte array \n" + car3);
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