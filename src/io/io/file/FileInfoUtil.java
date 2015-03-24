/**
 * 
 */
package io.file;

import java.io.File;

/**
 * �ļ���Ϣ������
 * <p>
 * ��ʾFile��Ļ�ȡ�ļ���Ϣ�ķ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-2-1
 */
public class FileInfoUtil {

	/**
	 * ��ӡ�ļ�����Ϣ(��·�������Ƶȵ�)
	 */
	public static void printFileInfo(File file) {
		if (file == null || (!file.exists()))
			throw new RuntimeException("�ļ�������");
		// File ������Ŀ¼
		if (file.isDirectory()) {
			System.out.println("It is a directory.");
		} 
		// File �����Ǳ�׼�ļ�
		else if (file.isFile()) {
			System.out.println("It is a file.");
		}
		System.out.println(getFileInfo(file));
	}

	/**
	 * �����ļ�����Ϣ(��·�������Ƶȵ�)
	 */
	private static String getFileInfo(File file) {
		StringBuilder info = new StringBuilder();
		info.append("Absolute path��");
		// ���س���·�����ľ���·�����ַ���
		info.append(file.getAbsolutePath());
		info.append("\n Can read��");
		// Ӧ�ó����Ƿ���Զ�ȡ�˳���·������ʾ���ļ�
		info.append(file.canRead());
		info.append("\n Can write��");
		// Ӧ�ó����Ƿ�����޸Ĵ˳���·������ʾ���ļ�
		info.append(file.canWrite());
		info.append("\n getName��");
		// �����ɴ˳���·������ʾ���ļ���Ŀ¼������
		info.append(file.getName());
		info.append("\n getPath��");
		// ���˳���·����ת��Ϊһ��·�����ַ���
		info.append(file.getPath());
		info.append("\n getParent��");
		// ���ش˳���·�����ĸ�·������·�����ַ���
		info.append(file.getParent());
		info.append("\n length����");
		// �����ɴ˳���·������ʾ���ļ��Ĵ�С(��λ �ֽ�)�������·������ʾһ��Ŀ¼���򷵻�ֵ�ǲ�ȷ���ġ�
		info.append(file.length());
		info.append("\n lastModified��");
		// ���ش˳���·������ʾ���ļ����һ�α��޸ĵ�ʱ��
		info.append(file.lastModified());
		return info.toString();
	}
}