/**
 * 
 */
package jdk7.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Filesʾ��
 * <p>
 * Files���ṩ��һЩ��̬�������������ļ���Ŀ¼��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��22��
 */
public class FilesTest {

	private static final Path path = FileSystems.getDefault().getPath("C:/Java/jdk1.7.0_60/README.html");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			testFilesAPI_Basic();
			testFilesAPI_Attribute();
			testFilesAPI_View();
			testFilesAPI_Operation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���þ�̬����API
	 * <p>
	 * �ļ���Ϣָ����һ���ļ��Ƿ���Ա�ִ�С��ļ��Ĵ�С���ļ������û��������ļ������ݡ� 
	 * <p>
	 * ʹ��java.nio.file.Files��������ļ���Ϣ�ķ�ʽһ�������֣� 
	 * <li>ʹ��Files���ļ���Ϣ��صľ�̬����������isDirectory������þ���ĳ���ļ���Ϣ��
	 * <li>ʹ��Files��getAttribute��̬���������ĳһ���ļ���Ϣ��
	 * <li>ʹ��readAttributes����������һ�����������ļ���Ϣ��Map����
	 * <li>ʹ��һ��BasicFileAttributes�ӿ�(ĳ������ʵ����)��Ϊ����������readAttributes���������һ�������ļ���Ϣ��BasicFileAttributes����
	 * <li>ʹ��getFileAttributeView���������һ���꾡���ļ���Ϣ���ϡ�
	 */
	private static void testFilesAPI_Basic() throws IOException {
		// �ж��ļ��Ƿ����
		System.out.println("exists?" + Files.exists(path));
		// �ж��ļ��Ƿ���Ŀ¼
		System.out.println("isDirectory?" + Files.isDirectory(path));
		// �ж��ļ��Ƿ�ɶ�
		System.out.println("isReadable?" + Files.isReadable(path));
		// �ж��ļ��Ƿ��д
		System.out.println("isWritable?" + Files.isWritable(path));
		// �ж��ļ��Ƿ�����
		System.out.println("isHidden?" + Files.isHidden(path));
		// �ж��ļ��Ƿ��ǳ����ļ�
		System.out.println("isRegularFile?" + Files.isRegularFile(path));
		
		
		// �����ļ���FileStore
		System.out.println("getFileStore?" + Files.getFileStore(path));
		// �����ļ���owner
		System.out.println("getOwner?" + Files.getOwner(path));
		// �����ļ�������޸�ʱ��
		System.out.println("getLastModifiedTime?" + Files.getLastModifiedTime(path));

		/*
		 * �����ļ����ݵ�����
		 * 
		 * ��������ļ��������Ϳ���ͨ����չ������á�����txt�ļ����ı��ļ���exe�ļ�����Windows�µĿ�ִ���ļ���
		 * �����Խ�һ��txt�ļ���������exe�ļ����Ⲣ���ܸı��ļ����ݵ����͡����ͨ���ļ�����չ���������������һ�������ԡ�
		 * Files���probeContentType������������ļ��������͵ġ�
		 */
		System.out.println(Files.probeContentType(path));
	}
	
	/**
	 * �ļ�������ص�API
	 */
	private static void testFilesAPI_Attribute() throws IOException {
		/*
		 * ���ָ����ĳ�����ԣ�������һ�η������һ���ļ�����
		 * 
		 * getAttribute�����ĵڶ�����ָ���˾�����Ҫ���������ļ���Ϣ����ʹ�õĲ���ֵ���£�
		 *    	����ֵ	     	����ֵ����
		 * lastModifiedTime		FileTime
		 * lastAccessTime		FileTime
		 * creationTime			FileTime
		 * size					long
		 * isRegularFile		Boolean
		 * isDirectory			Boolean
		 * isSymbolicLink		Boolean
		 * isOther				Boolean
		 * fileKey				Object
		 */
		String[] attributeNames = { "lastModifiedTime", "lastAccessTime",
				"creationTime", "size", "isRegularFile", "isDirectory" };
		for (String attributeName : attributeNames) {
			System.out.println(attributeName + "��"
					+ Files.getAttribute(path, attributeName));
		}
		System.out.println("*************************************************");
		
		/* 
		 * ͨ������Files.readAttributes���������ذ����ļ���Ϣ��Map����
		 * 
		 * readAttributes�����ڶ���������һ����ͼ��Ϣ�����ƺ�һ������������ɣ��м���ð��(:)������
		 * ����"posix:permissions,owner,size"��"*"������������ԡ�
		 */
		Map<String, Object> attrsMap = Files.readAttributes(path, "*");
		for (String attribute : attrsMap.keySet()) {
			System.out.println(attribute + ": " + Files.getAttribute(path, attribute));
		}
		System.out.println("*************************************************");
	}
	
	/**
	 * �ļ���ͼ��ص�API
	 * <p>
	 * Java7������һϵ�й����ļ���ͼ�Ľӿڡ�һ���ļ���ͼ(View)����˵����֯�ļ�(�����ļ���)��Ϣ��һ�ַ�ʽ��
	 * ���磺
	 * AclFileAttributeView���ṩ�˺��ļ�Access Control List (ACL)��صķ�����
	 * 
	 * java.nio.file.attribute���¹���View�Ľӿ�����: 
	 * AclFileAttributeView: ����ά���ļ��ķ��ʿ����б�(ACL)���ļ�������һЩ��Ϣ��
	 * BasicFileAttributeView: ���ڷ����ļ���һЩ������Ϣ�����ú�ʱ����ص�һЩ���ԡ�
	 * DosFileAttributeView: Ϊ������DOS�ļ�ϵͳ����ơ�
	 * FileOwnerAttributeView: ����ά���ļ�������(�����ĸ��û�)��Ϣ��
	 * PosixFileAttributeView: ����֧�ֿ���ֲ�Բ���ϵͳ�ӿ�(Portable Operating System Interface)��
	 * UserDefinedFileAttributeView: ����֧���û�������ļ���Ϣ��
	 */
	private static void testFilesAPI_View() throws IOException {
		/*
		 * һ������ϵͳ���ܲ�֧��Java�ж���������ļ���ͼ��Ϣ������ͨ������Ĵ������鿴����֧�ֵ���ͼ��Ϣ�� 
		 */
		FileSystem fileSystem = path.getFileSystem();  
	    Set<String> supportedViews = fileSystem.supportedFileAttributeViews();  
	  
	    for (String view : supportedViews) {  
	        System.out.println(view);  
	    }
	    
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attributes = view.readAttributes();
        
        System.out.println("Creation Time: " + attributes.creationTime());  
        System.out.println("Last Accessed Time: " + attributes.lastAccessTime());  
        System.out.println("Last Modified Time: " + attributes.lastModifiedTime());  
        System.out.println("File Key: " + attributes.fileKey());  
        System.out.println("Directory: " + attributes.isDirectory());  
        System.out.println("Other Type of File: " + attributes.isOther());  
        System.out.println("Regular File: " + attributes.isRegularFile());  
        System.out.println("Symbolic File: " + attributes.isSymbolicLink());  
        System.out.println("Size: " + attributes.size());  
	}
	
	/**
	 * �����ļ�API
	 */
	private static void testFilesAPI_Operation() {
		testFilesAPI_Operation_std();
		testFilesAPI_Operation_io();
	}
	
	/**
	 * �������ƶ���ɾ���ļ�/Ŀ¼API
	 */
	private static void testFilesAPI_Operation_std() {
		try {
			Path dirPath = FileSystems.getDefault().getPath("D:/files");
			// ����ָ��·������Ŀ¼������Ѵ������׳��쳣
			Files.createDirectory(dirPath);
			
			Path dirPath2 = FileSystems.getDefault().getPath("D:/files/test/subtest");
			// ����ָ��·������Ŀ¼����������Ŀ¼�������в����ڵĸ�Ŀ¼������ĳ��Ŀ¼�Ѵ����򲻻��׳��쳣
			Files.createDirectories(dirPath2);
			
			Path filePath = FileSystems.getDefault().getPath("D:/files/test.txt");
			// ����ָ��·�������µĿ��ļ�������ļ��Ѵ������׳��쳣
			Files.createFile(filePath);
			
			// createFile��createDirectory���������������ԭ���Եģ���Ҫ�������������ܳɹ���������������ʧ�ܡ�
			
			// ʹ��ָ���ļ���ǰ׺����׺������ʱ�ļ��������Ĭ����ʱĿ¼�£� System.getProperty("java.io.tmpdir")��
			Path tempFile = Files.createTempFile("temp-", "-test");
			// ʹ��ָ���ļ���ǰ׺����׺������ʱ�ļ��������ָ��Ŀ¼��
			Files.createTempFile(dirPath, "temp-", "-test");
			// ʹ��ָ��ǰ׺������ʱĿ¼�������Ĭ����ʱĿ¼�£� System.getProperty("java.io.tmpdir")��
			Files.createTempDirectory("dir-");
			// ʹ��ָ��ǰ׺������ʱĿ¼�������ָ��Ŀ¼��
			Files.createTempDirectory(dirPath, "dir-");
			
			// ɾ���ļ�����ɾ������Ŀ¼��������ǿ�Ŀ¼�ſ���ɾ�����ļ������ڻ�Ŀ¼�ǿն����׳��쳣��
			Files.delete(tempFile);
			// ����ļ�������ɾ������ɾ������Ŀ¼��������ǿ�Ŀ¼�ſ���ɾ����
			// �ļ��ɹ�ɾ���򷵻�true���ļ��������򷵻�false�����׳��쳣��
			System.out.println("deleteIfExists?" + Files.deleteIfExists(tempFile));
			
			
			// �ƶ����������ļ�����ʹ��Files.move����
			
			// �������ļ�����ͬһ��Ŀ¼�£�
			Path source = Files.move(filePath, filePath.resolveSibling("newname"), StandardCopyOption.REPLACE_EXISTING);
			// �ƶ��ļ�������Ŀ¼
			Path target = FileSystems.getDefault().getPath("E:/");
			Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��д�ļ�API
	 */
	private static void testFilesAPI_Operation_io() {
		try {
			Path target1 = FileSystems.getDefault().getPath("D:/files/readme_stream1.txt");
			Path target2 = FileSystems.getDefault().getPath("D:/files/readme_stream2.txt");
			Path target3 = FileSystems.getDefault().getPath("D:/files/readme_copy.txt");
			
			// ��ȡ��ȡָ���ļ���InputStream����
			InputStream is = Files.newInputStream(path);
			// ��ȡд��ָ���ļ���OutputStream����
			OutputStream os = Files.newOutputStream(target1);
			
			// ��ȡ��ȡָ���ļ���BufferedReader����
			BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			br.close();
			// ��ȡд��ָ���ļ���OutputStream����
			BufferedWriter bw = Files.newBufferedWriter(target1, StandardCharsets.UTF_8);
			bw.close();
			
			// ��ȡ�ļ����������ֽڿ������������
			Files.copy(path, os);
			os.flush();
			os.close();
			
			// ����������ȡ�����ֽڿ�����Ŀ���ļ���
			Files.copy(is, target2);
			is.close();
			
			// ��Դ�ļ�������Ŀ���ļ�
			Files.copy(path, target3);
			
			// ���ļ��ж�ȡ���е��ֽ�
			byte[] bytes = Files.readAllBytes(path);
			System.out.println(new String(bytes));
			
			// ���ļ��ж�ȡ������
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			System.out.println(lines);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
