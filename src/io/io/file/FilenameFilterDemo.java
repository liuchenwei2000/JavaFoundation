/**
 * 
 */
package io.file;

import java.io.*;

import util.Printer;

/**
 * 文件名过滤器接口演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-10
 */
public class FilenameFilterDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File path = new File("files/io.file"); 
		// 返回由此抽象路径名所表示的目录中的文件和子目录的名称所组成字符串数组
		String[] list = path.list();
		Printer.print(list);
		/*
		 * list()方法会为此目录对象下的每个文件名调用accept()来判断该文件是否包含在内，判断结果由accept()返回的值表示。
		 * 创建这个匿名内部类的目的在于把accept()方法提供给list()使用，使list()可以回调accept()，这种结构称为"回调"。
		 * 回调的目的就是提供了代码行为的灵活性，使用匿名内部类使得代码隔离、聚拢于一点(高内聚)，但是却不易阅读和维护。
		 */
		list = path.list(new FilenameFilter() {

			/**
			 * 本方法必须接受一个代表某个特定文件所在目录的file对象，该特定文件的文件名
			 * 
			 * @param dir
			 *            文件所在目录
			 * @param name
			 *            文件名
			 */
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		Printer.print(list);
	}
}