/**
 * 
 */
package io.stream.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 写入zip文件演示类
 * <p>
 * 即将多个文件压缩为zip文件。
 * zip文件以压缩格式存储一个或更多文件，每个zip文件都有文件头，其中包含了诸如文件名和使用的压缩方法等信息。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-20
 */
public class ZipOutputDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 待压缩文件所在文件夹
		String dirPath = "files/io.stream.zip";
		// 压缩后的zip文件名
		String zipFilePath = dirPath + "/out.zip";
		// 删除上次程序运行创建的zip文件
		File zipFile = new File(zipFilePath);
		if (zipFile.exists()) {
			zipFile.delete();
		}

		zip(dirPath, zipFilePath);
	}
	
	private static void zip(String dirPath, String zipFilePath){
		File dir = new File(dirPath);
		String[] files = dir.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return !(name.endsWith(".zip")||name.endsWith(".gz"));
			}

		});
		// 执行压缩操作
		ZipOutputStream out = null;
		try {
			// 当向一个zip文件内写入时，需要打开一个构造器中包含FileOutputStream的ZipOutputStream文件流
			out = new ZipOutputStream(new FileOutputStream(zipFilePath));
			for (String file : files) {
				// 对于每一条希望置入zip文件的条目，都要创建一个ZipEntry对象
				// 只要把文件名传给ZipEntry构造器，它将会自动设置其他参数，诸如文件日期和解压方法等
				ZipEntry entry = new ZipEntry(file);
				// 可以调用putNextEntry方法来开始写入一个新文件
				out.putNextEntry(entry);
				// 将文件数据传递给zip流，真正执行向zip文件的写入操作
				FileInputStream in = new FileInputStream(dirPath + File.separator + file);
				int b;
				while ((b = in.read()) != -1) {
					out.write(b);
				}
				in.close();
				// 完成后调用closeEntry
				out.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
