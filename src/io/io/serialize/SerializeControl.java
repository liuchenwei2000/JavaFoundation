/**
 * 
 */
package io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ���л�����
 * <p>
 * �ṩ��Externalizable(���������Զ���)������������ ��
 * <p>
 * ��������ر���Ҫʵ��Externalizable�ӿڣ���ô������һ�ַ�������ʵ��Serializable�ӿڣ�
 * �����(ע����"���"������"����"����"ʵ��")��ΪwriteObject()�� readObject()�ķ�����
 * ����һ���������л����߱������л����ͻ��Զ��طֱ����������������
 * Ҳ����˵��ֻҪ�ṩ���������������ͻ�ʹ�����Ƕ�����ȱʡ�����л����� ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-26
 */
public class SerializeControl {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ObjectX ox = new ObjectX("Test1", "Test2");
		System.out.println("Serialize:\n" + ox);
		/** ���л������ڴ� */
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(buffer);
		/*
		 * ��ObjectOutputStream����writeObject()ʱ�������������
		 * �ж����Ƿ�ӵ���Լ���writeObject()����(���Ǽ��ӿ�
		 * ���������û�нӿڣ�Ҳ���Ǽ��������ͣ��������÷�������������������)
		 * ����У���ô�ͻ�ʹ��������readObject()Ҳ���������Ƶķ���
		 * �������ǽ���������Ψһ��ʵ���еķ���������ȷʵ�е�Ź�
		 */
		oos.writeObject(ox);
		/** �����л��ڴ��еĶ��� */
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
				buffer.toByteArray()));
		ox = (ObjectX) ois.readObject();
		System.out.println("\nDeserialize:\n" + ox);
	}
}

/**
 * �ڱ����У���һ��String�ֶ�����ͨ�ֶΣ�����һ����transient�ֶ�
 * ����֤����transient�ֶ���defaultWriteObject()��������
 * ��transient�ֶα����ڳ�������ȷ����ͻָ�
 * �ֶ����ڹ������ڲ��������ڶ��崦���г�ʼ����
 * �Դ˿���֤ʵ�����ڷ����л���ԭ�ڼ�û�б�һЩ�Զ����Ƴ�ʼ��
 */
class ObjectX implements Serializable {

	private static final long serialVersionUID = -7469587839431573217L;

	private String a;
	private transient String b;

	public ObjectX(String a, String b) {
		this.a = "Not Transient: " + a;
		this.b = "Transient: " + b;
	}

	public String toString() {
		return this.a + "\n" + this.b;
	}

	/***
	 * �����������׼ȷ�ķ���ǩ���� 
	 * private void writeObject(ObjectOutputStream stream) 
	 * throws IOException 
	 * 
	 * private void readObject(ObjectInputStream stream) 
	 * throws IOException, ClassNotFoundException 
	 * 
	 * �û��Ƶ�ִ��ϸ�ڣ�
	 * �ڵ���ObjectOutputStream.writeObject()ʱ
	 * ���������ݵ�Serializable���󣬿����Ƿ�ʵ�������Լ���writeObject()
	 * ��������������������������л����̲���������writeObject()
	 * readObject()�����������ͬ
	 * 
	 * �����и����ɣ�
	 * �����ǵ�writeObject()�ڲ������Ե���
	 * ObjectOutputStream.defaultWriteObject()
	 * ��ѡ��ִ��ȱʡ��writeObject()
	 * ���Ƶأ���readObject()�ڲ���Ҳ���Ե���
	 * ObjectOutputStream.defaultReadObject()
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		/*
		 * �������ʹ��ȱʡ����д�����ķ�transient���֣���ô�������
		 * defaultWriteObject()��ΪwriteObject()�еĵ�һ������
		 * ����defaultReadObject()��ΪreadObject()�еĵ�һ������
		 */
		stream.defaultWriteObject();
		stream.writeObject(this.b);
	}

	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject();
		this.b = (String) stream.readObject();
	}
}