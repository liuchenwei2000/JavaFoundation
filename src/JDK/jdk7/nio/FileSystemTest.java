/**
 * 
 */
package jdk7.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.NumberFormat;

/**
 * �ļ�ϵͳʾ��
 * <p>
 * һ���ļ�ϵͳͨ��ָ����һ��������Ŀ¼�����������һ�����ļ�����Ŀ¼�����ɴ���ɵ�Ŀ¼�ṹ��
 * ÿһ���ļ�ϵͳ��֧��һ���ļ��洢���ơ����ֻ����п�����һ���豸������C�̻�һ�����̷�����������������ĳ����֯�ļ�ϵͳ�ռ�ķ�ʽ��
 * Java7�е�java.nio.file.FileStore�ʹ�����һ���ļ��洢���ơ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��22��
 */
public class FileSystemTest {
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {  
		testFileSystem();
		testFileStore();
	}
	
	/**
	 * �ļ�ϵͳ��Ϣ
	 */
	private static void testFileSystem() {
		// ��JVM����һ�������˵�ǰ�ļ�ϵͳ��FileSystem����
		FileSystem fileSystem = FileSystems.getDefault();
		// �����Ҫ���ϵͳ��·���ָ�����FileSystemҲ�ṩ��getSeparator������
		System.out.println("separator��" + fileSystem.getSeparator());
		
	    // ��ô��̵ĸ�����Ŀ¼(Linux��ͨ��ֻ��һ����Ŀ¼/����Windows��ͨ���ж����Ŀ¼C: D: E:)��
	    Iterable<Path> rootDirectories = fileSystem.getRootDirectories();  
	    System.out.println("Root Directories");  
	    for (Path path : rootDirectories) {  
	        System.out.println(path);  
	    }  
	}
	
	/**
	 * �ļ��洢��Ϣ
	 */
	private static void testFileStore() {
		long MB = 1024 * 1024;
		
		String format = "%-12s %-16s %-8s %-8s %12s %12s %12s%n";
		System.out.printf(format, "Name", "FileSystem", "Type", "ReadOnly",
				"Size(MB)", "Used(MB)", "Available(MB)");

		FileSystem fs = FileSystems.getDefault();
		try {
			for (FileStore fileStore : fs.getFileStores()) {
				// ��ȡFileStore���ܿռ䡢���ÿռ䡢���ÿռ�
				long totalSpace = fileStore.getTotalSpace() / MB;
				long usedSpace = (fileStore.getTotalSpace() - fileStore
						.getUnallocatedSpace()) / MB;
				long usableSpace = fileStore.getUsableSpace() / MB;
				// ��ȡFileStore�����ƺ�����
				String name = fileStore.name();
				String type = fileStore.type();

				boolean readOnly = fileStore.isReadOnly();

				NumberFormat numberFormat = NumberFormat.getInstance();

				System.out.printf(format, name, fileStore, type, readOnly,
						numberFormat.format(totalSpace),
						numberFormat.format(usedSpace),
						numberFormat.format(usableSpace));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
