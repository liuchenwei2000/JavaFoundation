/**
 * 
 */
package object.clone.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ͨ�����л�ʵ��(��)��¡
 * <p>
 * ��дSerializable������ף���Ҫ����������Ҫ���Ѹ���Ĺ�����
 * ��¡���ڱ�дʱҪ����Щ��������ʵ�ʸ��ƶ���ʱ���൱�򵥡�
 * <p>
 * ���ۣ�ͨ�����л����п�¡����Ҫ��ʱ���clone()Ҫ�ࡣ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-6-6
 */
public class CloneUsingSerialization {
	
	/** ����¡������ */
	public static final int SIZE = 25000;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Thing4[] a = new Thing4[SIZE];
		Thing4[] b = new Thing4[SIZE];
		
		for (int i = 0; i < a.length; i++){
			a[i] = new Thing4();
			b[i] = new Thing4();
		}
		// ͨ�����л���¡����
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		long start = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++){
			o.writeObject(a[i]);
		}
		
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
				buf.toByteArray()));
		Thing4[] c = new Thing4[SIZE];
		for (int i = 0; i < c.length; i++){
			c[i] = (Thing4) in.readObject();
		}
		long end = System.currentTimeMillis();
		System.out.println("Clone via serialization: " + (end - start)
				+ " Milliseconds");
		
		// ͨ�� clone ������¡����
		start = System.currentTimeMillis();
		Thing4[] d = new Thing4[SIZE];
		for (int i = 0; i < d.length; i++) {
			d[i] = (Thing4) b[i].clone();
		}
		end = System.currentTimeMillis();
		System.out.println("Clone via cloning: " + (end - start)
				+ " Milliseconds");
	}
}

class Thing1 implements Serializable {
	private static final long serialVersionUID = -3397318072808524048L;
}

class Thing2 implements Serializable {
	private static final long serialVersionUID = 8913305526061656966L;
	Thing1 o1 = new Thing1();
}

class Thing3 implements Cloneable,Serializable {
	
	private static final long serialVersionUID = -31531948352923012L;

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("Thing3 can't clone");
		}
		return o;
	}
}

class Thing4 implements Cloneable,Serializable {
	
	private static final long serialVersionUID = 506274341027159899L;
	
	private Thing3 o3 = new Thing3();

	public Object clone() {
		Thing4 o = null;
		try {
			o = (Thing4) super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("Thing4 can't clone");
		}
		o.o3 = (Thing3) o3.clone();
		return o;
	}
}