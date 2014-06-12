/**
 * 
 */
package io.serialize.version;

import java.io.*;

/**
 * ���ļ��汾����
 * <p>
 * �����Ƚ�����汾�Ķ���(��ע�͵���������)���л��������ļ���
 * Ȼ������������иĽ���Ȼ��ע�͵�ԭ�����ඨ�塣
 * ʹ���°汾���࣬Ȼ������ͼȥ�����ļ��з����л����󣬻ᷢ��û�ж��塣
 * serialVersionUID������������ٻָ�ʱ�׳��쳣����������serialVersionUID�����������ᰲȫ�Ļָ���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-27
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
 * �°汾�Ķ���
 ************/

/**
 * û��serialVersionUID��������
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
 * ����serialVersionUID��������
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
 * �ɰ汾�Ķ���
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