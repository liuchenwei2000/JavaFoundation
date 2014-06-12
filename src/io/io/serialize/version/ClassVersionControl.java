/**
 * 
 */
package io.serialize.version;

import java.io.*;

/**
 * 类文件版本控制
 * <p>
 * 本例先将最初版本的对象(被注释掉的两个类)序列化到磁盘文件，
 * 然后将这两个类进行改进，然后注释掉原来的类定义。
 * 使用新版本的类，然后再试图去磁盘文件中反序列化对象，会发现没有定义。
 * serialVersionUID常量的类对象再恢复时抛出异常，而定义了serialVersionUID常量的类对象会安全的恢复。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-27
 */
public class ClassVersionControl {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize.version/version.out";

//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
//				fileName));
//		oos.writeObject(new ObjectWithSerialVersionUID());
//		oos.writeObject(new ObjectWithoutSerialVersionUID());
//		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				fileName));
		System.out.println(ois.readObject());
		System.out.println(ois.readObject());
		ois.close();
	}
}

/************
 * 新版本的对象
 ************/

/**
 * 没有serialVersionUID常量的类
 */
@SuppressWarnings("serial")
class ObjectWithoutSerialVersionUID implements Serializable {

	private String s = "";
	private int a = 1;

	public String toString() {
		return s + a;
	}
}

/**
 * 含有serialVersionUID常量的类
 */
class ObjectWithSerialVersionUID implements Serializable {

	private static final long serialVersionUID = -4666969556434213584L;

	private String s = "";
	private int a = 1;
	
	public String toString() {
		return s + a;
	}
}

/************
 * 旧版本的对象
 ************/

//@SuppressWarnings("serial")
//class ObjectWithoutSerialVersionUID implements Serializable {
//
//	private String s = "";
//
//	public String toString() {
//		return s;
//	}
//}
//
//class ObjectWithSerialVersionUID implements Serializable {
//
//	private static final long serialVersionUID = -4666969556434213584L;
//
//	private String s = "";
//
//	public String toString() {
//		return s;
//	}
//}