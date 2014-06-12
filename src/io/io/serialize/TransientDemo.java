/**
 * 
 */
package io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * transient�ؼ�����ʾ��
 * <p>
 * �������л����п���ʱ�����ܴ���ĳ���ض��Ӷ�������Java�����л������Զ�������ָ���
 * ����Ӷ����ʾ���ǲ�ϣ���������л���������Ϣ(������)��ͨ���ͻ��������������
 * ��ʹ�����е���Щ��Ϣ��private���ԣ�һ�����л�����Ϳ���ͨ����ȡ�ļ������������紫��ķ�ʽ�����ʵ�����
 * <p>
 * ��һ�ַ�ֹ��������в��ֱ����л��İ취�����ǽ���ʵ��ΪExternalizable��
 * ������û���κζ��������Զ����л������ҿ�����writeExternal()�ڲ�ֻ�����貿�ֽ�����ʽ�����л���
 * <p>
 * Ȼ��������ڲ�������һ��Serializable������ô�������л����������Զ����С�
 * Ϊ���ܹ����Կ��ƣ�������transient(˲ʱ)�ؼ��������عر����л���
 * ������˼��"�����鷳�㱣���ָ�����--���Լ��ᴦ���"��
 * <p>
 * ����Externalizable������ȱʡ����²��������ǵ��κ��ֶΣ�
 * ����transient�ؼ���ֻ�ܺ�Serializable����һ��ʹ�á�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-6-30
 */
public class TransientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize/LoginInfo.obj";
		// ����һ���������л����浽Ӳ��
		LoginInfo logInfo = new LoginInfo("MIKE", "HelloWord");
		System.out.println("ԭʼ����");
		System.out.println(logInfo.toString());
		/** ���л����� */
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				fileName));
		o.writeObject(logInfo);
		o.close();
		Thread.sleep(1000);
		/** �����л����� */
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				fileName));
		logInfo = (LoginInfo) in.readObject();
		in.close();
		System.out.println("��ȡ�洢���л������ļ����ɵĶ���");
		System.out.println(logInfo.toString());
	}
}

/**
 * ��¼��Ϣ��
 */
class LoginInfo implements Serializable {

	private static final long serialVersionUID = -4354200758987066819L;
	
	private Date loginDate = new Date();// ��¼����
	private String userID;// ��¼��
	// �����б�transient���ε��򲻻ᱻ���л�
	private transient String password;// ����

	public LoginInfo(String userID, String password) {
		this.userID = userID;
		this.password = password;
	}

	public String toString() {
		String password = null;
		if (this.password == null) {
			password = "I don't know.";
		} else {
			password = this.password;
		}
		return "Login info: \n" + "User: " + userID + "\nDate : "
				+ loginDate.toString() + "\nPassword: " + password;
	}		
}