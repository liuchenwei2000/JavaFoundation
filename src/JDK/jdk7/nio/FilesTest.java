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
 * Files示例
 * <p>
 * Files类提供了一些静态方法用来操作文件和目录。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月22日
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
	 * 常用静态方法API
	 * <p>
	 * 文件信息指的是一个文件是否可以被执行、文件的大小、文件所属用户甚至是文件的内容。 
	 * <p>
	 * 使用java.nio.file.Files类来获得文件信息的方式一共有五种： 
	 * <li>使用Files和文件信息相关的静态方法（例如isDirectory）来获得具体某种文件信息。
	 * <li>使用Files的getAttribute静态方法来获得某一种文件信息。
	 * <li>使用readAttributes方法来返回一个包含所有文件信息的Map对象。
	 * <li>使用一个BasicFileAttributes接口(某个具体实现类)作为参数，调用readAttributes方法来获得一个包含文件信息的BasicFileAttributes对象。
	 * <li>使用getFileAttributeView方法，获得一个详尽的文件信息集合。
	 */
	private static void testFilesAPI_Basic() throws IOException {
		// 判断文件是否存在
		System.out.println("exists?" + Files.exists(path));
		// 判断文件是否是目录
		System.out.println("isDirectory?" + Files.isDirectory(path));
		// 判断文件是否可读
		System.out.println("isReadable?" + Files.isReadable(path));
		// 判断文件是否可写
		System.out.println("isWritable?" + Files.isWritable(path));
		// 判断文件是否隐藏
		System.out.println("isHidden?" + Files.isHidden(path));
		// 判断文件是否是常规文件
		System.out.println("isRegularFile?" + Files.isRegularFile(path));
		
		
		// 返回文件的FileStore
		System.out.println("getFileStore?" + Files.getFileStore(path));
		// 返回文件的owner
		System.out.println("getOwner?" + Files.getOwner(path));
		// 返回文件的最后修改时间
		System.out.println("getLastModifiedTime?" + Files.getLastModifiedTime(path));

		/*
		 * 返回文件内容的类型
		 * 
		 * 常情况下文件内容类型可以通过扩展名来获得。例如txt文件是文本文件，exe文件则是Windows下的可执行文件。
		 * 但可以将一个txt文件重命名成exe文件，这并不能改变文件内容的类型。因此通过文件的扩展名来获得其类型有一定的误导性。
		 * Files类的probeContentType就是用来获得文件内容类型的。
		 */
		System.out.println(Files.probeContentType(path));
	}
	
	/**
	 * 文件属性相关的API
	 */
	private static void testFilesAPI_Attribute() throws IOException {
		/*
		 * 获得指定的某种属性，即调用一次方法获得一个文件属性
		 * 
		 * getAttribute方法的第二参数指定了具体需要返回哪种文件信息。可使用的参数值如下：
		 *    	参数值	     	返回值类型
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
			System.out.println(attributeName + "："
					+ Files.getAttribute(path, attributeName));
		}
		System.out.println("*************************************************");
		
		/* 
		 * 通过调用Files.readAttributes方法，返回包含文件信息的Map对象
		 * 
		 * readAttributes方法第二个参数由一个视图信息的名称和一个具体属性组成，中间由冒号(:)隔开。
		 * 例如"posix:permissions,owner,size"。"*"则代表所有属性。
		 */
		Map<String, Object> attrsMap = Files.readAttributes(path, "*");
		for (String attribute : attrsMap.keySet()) {
			System.out.println(attribute + ": " + Files.getAttribute(path, attribute));
		}
		System.out.println("*************************************************");
	}
	
	/**
	 * 文件视图相关的API
	 * <p>
	 * Java7引入了一系列关于文件视图的接口。一个文件视图(View)简单来说就组织文件(或者文件夹)信息的一种方式。
	 * 例如：
	 * AclFileAttributeView，提供了和文件Access Control List (ACL)相关的方法。
	 * 
	 * java.nio.file.attribute包下关于View的接口如下: 
	 * AclFileAttributeView: 用于维护文件的访问控制列表(ACL)和文件所属的一些信息。
	 * BasicFileAttributeView: 用于访问文件的一些基本信息，设置和时间相关的一些属性。
	 * DosFileAttributeView: 为遗留的DOS文件系统而设计。
	 * FileOwnerAttributeView: 用于维护文件的所属(属于哪个用户)信息。
	 * PosixFileAttributeView: 用来支持可移植性操作系统接口(Portable Operating System Interface)。
	 * UserDefinedFileAttributeView: 用来支持用户定义的文件信息。
	 */
	private static void testFilesAPI_View() throws IOException {
		/*
		 * 一个操作系统可能不支持Java中定义的所有文件视图信息，可以通过下面的代码来查看其所支持的视图信息。 
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
	 * 操作文件API
	 */
	private static void testFilesAPI_Operation() {
		testFilesAPI_Operation_std();
		testFilesAPI_Operation_io();
	}
	
	/**
	 * 创建、移动、删除文件/目录API
	 */
	private static void testFilesAPI_Operation_std() {
		try {
			Path dirPath = FileSystems.getDefault().getPath("D:/files");
			// 根据指定路径创建目录，如果已存在则抛出异常
			Files.createDirectory(dirPath);
			
			Path dirPath2 = FileSystems.getDefault().getPath("D:/files/test/subtest");
			// 根据指定路径创建目录（包括创建目录中所有尚不存在的父目录），若某个目录已存在则不会抛出异常
			Files.createDirectories(dirPath2);
			
			Path filePath = FileSystems.getDefault().getPath("D:/files/test.txt");
			// 根据指定路径创建新的空文件，如果文件已存在则抛出异常
			Files.createFile(filePath);
			
			// createFile和createDirectory这个两个方法都是原子性的，即要不整个操作都能成功或者整个操作都失败。
			
			// 使用指定文件名前缀、后缀创建临时文件，存放于默认临时目录下（ System.getProperty("java.io.tmpdir")）
			Path tempFile = Files.createTempFile("temp-", "-test");
			// 使用指定文件名前缀、后缀创建临时文件，存放于指定目录下
			Files.createTempFile(dirPath, "temp-", "-test");
			// 使用指定前缀创建临时目录，存放于默认临时目录下（ System.getProperty("java.io.tmpdir")）
			Files.createTempDirectory("dir-");
			// 使用指定前缀创建临时目录，存放于指定目录下
			Files.createTempDirectory(dirPath, "dir-");
			
			// 删除文件，若删除的是目录，则必须是空目录才可以删除。文件不存在或目录非空都会抛出异常。
			Files.delete(tempFile);
			// 如果文件存在则删除，若删除的是目录，则必须是空目录才可以删除。
			// 文件成功删除则返回true，文件不存在则返回false而不抛出异常。
			System.out.println("deleteIfExists?" + Files.deleteIfExists(tempFile));
			
			
			// 移动或重命名文件可以使用Files.move方法
			
			// 重命名文件（在同一个目录下）
			Path source = Files.move(filePath, filePath.resolveSibling("newname"), StandardCopyOption.REPLACE_EXISTING);
			// 移动文件到其他目录
			Path target = FileSystems.getDefault().getPath("E:/");
			Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读写文件API
	 */
	private static void testFilesAPI_Operation_io() {
		try {
			Path target1 = FileSystems.getDefault().getPath("D:/files/readme_stream1.txt");
			Path target2 = FileSystems.getDefault().getPath("D:/files/readme_stream2.txt");
			Path target3 = FileSystems.getDefault().getPath("D:/files/readme_copy.txt");
			
			// 获取读取指定文件的InputStream对象
			InputStream is = Files.newInputStream(path);
			// 获取写入指定文件的OutputStream对象
			OutputStream os = Files.newOutputStream(target1);
			
			// 获取读取指定文件的BufferedReader对象
			BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			br.close();
			// 获取写入指定文件的OutputStream对象
			BufferedWriter bw = Files.newBufferedWriter(target1, StandardCharsets.UTF_8);
			bw.close();
			
			// 读取文件将其所有字节拷贝到输出流中
			Files.copy(path, os);
			os.flush();
			os.close();
			
			// 从输入流读取所有字节拷贝到目标文件中
			Files.copy(is, target2);
			is.close();
			
			// 从源文件拷贝到目标文件
			Files.copy(path, target3);
			
			// 从文件中读取所有的字节
			byte[] bytes = Files.readAllBytes(path);
			System.out.println(new String(bytes));
			
			// 从文件中读取所有行
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			System.out.println(lines);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
