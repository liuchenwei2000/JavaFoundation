/**
 * 
 */
package nio.bytebuffer;

import java.nio.ByteBuffer;

import nio.IConst;

/**
 * ��ByteBuffer�л�ȡ��������
 * <p>
 * ����ByteBufferֻ�ܱ����ֽ����͵����ݣ����������п��Դ��������ɵ��ֽ��в��������ֲ�ͬ��������ֵ�ķ�����
 * <p>
 * ��ByteBuffer��������������ݵ���򵥵ķ����ǣ�
 * ����asCharBuffer()�Ȼ�øû������ϵ���ͼȻ��ʹ����ͼ��put()������
 * �˷������������л����������ͣ�������ʹ��ShortBuffer��put()����ʱ��Ҫ��������ת��(ע������ת�����ȡ��ı���)��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-23
 */
public class PrimaryTypeFromByteBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(IConst.K);
		// ����һ��ByteBuffer֮�����Ὣ�������Զ�����
		int i = 0;
		while (i++ < buffer.limit()) {
			if (buffer.get() != 0) {
				System.out.println("nonzero");
			}
		}
		// �������ݿ�ʼ�ĵط�
		buffer.rewind();
		/** ��ByteBuffer�д���char */
		buffer.asCharBuffer().put("Hello World!");
		char c;
		while ((c = buffer.getChar()) != 0) {
			System.out.print(c + "");
		}
		System.out.println();
		/** ��ByteBuffer�д���short */
		buffer.rewind();
		buffer.asShortBuffer().put((short) 471142);
		System.out.println(buffer.getShort());
		/** ��ByteBuffer�д���int */
		buffer.rewind();
		buffer.asIntBuffer().put(99471142);
		System.out.println(buffer.getInt());
		/** ��ByteBuffer�д���long */
		buffer.rewind();
		buffer.asLongBuffer().put(99471142L);
		System.out.println(buffer.getLong());
		/** ��ByteBuffer�д���float */
		buffer.rewind();
		buffer.asFloatBuffer().put(99471142f);
		System.out.println(buffer.getFloat());
		/** ��ByteBuffer�д���double */
		buffer.rewind();
		buffer.asDoubleBuffer().put(99471142);
		System.out.println(buffer.getDouble());
		buffer.rewind();
	}
}