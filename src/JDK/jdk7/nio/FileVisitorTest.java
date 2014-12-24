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
 * FileVisitorʾ��
 * <p>
 * ����һ��Ŀ¼�ļ�ϵͳ�򽻵���ʱ�򣬺ܶ�����¶�Ҫ��������Ŀ¼�Լ�����Ŀ¼��
 * Java7�жԴ��ṩ���µ�API��������java.nio.file.FileVisitor �ӿڼ�Ĭ��ʵ�� java.nio.file.SimpleFileVisitor��
 * <p>
 * Files.walkFileTree�����Ը�����һ��Ŀ¼��Ϊ��Ŀ¼����ÿһ���ļ��ж����˱�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��24��
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
	 * FileVisitorʾ��
	 * <p>
	 * FileVisitor�������ڷ���Ŀ¼ǰ�������ļ��Լ�����Ŀ¼��Ļص�������
	 * ÿ������������һ��FileVisitResult���ϲ�API���������ֵ�������Ƿ�������ʺ����Ŀ¼�Լ��ļ��� 
	 */
	private static class ListFilesVisitor extends SimpleFileVisitor<Path> {

		/**
		 * ����Ŀ¼ǰ
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
		 * �����ļ�ʱ
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
		 * ����Ŀ¼��
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
		 * �����ļ�ʧ��ʱ
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
	 * ɾ�������ļ���ʾ��
	 * <p>
	 * ���ʹ��Files.deleteɾ��һ���ļ��У��ļ��б����ǿյģ�����ɾ��һ�������˺ܶ�Ŀ¼���ļ����ļ��С�
	 * ���ǿ���ͨ��SimpleFileVisitor��ʵ��������ܣ�ͬ��Ҳ������ɸ��������ļ��еĹ��ܣ���
	 */
	private static class DeleteDirectory extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			Files.delete(file);// ֱ��ɾ���ļ�
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			if (exc == null) {
				Files.delete(dir);// ����Ŀ¼����ʱɾ������Ŀ¼
				return FileVisitResult.CONTINUE;
			} else {
				throw exc;
			}
		}
	}
}
