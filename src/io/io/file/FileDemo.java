/**
 * 
 */
package io.file;

import java.io.File;
import java.io.IOException;

/**
 * File类演示
 * <p>
 * File类既能代表一个特定文件的名称，又能代表一个目录的名称。
 * File类不仅仅只代表存在的文件或目录，也可以用来创建新的目录和上不存在的整个目录路径。
 * 
 * 流关注的是文件内容，而File类关注的是文件在磁盘上的存储。
 *
 * 创建日期：2008-2-1
 *
 * @author 刘晨伟
 */
public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* 
		 * 通过将给定路径名字符串转换成抽象路径名来创建一个新File实例 
		 * 
		 * 绝对路径：
		 * File path=new File("D:\\NewProject\\MyPro"); 
		 * File对象中包含这个文件夹下的所有文件，包括子目录
		 * 
		 * 相对路径：
		 * "."表示当前project所在文件夹(如下的写法默认是"./files")
		 * 所有在java.io中的类都是将相对路径名解释为起始于用户的当前工作目录
		 * 可以通过调用System.getProperty("user.dir")来获得
		 *
		 * 与系统有关的默认名称分隔符File.separator
		 * 它的char形式为File.separatorChar
		 * 比如在UNIX下为 '/' 而在Windows下为 '\'
		 */
		String path = "files" + File.separator + "io.file/file.txt";
		File file = new File(path);// 根据路径创建一个File实例
		File temp = null;
		// 根据parent抽象路径名和child路径名字符串创建一个新File实例
		File dir = new File(file.getParentFile(), "dir");
		File child1 = new File(dir, "child1.txt");
		File child2 = new File(dir, "child2.txt");
		try {		
			/*
			 * 当且仅当不存在具有此抽象路径名指定的名称的文件时，原子地创建由此抽象路径名指定的一个新的空文件。
			 * 检查文件是否存在，如果不存在则创建该文件。
			 */
			file.createNewFile();
			FileInfoUtil.printFileInfo(file);
			file.setReadOnly();// 设置为只读
			if (!file.canWrite())
				System.out.println("now file cannot write");
			/*
			 * 在指定目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称 
			 * 如果此方法成功返回，则可以保证：
			 * 由返回的抽象路径名表示的文件在此方法被调用之前不存在，并且此方法及其所有变体都不会在再次当前调用虚拟机时返回相同的抽象路径名。
			 * 参数：前缀、后缀、文件所在目录
			 */
			temp = File.createTempFile("temp", ".txt", new File("."));
			// 创建此抽象路径名指定的目录
			dir.mkdir();
			// dir.mkdirs();
			// 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录
			// 判断是否是标准文件
			if (temp.isFile())
				System.out.println("temp is file");
			// 判断是否是目录(文件夹)
			if (dir.isDirectory()) {
				child1.createNewFile();
				child2.createNewFile();
				System.out.println("dir is directory ：");
				/*
				 * 返回由此抽象路径名所表示的目录中的文件和目录的名称所组成字符串数组
				 * 还有listFiles()方法来列举所有的子文件数组
				 * listFiles(FileFilter)方法来列举符合过滤器的子文件数组
				 */
				for (String fileName : dir.list()) {
					System.out.println(fileName);
				}
			}
			// 将一个文件移动到另一个完全不同的新路径下，相当于剪切+粘贴
			// temp.renameTo(new File(dir, "temp.tmp"));
			// 在虚拟机终止时，请求删除此抽象路径名表示的文件或目录
			file.deleteOnExit();
			temp.deleteOnExit();
			child1.deleteOnExit();
			child2.deleteOnExit();
			// 如果被删除的文件夹下还有文件存在那么就删除不了该文件夹
			dir.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 删除此抽象路径名表示的文件或目录
			file.delete();
			temp.delete();
			child1.delete();
			child2.delete();
			dir.delete();
		}
	}
}