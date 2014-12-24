/**
 * 
 */
package jdk7.nio;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Pathʾ��
 * <p>
 * һ��Path��·��������ȷ��һ���ļ������ļ��еľ���λ�á�
 * Java7����Path������ʵ�ֶ��ļ������ļ��еĲ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��22��
 */
public class PathTest {
	
	private static final String filePath = "C:/Java/jdk1.7.0_60/README.html";

    /**
     * @param args
     */
    public static void main(String[] args) {
    	testPathAPI_Basic();
    	testPathAPI_Adv();
    	testPathAndFile();
	}
    
    /**
     * ���һ��Path����ķ����кܶ࣬��Ҫ���������֣� 
     * 1��ʹ��FileSystem�����getPath������
     * 2��ʹ��Path�����get��������ʵ�������ڲ�ʵ��Ҳ���õĵ�һ�ַ�ʽ��
     */
    private static void testPathAPI_Basic(){
		Path path = FileSystems.getDefault().getPath(filePath);

		System.out.println("toString: " + path.toString());
		System.out.printf("getFileName: %s%n", path.getFileName());
		System.out.printf("getRoot: %s%n", path.getRoot());
		System.out.printf("getNameCount: %d%n", path.getNameCount());

		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.printf("getName(%d): %s%n", i, path.getName(i));
		}

		// һ��Path�����ɶ����Path��ɣ���Path���Կ�ͨ�ù�subpath��������á�
		System.out.printf("subpath(0,2): %s%n", path.subpath(0, 2));
		System.out.printf("getParent: %s%n", path.getParent());
		System.out.println("path.isAbsolute()=" + path.isAbsolute());

		try {
			path = Paths.get("C:", "Java", "jdk1.7.0_60", "README.html");
			// Path���toAbsolutePath�������Խ����·��ת��Ϊ����·��
			System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
		} catch (InvalidPathException ex) {
			System.out.printf("Bad path: [%s] at position %s", ex.getInput(), ex.getIndex());
		}
		System.out.println("*******************************************");
    }
    
    private static void testPathAPI_Adv(){
    	/*
		 * ��·������������"."����".."�ַ�ʱ������ͨ������Path��normalize��������Щ������ת����������·����
		 * ��������Ĵ��룬�ᷢ��"."����ɾ�����ˣ���Ϊ������ǰ·������".."������һ��·�����档 
		 */
    	Path path = Paths.get("C:/Java/test/../jdk1.7.0_60/README.html");
		System.out.println("Absolute path: " + path.toAbsolutePath());
		System.out.println("URI: " + path.toUri());
		System.out.println("Normalized Path: " + path.normalize());
		System.out.println("Normalized URI: " + path.normalize().toUri());

		path = Paths.get("C:/Java/./jdk1.7.0_60/README.html");
		System.out.println("Absolute path: " + path.toAbsolutePath());
		System.out.println("URI: " + path.toUri());
		System.out.println("Normalized Path: " + path.normalize());
		System.out.println("Normalized URI: " + path.normalize().toUri());
		System.out.println("*******************************************");
		
		/*
		 * Path��toRealPath�᷵��һ����ʵ����һ���ļ���·���������ָ�����ļ����������׳�NoSuchFileException�쳣��
		 */
		try {
			path = Paths.get("C:/Java/jdk1.7.0_60/shortcut6.lnk");
			System.out.println("isSymbolicLink()��" + Files.isSymbolicLink(path));
			System.out.println("toRealPath (Do not follow links): " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));  
			System.out.println("toRealPath: " + path.toRealPath());  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	/**
	 * File��Path���໥ת��
	 */
	private static void testPathAndFile() {
		try {
			Path fPath = Paths.get(new URI("file:///" + filePath));
			File file = new File(filePath);
			Path toPath = file.toPath();
			System.out.println(toPath.equals(fPath));
		} catch (URISyntaxException e) {
			System.out.println("Bad URI��" + e.getInput());
		}
	}
}
