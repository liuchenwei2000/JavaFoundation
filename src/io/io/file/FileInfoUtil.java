/**
 * 
 */
package io.file;

import java.io.File;

/**
 * 文件信息工具类
 * <p>
 * 演示File类的获取文件信息的方法。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-2-1
 */
public class FileInfoUtil {

	/**
	 * 打印文件的信息(如路径、名称等等)
	 */
	public static void printFileInfo(File file) {
		if (file == null || (!file.exists()))
			throw new RuntimeException("文件不存在");
		// File 对象是目录
		if (file.isDirectory()) {
			System.out.println("It is a directory.");
		} 
		// File 对象是标准文件
		else if (file.isFile()) {
			System.out.println("It is a file.");
		}
		System.out.println(getFileInfo(file));
	}

	/**
	 * 返回文件的信息(如路径、名称等等)
	 */
	private static String getFileInfo(File file) {
		StringBuilder info = new StringBuilder();
		info.append("Absolute path：");
		// 返回抽象路径名的绝对路径名字符串
		info.append(file.getAbsolutePath());
		info.append("\n Can read：");
		// 应用程序是否可以读取此抽象路径名表示的文件
		info.append(file.canRead());
		info.append("\n Can write：");
		// 应用程序是否可以修改此抽象路径名表示的文件
		info.append(file.canWrite());
		info.append("\n getName：");
		// 返回由此抽象路径名表示的文件或目录的名称
		info.append(file.getName());
		info.append("\n getPath：");
		// 将此抽象路径名转换为一个路径名字符串
		info.append(file.getPath());
		info.append("\n getParent：");
		// 返回此抽象路径名的父路径名的路径名字符串
		info.append(file.getParent());
		info.append("\n length：：");
		// 返回由此抽象路径名表示的文件的大小(单位 字节)，如果此路径名表示一个目录，则返回值是不确定的。
		info.append(file.length());
		info.append("\n lastModified：");
		// 返回此抽象路径名表示的文件最后一次被修改的时间
		info.append(file.lastModified());
		return info.toString();
	}
}
