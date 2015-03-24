/**
 * 
 */
package io.serialize;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * �����л�����ʱѰ������ʾ
 * <p>
 * ��һ��������������л�״̬�лָ���������Щ�����Ǳ�����أ����罫һ���������л�����ͨ�����罫����Ϊ�ļ�
 * ���͸���һ̨���������ô��һ̨������ϵĳ������ֻ���ø��ļ��������������������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-26
 */
public class FindClassInDeserialize {

	/**
	 * �����ж����Ӧ�����ļ��Ѿ���ɾ���ˣ���������ģ��������������䴫��һ�����л�����ʱ�ָ���������Ρ�
	 * 
	 * ���ļ��Ͷ�ȡ�����е����ݶ���ҪLost��Class���󣬶�JVM�Ҳ���Lost.class��������������classpath�ڣ�������ȴ������·��֮�ڣ�
	 * �����ͻ�õ�һ��ClassNotFoundException ���쳣�������ܹ���֤Lost���ڣ�������������ʧ�����뱣֤JVM���ҵ���ص�.class�ļ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// �������л��ļ�·��
		String fileName = "files/io.serialize/Lost.out";
		ObjectInputStream in = null;
		
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(fileName)));
			System.out.println(in.readObject().getClass());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}