/**
 * 
 */
package io.stream.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Zip压缩演示类
 * <p>
 * Zip适合于多个文件的压缩。
 * 尽管Zip格式提供了设置密码的方法，但Java的Zip类库并不提供这方面的支持。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-26
 */
public class ZipCompressDemo {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		String zipFileName = "files/io.stream.zip/test.zip";
		// 待压缩文件所在文件夹
		String dirPath = "files/io.stream.zip";
		// 删除上次程序运行创建的zip文件
		File zip = new File(zipFileName);
		if (zip.exists()) {
			zip.delete();
		}
		
		try {
			/** 压缩zip文件 */
			zipFiles(dirPath, zipFileName);
			
			/** 读取zip文件 */
			readZipFiles(zipFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将文件夹内的文件压缩到指定zip文件中
	 */
	private static void zipFiles(String dirPath, String zipFilePath) throws IOException{
		BufferedOutputStream bout = null;
		try {
			// 可以用 CheckSum 类来计算和校验文件的校验和，共有Adler32和CRC32两种类型
			CheckedOutputStream csum = new CheckedOutputStream(new FileOutputStream(zipFilePath), new Adler32());
			
			ZipOutputStream zos = new ZipOutputStream(csum);
			zos.setComment("A test of Java Zipping");
			
			bout = new BufferedOutputStream(zos);
			
			String[] files = getFiles(dirPath);
			
			for (String file : files) {
				System.out.println("Writing file " + file);
				BufferedReader in = new BufferedReader(new FileReader(dirPath + File.separator + file));
				zos.putNextEntry(new ZipEntry(file));
				
				int c;
				while ((c = in.read()) != -1) {
					bout.write(c);
				}
				in.close();
			}
			
			// 计算zip文件校验和
			System.out.println("Checksum: " + csum.getChecksum().getValue());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bout != null) {
				bout.close();
			}
		}
	}
	
	/**
	 * 将文件夹内的文件压缩到指定zip文件中
	 */
	private static void readZipFiles(String zipFilePath) throws IOException{
		BufferedInputStream bin = null;
		try {
			CheckedInputStream csumi = new CheckedInputStream(new FileInputStream(zipFilePath), new Adler32());
			
			ZipInputStream zis = new ZipInputStream(csumi);
			
			bin = new BufferedInputStream(zis);
			
			ZipEntry ze;
			while ((ze = zis.getNextEntry()) != null) {
				System.out.println("Reading file " + ze);
				int x;
				while ((x = bin.read()) != -1) {
					System.out.print((char)x);
				}
				zis.closeEntry();
			}
			System.out.println("\nChecksum: " + csumi.getChecksum().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(bin != null) {
				bin.close();
			}
		}
	}
	
	/**
	 * 返回文件夹中可被压缩的文件列表
	 */
	private static String[] getFiles(String dirPath){
		File dir = new File(dirPath);
		return dir.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return !(name.endsWith(".zip") || name.endsWith(".gz"));
			}
		});
	}
}
