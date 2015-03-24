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
 * transient关键字演示类
 * <p>
 * 当对序列化进行控制时，可能存在某个特定字段不想让Java的序列化机制自动保存与恢复。
 * 如果字段表示的是不希望将其序列化的敏感信息(如密码)，通常就会面临这种情况，
 * 即使对象中的这些信息是private属性，一经序列化处理就可以通过读取文件或者拦截网络传输的方式来访问到它。
 * <p>
 * 有一种防止对象的敏感部分被序列化的办法，就是将类实现为Externalizable。
 * 这样就没有任何东西可以自动序列化，并且可以在writeExternal()内部只对所需部分进行显式的序列化。
 * <p>
 * 然而如果正在操作的是一个Serializable对象，那么所有序列化操作都会自动进行。
 * 为了能够予以控制，可以用 transient (瞬态)关键字逐个字段地关闭序列化。
 * <p>
 * 由于Externalizable对象在缺省情况下不保存它们的任何字段，所以transient关键字只能和Serializable对象一起使用。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-6-30
 */
public class TransientDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "files/io.serialize/LoginInfo.obj";
		
		// 创建一个对象并序列化保存到硬盘
		LoginInfo logInfo = new LoginInfo("MIKE", "HelloWord");
		System.out.println("原始对象：" + logInfo.toString());
		
		/** 序列化对象 */
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
		
		/** 反序列化对象 */
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			logInfo = (LoginInfo) in.readObject();
			System.out.println("读取存储序列化对象文件生成的对象："+logInfo.toString());
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
 * 登录信息类
 */
class LoginInfo implements Serializable {

	private static final long serialVersionUID = -4354200758987066819L;
	
	private Date loginDate = new Date();// 登录日期
	private String userID;// 登录名
	// 对象中被transient修饰的域不会被序列化
	private transient String password;// 密码

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