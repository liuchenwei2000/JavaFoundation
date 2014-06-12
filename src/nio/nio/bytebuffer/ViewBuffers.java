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
 * ByteBuffer���е���ͼ��������ʾ
 * <p>
 * һ���ײ��ByteBufferͨ����ͼ������������������������������ʱ��
 * �Ϳ���ֱ�ӱ�д��ͨ�����ˣ������ͨ���ж�ȡ�������ס�
 * Ȼ��ʹ����ͼ���������԰��κ����ݶ�ת����ĳһ�ض��Ļ������͡�
 * �ڱ����У�ͨ����ͬһ��ByteBuffer�Ͻ�����ͬ����ͼ��������
 * ��ͬһ�ֽ����з������short,int,float,long,��double���͵����ݡ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-23
 */
public class ViewBuffers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[] { 0, 0, 0, 0, 0, 0,
				0, 'a' });
		byteBuffer.rewind();
		/*
		 * ByteBuffer��һ����"��װ"����8�ֽ�����
		 * Ȼ��ͨ�����ֲ�ͬ�Ļ������͵���ͼ������������ʾ�˳���
		 * ����������п��������Ӳ�ͬ���͵Ļ�������ȡʱ��������ʾ�ķ�ʽҲ��ͬ
		 */
		System.out.println("Byte Buffer");
		while (byteBuffer.hasRemaining()) {
			System.out.println(byteBuffer.position() + " -> "
					+ byteBuffer.get());
		}
		CharBuffer charBuffer = ((ByteBuffer) byteBuffer.rewind())
				.asCharBuffer();
		System.out.println("Char Buffer");
		while (charBuffer.hasRemaining()) {
			System.out.println(charBuffer.position() + " -> "
					+ charBuffer.get());
		}
		FloatBuffer floatBuffer = ((ByteBuffer) byteBuffer.rewind())
				.asFloatBuffer();
		System.out.println("Float Buffer");
		while (floatBuffer.hasRemaining()) {
			System.out.println(floatBuffer.position() + " -> "
					+ floatBuffer.get());
		}
		IntBuffer intBuffer = ((ByteBuffer) byteBuffer.rewind()).asIntBuffer();
		System.out.println("Int Buffer");
		while (intBuffer.hasRemaining()) {
			System.out.println(intBuffer.position() + " -> " + intBuffer.get());
		}
		LongBuffer longBuffer = ((ByteBuffer) byteBuffer.rewind())
				.asLongBuffer();
		System.out.println("Long Buffer");
		while (longBuffer.hasRemaining()) {
			System.out.println(longBuffer.position() + " -> "
					+ longBuffer.get());
		}
		ShortBuffer shortBuffer = ((ByteBuffer) byteBuffer.rewind())
				.asShortBuffer();
		System.out.println("Short Buffer");
		while (shortBuffer.hasRemaining()) {
			System.out.println(shortBuffer.position() + " -> "
					+ shortBuffer.get());
		}
		DoubleBuffer doubleBuffer = ((ByteBuffer) byteBuffer.rewind())
				.asDoubleBuffer();
		System.out.println("Double Buffer");
		while (doubleBuffer.hasRemaining()) {
			System.out.println(doubleBuffer.position() + " -> "
					+ doubleBuffer.get());
		}
	}
}