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
	 */
	public static void main(String[] args) {
		String fileName = "files/io.serialize.ext/object.out";
		System.out.println("Constructing objects:");
		
		ObjectA oa = new ObjectA();
		ObjectB ob = new ObjectB();
		
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		try {
			/** ���л����������� */
			out = new ObjectOutputStream(new FileOutputStream(
					fileName));
			System.out.println("Saving objects:");
			out.writeObject(oa);
			out.writeObject(ob);
			out.flush();
			
			/** �����л����������� */
			in = new ObjectInputStream(new FileInputStream(fileName));
			System.out.println("Recovering objects:");
			System.out.println("ObjectA");
			
			/*
			 * �ָ�oa�󣬻����ObjectAȱʡ������������ָ�һ��Serializable����ͬ�����ں��ߣ�������ȫ�����洢�Ķ�����λΪ���������죬�������ù�������
			 * ����һ��Externalizable����������ͨ��ȱʡ���������ᱻ���ã�����������ʱ�ĳ�ʼ����Ȼ�����readExternal()
			 * ����ȱʡ�Ĺ��������ᱻ���ã�����ʹExternalizable���������ȷ����Ϊ��
			 */
			oa = (ObjectA) in.readObject();
			System.out.println("ObjectB");
			// ���������׳��쳣����Ϊ���Ĺ������Ƿ�public��
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