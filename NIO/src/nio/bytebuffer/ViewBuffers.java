/**
 * 
 */
package nio.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * 4，ByteBuffer所有的视图缓冲器演示
 * <p>
 * 一旦底层的 ByteBuffer 通过视图缓冲器被填满数据时，就可以直接被写到通道中，正像从通道中读取那样容易。
 * 然后使用视图缓冲器可以把任何数据都转换成某一特定的基本类型。
 * <p>
 * 在本例中，通过在同一个ByteBuffer上建立不同的视图缓冲器，
 * 将同一字节序列转换成了short、int、float、long 和 double 类型的数据。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-23
 */
public class ViewBuffers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
		byteBuffer.rewind();
		
		/*
		 * ByteBuffer 是一个被"包装"过的8字节数组，然后通过各种不同的基本类型的视图缓冲器把它显示了出来。
		 * 在输出中可以看到，当从不同类型的缓冲器读取时，数据显示的方式也不同。
		 */
		System.out.println("Byte Buffer");
		while (byteBuffer.hasRemaining()) {
			System.out.println(byteBuffer.position() + " -> " + byteBuffer.get());
		}
		
		CharBuffer charBuffer = ((ByteBuffer) byteBuffer.rewind()).asCharBuffer();
		System.out.println("Char Buffer");
		while (charBuffer.hasRemaining()) {
			System.out.println(charBuffer.position() + " -> " + charBuffer.get());
		}
		
		FloatBuffer floatBuffer = ((ByteBuffer) byteBuffer.rewind()).asFloatBuffer();
		System.out.println("Float Buffer");
		while (floatBuffer.hasRemaining()) {
			System.out.println(floatBuffer.position() + " -> " + floatBuffer.get());
		}
		
		IntBuffer intBuffer = ((ByteBuffer) byteBuffer.rewind()).asIntBuffer();
		System.out.println("Int Buffer");
		while (intBuffer.hasRemaining()) {
			System.out.println(intBuffer.position() + " -> " + intBuffer.get());
		}
		
		LongBuffer longBuffer = ((ByteBuffer) byteBuffer.rewind()).asLongBuffer();
		System.out.println("Long Buffer");
		while (longBuffer.hasRemaining()) {
			System.out.println(longBuffer.position() + " -> " + longBuffer.get());
		}
		
		ShortBuffer shortBuffer = ((ByteBuffer) byteBuffer.rewind()).asShortBuffer();
		System.out.println("Short Buffer");
		while (shortBuffer.hasRemaining()) {
			System.out.println(shortBuffer.position() + " -> " + shortBuffer.get());
		}
		
		DoubleBuffer doubleBuffer = ((ByteBuffer) byteBuffer.rewind()) .asDoubleBuffer();
		System.out.println("Double Buffer");
		while (doubleBuffer.hasRemaining()) {
			System.out.println(doubleBuffer.position() + " -> " + doubleBuffer.get());
		}
	}
}
