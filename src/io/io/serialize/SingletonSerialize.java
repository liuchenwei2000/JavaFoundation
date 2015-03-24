/**
 * 
 */
package io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例对象的序列化
 * <p>
 * 将一个单例对象(或几个特定的对象)序列化后，然后再反序列化回来后，得到的对象是一个新的对象并不是原来的单例对象。
 * 尽管对象所属类的构造器是私有的，但是序列化机制还是可以创建新的对象。
 * 要解决这个问题，需要定义一个特殊的序列化方法 readResolve()。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-27
 */
public class SingletonSerialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "files/io.serialize/earth.out";
		String fileName2 = "files/io.serialize/moon.out";
		
		try {
			test(Earth.EARTH, fileName);
			test(Moon.MOON, fileName2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试参数对象序列化到文件中后再反序列化回来的对象是否和原对象是同一个(==)
	 */
	private static void test(Object object, String fileName) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(object);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Object inobject = ois.readObject();
		ois.close();

		System.out.println(object == inobject ? "The same object." : "Not the same object.");
	}
}

/**
 * 本类单例并且没有定义任何和序列化有关的方法
 */
class Earth implements Serializable {

	private static final long serialVersionUID = -5750929151734111534L;

	public static final Earth EARTH = new Earth();

	private Earth() {
		// singleton
	}
}

/**
 * 本类单例并且定义了自己的readResolve方法
 */
class Moon implements Serializable {

	private static final long serialVersionUID = -2559495685236196317L;

	public static final Moon MOON = new Moon();

	private Moon() {
		// singleton
	}

	/**
	 * 如果readResolve方法被定义了，它将在对象反序列化后被调用。
	 * 它必须返回一个对象，也就是readObject方法返回的类型。
	 */
	protected Object readResolve() throws ObjectStreamException {
		// 这里返回本类的单例对象。
		return MOON;
	}
}