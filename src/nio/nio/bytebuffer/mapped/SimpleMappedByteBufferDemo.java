/**
 * 
 */
package nio.bytebuffer.mapped;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import nio.IConst;

/**
 * MappedByteBuffer����ʾ��
 * <p>
 * �洢��ӳ���ļ����������޸���Щ��Ϊ̫������ܷ����ڴ���ļ���
 * ���˴洢��ӳ���ļ����Ϳ��Լٶ������ļ������ڴ���(�����ڴ�)��
 * ���ҿ�����ȫ���������ǳ�������������ʡ�
 * ���ַ�������ؼ��������޸��ļ��Ĵ��롣
 * <strong>�����һ��32M���ļ���Ҫ�ֹ�ɾ������ļ�</strong>
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-25
 */
public class SimpleMappedByteBufferDemo {
	
	private static final String FILE_NAME = "files/nio.bytebuffer.mapped/test.dat";
	/** �ļ���С 32M */
	private static final int FILE_SIZE = 32 * IConst.M;
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * ͨ��FileChannel����map��������һ��MappedByteBuffer
		 * ���������ֱ�ӻ�����������ָ��ӳ���ļ��ĳ�ʼλ�ú�ӳ������ĳ���
		 * ����ζ�ſ���ӳ��ĳ�����ļ���һ����С�Ĳ���
		 * 
		 * MappedByteBuffer��ByteBuffer�̳ж���
		 * ���������ByteBuffer�����з���
		 * ��������չʾ�˷ǳ��򵥵�put()��get()
		 * ����ͬ������ʹ����asCharBuffer()���������÷�
		 */
		MappedByteBuffer out = new RandomAccessFile(FILE_NAME, "rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, FILE_SIZE);
		// ���ļ���д��32M���ַ�'x'
		for (int i = 0; i < FILE_SIZE; i++) {
			out.put((byte) 'x');
		}
		System.out.println("Finished writing");
		// ��ȡ�ļ���6���ֽڵ�����
		for (int i = FILE_SIZE / 2; i < FILE_SIZE / 2 + 6; i++) {
			System.out.print((char) out.get(i));
		}
	}
}