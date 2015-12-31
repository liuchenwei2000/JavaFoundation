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
 * Path示例
 * <p>
 * 一个Path（路径）可以确定一个文件或者文件夹的具体位置。
 * Java7中用Path对象来实现对文件或者文件夹的操作。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月22日
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
     * 获得一个Path对象的方法有很多，主要有以下两种： 
     * 1，使用FileSystem对象的getPath方法。
     * 2，使用Path对象的get方法。（实际上其内部实现也是用的第一种方式）
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

		// 一个Path可以由多个子Path组成，子Path可以可通用过subpath方法来获得。
		System.out.printf("subpath(0,2): %s%n", path.subpath(0, 2));
		System.out.printf("getParent: %s%n", path.getParent());
		System.out.println("path.isAbsolute()=" + path.isAbsolute());

		try {
			path = Paths.get("C:", "Java", "jdk1.7.0_60", "README.html");
			// Path类的toAbsolutePath方法可以将相对路径转换为绝对路径
			System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
		} catch (InvalidPathException ex) {
			System.out.printf("Bad path: [%s] at position %s", ex.getInput(), ex.getIndex());
		}
		System.out.println("*******************************************");
    }
    
    private static void testPathAPI_Adv(){
    	/*
		 * 当路径描述符中有"."或者".."字符时，可以通过调用Path的normalize方法将这些描述符转换成真正的路径。
		 * 运行下面的代码，会发现"."都被删除掉了，因为它代表当前路径；而".."会用上一层路径代替。 
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
		 * Path的toRealPath会返回一个真实代表一个文件的路径，如果所指定的文件不存在则抛出NoSuchFileException异常。
		 */
		try {
			path = Paths.get("C:/Java/jdk1.7.0_60/shortcut6.lnk");
			System.out.println("isSymbolicLink()：" + Files.isSymbolicLink(path));
			System.out.println("toRealPath (Do not follow links): " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));  
			System.out.println("toRealPath: " + path.toRealPath());  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	/**
	 * File和Path的相互转换
	 */
	private static void testPathAndFile() {
		try {
			Path fPath = Paths.get(new URI("file:///" + filePath));
			File file = new File(filePath);
			Path toPath = file.toPath();
			System.out.println(toPath.equals(fPath));
		} catch (URISyntaxException e) {
			System.out.println("Bad URI：" + e.getInput());
		}
	}
}
