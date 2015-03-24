/**
 * 
 */
package io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * transient�ؼ�����ʾ��
 * <p>
 * �������л����п���ʱ�����ܴ���ĳ���ض��ֶβ�����Java�����л������Զ�������ָ���
 * ����ֶα�ʾ���ǲ�ϣ���������л���������Ϣ(������)��ͨ���ͻ��������������
 * ��ʹ�����е���Щ��Ϣ��private���ԣ�һ�����л�����Ϳ���ͨ����ȡ�ļ������������紫��ķ�ʽ�����ʵ�����
 * <p>
 * ��һ�ַ�ֹ��������в��ֱ����л��İ취�����ǽ���ʵ��ΪExternalizable��
 * ������û���κζ��������Զ����л������ҿ�����writeExternal()�ڲ�ֻ�����貿�ֽ�����ʽ�����л���
 * <p>
 * Ȼ��������ڲ�������һ��Serializable������ô�������л����������Զ����С�
 * Ϊ���ܹ����Կ��ƣ������� transient (˲̬)�ؼ�������ֶεعر����л���
 * <p>
 * ����Externalizable������ȱʡ����²��������ǵ��κ��ֶΣ�����transient�ؼ���ֻ�ܺ�Serializable����һ��ʹ�á�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-6-30
 */
public class TransientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "files/io.serialize/LoginInfo.obj";
		
		// ����һ���������л����浽Ӳ��
		LoginInfo logInfo = new LoginInfo("MIKE", "HelloWord");
		System.out.println("ԭʼ����" + logInfo.toString());
		
		/** ���л����� */
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(logInfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		/** �����л����� */
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			logInfo = (LoginInfo) in.readObject();
			System.out.println("��ȡ�洢���л������ļ����ɵĶ���"+logInfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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