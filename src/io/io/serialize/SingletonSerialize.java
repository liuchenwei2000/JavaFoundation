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
 * ������������л�
 * <p>
 * ��һ����������(�򼸸��ض��Ķ���)���л���Ȼ���ٷ����л������󣬵õ��Ķ�����һ���µĶ��󲢲���ԭ���ĵ�������
 * ���ܶ���������Ĺ�������˽�еģ��������л����ƻ��ǿ��Դ����µĶ���
 * Ҫ���������⣬��Ҫ����һ����������л����� readResolve()��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-27
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
	 * ���Բ����������л����ļ��к��ٷ����л������Ķ����Ƿ��ԭ������ͬһ��(==)
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
 * ���൥������û�ж����κκ����л��йصķ���
 */
class Earth implements Serializable {

	private static final long serialVersionUID = -5750929151734111534L;

	public static final Earth EARTH = new Earth();

	private Earth() {
		// singleton
	}
}

/**
 * ���൥�����Ҷ������Լ���readResolve����
 */
class Moon implements Serializable {

	private static final long serialVersionUID = -2559495685236196317L;

	public static final Moon MOON = new Moon();

	private Moon() {
		// singleton
	}

	/**
	 * ���readResolve�����������ˣ������ڶ������л��󱻵��á�
	 * �����뷵��һ������Ҳ����readObject�������ص����͡�
	 */
	protected Object readResolve() throws ObjectStreamException {
		// ���ﷵ�ر���ĵ�������
		return MOON;
	}
}