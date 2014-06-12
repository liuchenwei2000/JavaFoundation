/**
 * 
 */
package nio.bytebuffer.mapped;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import nio.IConst;

/**
 * MappedByteBuffer简单演示类
 * <p>
 * 存储器映射文件允许创建和修改那些因为太大而不能放入内存的文件，
 * 有了存储器映射文件，就可以假定整个文件都在内存中(虚拟内存)，
 * 而且可以完全把它当作非常大的数组来访问。
 * 这种方法极大地简化了用于修改文件的代码。
 * <strong>会产生一个32M的文件，要手工删除这个文件</strong>
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-25
 */
public class SimpleMappedByteBufferDemo {
	
	private static final String FILE_NAME = "files/nio.bytebuffer.mapped/test.dat";
	/** 文件大小 32M */
	private static final int FILE_SIZE = 32 * IConst.M;
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * 通过FileChannel调用map方法产生一个MappedByteBuffer
		 * 这是特殊的直接缓冲器，必须指定映射文件的初始位置和映射区域的长度
		 * 这意味着可以映射某个大文件的一个较小的部分
		 * 
		 * MappedByteBuffer由ByteBuffer继承而来
		 * 因此它具有ByteBuffer的所有方法
		 * 本例仅仅展示了非常简单的put()和get()
		 * 但是同样可以使用像asCharBuffer()等这样的用法
		 */
		MappedByteBuffer out = new RandomAccessFile(FILE_NAME, "rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, FILE_SIZE);
		// 向文件中写入32M的字符'x'
		for (int i = 0; i < FILE_SIZE; i++) {
			out.put((byte) 'x');
		}
		System.out.println("Finished writing");
		// 读取文件中6个字节的内容
		for (int i = FILE_SIZE / 2; i < FILE_SIZE / 2 + 6; i++) {
			System.out.print((char) out.get(i));
		}
	}
}