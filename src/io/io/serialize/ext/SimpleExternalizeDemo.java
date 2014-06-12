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
 * Externalizable����ʾ��
 * <p>
 * �������л�ʱ���������Ҫ����ô���أ�
 * ���磬Ҫ��������İ�ȫ���⣬���Ҳ�ϣ�������ĳһ���ֱ����л���
 * ����һ�����󱻻�ԭ�Ժ�ĳ�Ӷ�����Ҫ���´������Ӷ����ؽ����Ӷ������л���
 * ����Щ��������£���ͨ��ʵ��Externalizable�ӿڴ���ʵ��Serializable�ӿڣ�
 * �������л����̽��п��ƣ����Externalizable�ӿڼ̳���Serializable�ӿڡ�
 * ͬʱ����������������writeExternal()��readExternal()��
 * �����������������л��ͷ����л��Ĺ����б��Զ����ã��Ա�ִ��һЩ���������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-26
 */
public class SimpleExternalizeDemo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize.ext/object.out";
		System.out.println("Constructing objects:");
		ObjectA oa = new ObjectA();
		ObjectB ob = new ObjectB();
		/** ���л����������� */
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				fileName));
		System.out.println("Saving objects:");
		o.writeObject(oa);
		o.writeObject(ob);
		o.close();
		/** �����л����������� */
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				fileName));
		System.out.println("Recovering objects:");
		System.out.println("ObjectA");
		/*
		 * �ָ�oa�󣬻����ObjectAȱʡ������������ָ�һ��Serializable����ͬ
		 * ���ں��ߣ�������ȫ�����洢�Ķ�����λΪ���������죬�������ù�����
		 * ����һ��Externalizable����������ͨ��ȱʡ���������ᱻ����
		 * (����������ʱ�ĳ�ʼ��)Ȼ�����readExternal()
		 * ����ȱʡ�Ĺ��������ᱻ���ã�����ʹExternalizable���������ȷ����Ϊ
		 */
		oa = (ObjectA) in.readObject();
		System.out.println("ObjectB");
		// ���������׳��쳣����Ϊ���Ĺ������Ƿ�public��
		ob = (ObjectB)in.readObject(); 
	}
}

/**
 * ����Ĺ������ǹ��е�
 */
class ObjectA implements Externalizable {
	
	public ObjectA() {
		System.out.println("ObjectA Constructor");
	}

	/**
	 * �������������л�ʱ�ᱻ�Զ�����
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("ObjectA.writeExternal");
	}

	/**
	 * �������������л�ʱ�ᱻ�Զ�����
	 */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("ObjectA.readExternal");
	}
}
/**
 * ����Ĺ������ǰ���˽�е�
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