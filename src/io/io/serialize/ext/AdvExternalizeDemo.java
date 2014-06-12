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
 * Externalizable高级演示类
 * <p>
 * Externalizable对象的缺省行为不会序列化和反序列化任何成员信息。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-26
 */
public class AdvExternalizeDemo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize.ext/oc.out";
		System.out.println("Constructing objects:");
		ObjectC oc = new ObjectC("string ", 47);
		System.out.println(oc);
		/** 序列化对象ObjectC */
		System.out.println("\nSaving object:");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				fileName));
		out.writeObject(oc);
		out.close();
		/** 反序列化对象ObjectC */
		System.out.println("\nRecovering object:");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				fileName));
		oc = (ObjectC) in.readObject();
		System.out.println(oc);
	}
}

/**
 * 本类中有两个成员 s 和 i
 * <p>
 * 成员 s 和 i 只在第二个构造器中被初始化，而不是在缺省的构造器中被初始化。
 * 这意味着假如不在readExternal()中初始化 s 和 i，s 就会为 null，而 i 就会为零。
 * 因为在创建对象的第一步中将对象的存储空间清除为0。
 * <p>
 * 如果从一个Externalizable对象继承，通常需要调用基类版本的，
 * writeExternal()和readExternal()来为基类组件提供恰当的存储和恢复功能。
 */
class ObjectC implements Externalizable {

	// 字段都没有初始化
	private String s;
	private int i;

	/**
	 * 默认构造器中没有初始化各个字段
	 */
	public ObjectC() {
		System.out.println("ObjectC Constructor");
	}

	public ObjectC(String s, int i) {
		this.s = s;
		this.i = i;
		System.out.println("ObjectC(String s, int i)");
	}

	/**
	 * 需要在writeExternal()方法中将来自对象的重要信息手工写入
	 * 没有任何缺省行为来为Externalizable对象写入任何成员信息
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.s);
		out.writeInt(this.i);
		System.out.println("ObjectC.writeExternal");
	}

	/**
	 * 必须在readExternal()方法中手工恢复成员信息
	 */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// 如果没有下面两行，那么 s 和 i 都会是默认值(null 和 0)
		this.s = (String) in.readObject();
		this.i = in.readInt();
		System.out.println("ObjectC.readExternal");
	}

	public String toString() {
		return "s = " + s + "\ni = " + i;
	}
}