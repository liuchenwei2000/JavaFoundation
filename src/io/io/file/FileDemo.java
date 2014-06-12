/**
 * 
 */
package io.file;

import java.io.File;
import java.io.IOException;

/**
 * File����ʾ
 * <p>
 * File����ܴ���һ���ض��ļ������ƣ����ܴ���һ��Ŀ¼�����ơ�
 * File�಻����ֻ������ڵ��ļ���Ŀ¼��Ҳ�������������µ�Ŀ¼���ϲ����ڵ�����Ŀ¼·����
 * 
 * ����ע�����ļ����ݣ���File���ע�����ļ��ڴ����ϵĴ洢��
 *
 * �������ڣ�2008-2-1
 *
 * @author ����ΰ
 */
public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* 
		 * ͨ��������·�����ַ���ת���ɳ���·����������һ����Fileʵ�� 
		 * 
		 * ����·����
		 * File path=new File("D:\\NewProject\\MyPro"); 
		 * File�����а�������ļ����µ������ļ���������Ŀ¼
		 * 
		 * ���·����
		 * "."��ʾ��ǰproject�����ļ���(���µ�д��Ĭ����"./files")
		 * ������java.io�е��඼�ǽ����·��������Ϊ��ʼ���û��ĵ�ǰ����Ŀ¼
		 * ����ͨ������System.getProperty("user.dir")�����
		 *
		 * ��ϵͳ�йص�Ĭ�����Ʒָ���File.separator
		 * ����char��ʽΪFile.separatorChar
		 * ������UNIX��Ϊ '/' ����Windows��Ϊ '\'
		 */
		String path = "files" + File.separator + "io.file/file.txt";
		File file = new File(path);// ����·������һ��Fileʵ��
		File temp = null;
		// ����parent����·������child·�����ַ�������һ����Fileʵ��
		File dir = new File(file.getParentFile(), "dir");
		File child1 = new File(dir, "child1.txt");
		File child2 = new File(dir, "child2.txt");
		try {		
			/*
			 * ���ҽ��������ھ��д˳���·����ָ�������Ƶ��ļ�ʱ��ԭ�ӵش����ɴ˳���·����ָ����һ���µĿ��ļ���
			 * ����ļ��Ƿ���ڣ�����������򴴽����ļ���
			 */
			file.createNewFile();
			FileInfoUtil.printFileInfo(file);
			file.setReadOnly();// ����Ϊֻ��
			if (!file.canWrite())
				System.out.println("now file cannot write");
			/*
			 * ��ָ��Ŀ¼�д���һ���µĿ��ļ���ʹ�ø�����ǰ׺�ͺ�׺�ַ������������� 
			 * ����˷����ɹ����أ�����Ա�֤��
			 * �ɷ��صĳ���·������ʾ���ļ��ڴ˷���������֮ǰ�����ڣ����Ҵ˷����������б��嶼�������ٴε�ǰ���������ʱ������ͬ�ĳ���·������
			 * ������ǰ׺����׺���ļ�����Ŀ¼
			 */
			temp = File.createTempFile("temp", ".txt", new File("."));
			// �����˳���·����ָ����Ŀ¼
			dir.mkdir();
			// dir.mkdirs();
			// �����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼
			// �ж��Ƿ��Ǳ�׼�ļ�
			if (temp.isFile())
				System.out.println("temp is file");
			// �ж��Ƿ���Ŀ¼(�ļ���)
			if (dir.isDirectory()) {
				child1.createNewFile();
				child2.createNewFile();
				System.out.println("dir is directory ��");
				/*
				 * �����ɴ˳���·��������ʾ��Ŀ¼�е��ļ���Ŀ¼������������ַ�������
				 * ����listFiles()�������о����е����ļ�����
				 * listFiles(FileFilter)�������оٷ��Ϲ����������ļ�����
				 */
				for (String fileName : dir.list()) {
					System.out.println(fileName);
				}
			}
			// ��һ���ļ��ƶ�����һ����ȫ��ͬ����·���£��൱�ڼ���+ճ��
			// temp.renameTo(new File(dir, "temp.tmp"));
			// ���������ֹʱ������ɾ���˳���·������ʾ���ļ���Ŀ¼
			file.deleteOnExit();
			temp.deleteOnExit();
			child1.deleteOnExit();
			child2.deleteOnExit();
			// �����ɾ�����ļ����»����ļ�������ô��ɾ�����˸��ļ���
			dir.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ɾ���˳���·������ʾ���ļ���Ŀ¼
			file.delete();
			temp.delete();
			child1.delete();
			child2.delete();
			dir.delete();
		}
	}
}