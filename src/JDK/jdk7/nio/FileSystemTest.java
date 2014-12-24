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
 * 文件系统示例
 * <p>
 * 一个文件系统通常指的是一个或多个根目录，其下面包含一定的文件和子目录，并由此组成的目录结构。
 * 每一个文件系统都支持一种文件存储机制。这种机制有可能是一个设备，例如C盘或一个磁盘分区，或者是其它的某种组织文件系统空间的方式。
 * Java7中的java.nio.file.FileStore就代表了一种文件存储机制。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月22日
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
	 * 文件系统信息
	 */
	private static void testFileSystem() {
		// 由JVM返回一个代表了当前文件系统的FileSystem对象
		FileSystem fileSystem = FileSystems.getDefault();
		// 如果想要获得系统的路径分隔符，FileSystem也提供了getSeparator方法。
		System.out.println("separator：" + fileSystem.getSeparator());
		
	    // 获得磁盘的各个根目录(Linux中通常只有一个根目录/，但Windows中通常有多个根目录C: D: E:)。
	    Iterable<Path> rootDirectories = fileSystem.getRootDirectories();  
	    System.out.println("Root Directories");  
	    for (Path path : rootDirectories) {  
	        System.out.println(path);  
	    }  
	}
	
	/**
	 * 文件存储信息
	 */
	private static void testFileStore() {
		long MB = 1024 * 1024;
		
		String format = "%-12s %-16s %-8s %-8s %12s %12s %12s%n";
		System.out.printf(format, "Name", "FileSystem", "Type", "ReadOnly",
				"Size(MB)", "Used(MB)", "Available(MB)");

		FileSystem fs = FileSystems.getDefault();
		try {
			for (FileStore fileStore : fs.getFileStores()) {
				// 获取FileStore的总空间、已用空间、可用空间
				long totalSpace = fileStore.getTotalSpace() / MB;
				long usedSpace = (fileStore.getTotalSpace() - fileStore
						.getUnallocatedSpace()) / MB;
				long usableSpace = fileStore.getUsableSpace() / MB;
				// 获取FileStore的名称和类型
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
