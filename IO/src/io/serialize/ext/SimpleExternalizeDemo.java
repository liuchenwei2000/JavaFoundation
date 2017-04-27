/**
 * 
 */
package io.serialize.ext;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Externalizable 简单演示类
 * <p>
 * 对象序列化时有特殊的需要该怎么办呢？
 * 例如，要考虑特殊的安全问题，而且不希望对象的某一部分被序列化；
 * 或者一个对象被还原以后，某子对象需要重新创建，从而不必将该子对象序列化。
 * 在这些特殊情况下，可通过实现Externalizable接口代替实现Serializable接口，
 * 来对序列化过程进行控制，这个Externalizable接口继承了Serializable接口。
 * 同时增添了两个方法：writeExternal()和readExternal()。
 * 这两个方法会在序列化和反序列化的过程中被自动调用，以便执行一些特殊操作。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-26
 */
public class SimpleExternalizeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "files/io.serialize.ext/object.out";
		System.out.println("Constructing objects:");
		
		ObjectA oa = new ObjectA();
		ObjectB ob = new ObjectB();
		
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		try {
			/** 序列化这两个对象 */
			out = new ObjectOutputStream(new FileOutputStream(
					fileName));
			System.out.println("Saving objects:");
			out.writeObject(oa);
			out.writeObject(ob);
			out.flush();
			
			/** 反序列化这两个对象 */
			in = new ObjectInputStream(new FileInputStream(fileName));
			System.out.println("Recovering objects:");
			System.out.println("ObjectA");
			
			/*
			 * 恢复oa后，会调用ObjectA缺省构造器，这与恢复一个Serializable对象不同，对于后者，对象完全以它存储的二进制位为基础来构造，而不调用构造器。
			 * 而对一个Externalizable对象，所有普通的缺省构造器都会被调用（包括在域定义时的初始化）然后调用readExternal()
			 * 所有缺省的构造器都会被调用，才能使Externalizable对象产生正确地行为。
			 */
			oa = (ObjectA) in.readObject();
			System.out.println("ObjectB");
			// 下面这句会抛出异常，因为它的构造器是非public的
			ob = (ObjectB)in.readObject(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

/**
 * 本类的构造器是公有的
 */
class ObjectA implements Externalizable {
	
	public ObjectA() {
		System.out.println("ObjectA Constructor");
	}

	/**
	 * 本方法对象序列化时会被自动调用
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("ObjectA.writeExternal");
	}

	/**
	 * 本方法对象反序列化时会被自动调用
	 */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("ObjectA.readExternal");
	}
}

/**
 * 本类的构造器是包级私有的
 */
class ObjectB implements Externalizable {
	
	ObjectB() {
		System.out.println("ObjectB Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("ObjectB.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("ObjectB.readExternal");
	}
}
