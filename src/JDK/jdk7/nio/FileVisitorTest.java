/**
 * 
 */
package jdk7.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * FileVisitor示例
 * <p>
 * 当和一个目录文件系统打交道的时候，很多情况下都要遍历整个目录以及其子目录。
 * Java7中对此提供了新的API————java.nio.file.FileVisitor 接口及默认实现 java.nio.file.SimpleFileVisitor。
 * <p>
 * Files.walkFileTree方法以给定的一个目录作为根目录，对每一级文件夹都做了遍历。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月24日
 */
public class FileVisitorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Path path = Paths.get("D:/files");
			Files.walkFileTree(path, new ListFilesVisitor());
			Files.walkFileTree(path, new DeleteDirectory());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * FileVisitor示例
	 * <p>
	 * FileVisitor声明了在访问目录前、访问文件以及访问目录后的回调函数。
	 * 每个方法都返回一个FileVisitResult，上层API由这个返回值来决定是否继续访问后面的目录以及文件。 
	 */
	private static class ListFilesVisitor extends SimpleFileVisitor<Path> {

		/**
		 * 访问目录前
		 * 
		 * @see java.nio.file.SimpleFileVisitor#preVisitDirectory(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
		 */
		@Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) throws IOException {
			System.out.println("About to traverse the directory:" + dir.getFileName());  
			return FileVisitResult.CONTINUE;
		}

		/**
		 * 访问文件时
		 * 
		 * @see java.nio.file.SimpleFileVisitor#preVisitDirectory(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
		 */
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			System.out.println("Visiting file:" + file.getFileName());
			return FileVisitResult.CONTINUE;
		}
		
		/**
		 * 访问目录后
		 * 
		 * @see java.nio.file.SimpleFileVisitor#preVisitDirectory(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
		 */
		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			System.out.println("Finished with the directory:" + dir.getFileName());
			return FileVisitResult.CONTINUE;
		}

		/**
		 * 访问文件失败时
		 * 
		 * @see java.nio.file.SimpleFileVisitor#preVisitDirectory(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
		 */
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc)
				throws IOException {
			System.out.println("A file traversal error ocurred");
			return super.visitFileFailed(file, exc);
		}
	}
	
	/**
	 * 删除整个文件夹示例
	 * <p>
	 * 如果使用Files.delete删除一个文件夹，文件夹必须是空的，不能删除一个包含了很多目录和文件的文件夹。
	 * 但是可以通过SimpleFileVisitor来实现这个功能（同理也可以完成复制整个文件夹的功能）。
	 */
	private static class DeleteDirectory extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			Files.delete(file);// 直接删除文件
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			if (exc == null) {
				Files.delete(dir);// 遍历目录结束时删除整个目录
				return FileVisitResult.CONTINUE;
			} else {
				throw exc;
			}
		}
	}
}
