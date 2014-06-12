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
 * Externalizable�߼���ʾ��
 * <p>
 * Externalizable�����ȱʡ��Ϊ�������л��ͷ����л��κγ�Ա��Ϣ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-26
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
		/** ���л�����ObjectC */
		System.out.println("\nSaving object:");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				fileName));
		out.writeObject(oc);
		out.close();
		/** �����л�����ObjectC */
		System.out.println("\nRecovering object:");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				fileName));
		oc = (ObjectC) in.readObject();
		System.out.println(oc);
	}
}

/**
 * ��������������Ա s �� i
 * <p>
 * ��Ա s �� i ֻ�ڵڶ����������б���ʼ������������ȱʡ�Ĺ������б���ʼ����
 * ����ζ�ż��粻��readExternal()�г�ʼ�� s �� i��s �ͻ�Ϊ null���� i �ͻ�Ϊ�㡣
 * ��Ϊ�ڴ�������ĵ�һ���н�����Ĵ洢�ռ����Ϊ0��
 * <p>
 * �����һ��Externalizable����̳У�ͨ����Ҫ���û���汾�ģ�
 * writeExternal()��readExternal()��Ϊ��������ṩǡ���Ĵ洢�ͻָ����ܡ�
 */
class ObjectC implements Externalizable {

	// �ֶζ�û�г�ʼ��
	private String s;
	private int i;

	/**
	 * Ĭ�Ϲ�������û�г�ʼ�������ֶ�
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
	 * ��Ҫ��writeExternal()�����н����Զ������Ҫ��Ϣ�ֹ�д��
	 * û���κ�ȱʡ��Ϊ��ΪExternalizable����д���κγ�Ա��Ϣ
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.s);
		out.writeInt(this.i);
		System.out.println("ObjectC.writeExternal");
	}

	/**
	 * ������readExternal()�������ֹ��ָ���Ա��Ϣ
	 */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// ���û���������У���ô s �� i ������Ĭ��ֵ(null �� 0)
		this.s = (String) in.readObject();
		this.i = in.readInt();
		System.out.println("ObjectC.readExternal");
	}

	public String toString() {
		return "s = " + s + "\ni = " + i;
	}
}