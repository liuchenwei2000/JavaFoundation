/**
 * 
 */
package nio.bytebuffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import nio.IConst;

/**
 * CharBuffer���ֽ�/�ַ�ת���ı���/������ʾ
 * <p>
 * ���������ɵ�����ͨ���ֽڣ�Ϊ�˰�����ת�����ַ���
 * <li>1��Ҫô���������ǵ�ʱ�������б���(�������������ʱ�ž�����ν)
 * <li>2��Ҫô�ڽ���ӻ��������ʱ�����ǽ��н���
 * <p>
 * ����ʹ��java.nio.charset.Charset��ʵ����Щ���ܣ������ṩ�˰����ݱ���ɶ��ֲ�ͬ���͵��ַ����Ĺ��ߡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-23
 */
public class CharBufferEnDecodeDemo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/nio.bytebuffer/data1.txt";
		FileChannel channel = new FileOutputStream(fileName).getChannel();
		channel.write(ByteBuffer.wrap("Some text".getBytes()));
		channel.close();
		channel = new FileInputStream(fileName).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(IConst.K);
		channel.read(buff);
		buff.flip();
		// CharBuffer��toString����������ģ�
		// ����һ�������������������ַ����ַ���
		// ��������ĵ���ȴ��ӡ������һ������
		System.out.println(buff.asCharBuffer());
		
		/** ʹ��ϵͳĬ���ַ������н���(��Ӧ��2�ַ�ʽ) */
		// rewind()������Ϊ���û������ص����ݿ�ʼ�ĵط�
		buff.rewind();
		// ����ϵͳĬ���ַ����ַ���
		String encoding = System.getProperty("file.encoding");
		// Charset.forName()���Բ���Charset���󣬿����������ַ������н���
		System.out.println("Decoded using " + encoding + ": "
				+ Charset.forName(encoding).decode(buff));
		
		/** ʹ��ָ�����ַ���(UTF-16BE)��������ֽڽ��б���(��Ӧ��1�ַ�ʽ) */
		channel = new FileOutputStream(fileName).getChannel();
		channel.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		channel.close();
		// ����������CharBuffer������Щ�ֽڣ��������������ı�
		channel = new FileInputStream(fileName).getChannel();
		buff.clear();
		channel.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
		/** ʹ��CharBuffer��ByteBufferд�� */ 
		channel = new FileOutputStream(fileName).getChannel();
		buff = ByteBuffer.allocate(24); // More than "Some text" 
		buff.asCharBuffer().put("Some text");
		channel.write(buff);
		channel.close();
		// ͨ�� CharBuffer������Щ�ַ�����ӡ����
		// ����������3���ַ��ռ䣬������\0��ʽ��䣬��ӡ�����ɼ�Ч��
		channel = new FileInputStream(fileName).getChannel();
		buff.clear();
		channel.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
	}
}