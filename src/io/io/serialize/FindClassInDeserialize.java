/**
 * 
 */
package io.serialize;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * �����л�����ʱѰ������ʾ
 * <p>
 * ��һ��������������л�״̬�лָ���������Щ�����Ǳ�����أ�
 * ���罫һ���������л�����ͨ�����罫����Ϊ�ļ����͸���һ̨�������
 * ��ô��һ̨������ϵĳ������ֻ���ø��ļ��������������������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-26
 */
public class FindClassInDeserialize {

	/**
	 * �����ж����Ӧ�����ļ��Ѿ���ɾ���� 
	 * ��������ģ��������������䴫��һ�����л�����ʱ�ָ����������
	 * 
	 * ���ļ��Ͷ�ȡ�����е����ݶ���ҪLost��Class����
	 * ��Java������Ҳ���Lost.class(������������classpath�ڣ�������ȴ������·��֮��)
	 * �����ͻ�õ�һ��ClassNotFoundException ���쳣
	 * �����ܹ���֤Lost���ڣ�������������ʧ�����뱣֤Java��������ҵ���ص�.class�ļ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// �������л��ļ�·��
		String fileName = "files/io.serialize/Lost.out";
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(fileName)));
		System.out.println(in.readObject().getClass());
		in.close();
	}
}