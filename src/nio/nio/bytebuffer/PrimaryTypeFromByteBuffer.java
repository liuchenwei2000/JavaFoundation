/**
 * 
 */
package nio.bytebuffer;

import java.nio.ByteBuffer;

import nio.IConst;

/**
 * 从ByteBuffer中获取基本类型
 * <p>
 * 尽管ByteBuffer只能保存字节类型的数据，但是它具有可以从它所容纳的字节中产生出各种不同基本类型值的方法。
 * <p>
 * 向ByteBuffer插入基本类型数据的最简单的方法是：
 * 利用asCharBuffer()等获得该缓冲器上的视图然后使用视图的put()方法。
 * 此方法适用于所有基本数据类型，仅有在使用ShortBuffer的put()方法时需要进行类型转换(注意类型转化会截取或改变结果)。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-23
 */
public class PrimaryTypeFromByteBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(IConst.K);
		// 分配一个ByteBuffer之后，它会将其内容自动置零
		int i = 0;
		while (i++ < buffer.limit()) {
			if (buffer.get() != 0) {
				System.out.println("nonzero");
			}
		}
		// 返回数据开始的地方
		buffer.rewind();
		/** 向ByteBuffer中存入char */
		buffer.asCharBuffer().put("Hello World!");
		char c;
		while ((c = buffer.getChar()) != 0) {
			System.out.print(c + "");
		}
		System.out.println();
		/** 向ByteBuffer中存入short */
		buffer.rewind();
		buffer.asShortBuffer().put((short) 471142);
		System.out.println(buffer.getShort());
		/** 向ByteBuffer中存入int */
		buffer.rewind();
		buffer.asIntBuffer().put(99471142);
		System.out.println(buffer.getInt());
		/** 向ByteBuffer中存入long */
		buffer.rewind();
		buffer.asLongBuffer().put(99471142L);
		System.out.println(buffer.getLong());
		/** 向ByteBuffer中存入float */
		buffer.rewind();
		buffer.asFloatBuffer().put(99471142f);
		System.out.println(buffer.getFloat());
		/** 向ByteBuffer中存入double */
		buffer.rewind();
		buffer.asDoubleBuffer().put(99471142);
		System.out.println(buffer.getDouble());
		buffer.rewind();
	}
}