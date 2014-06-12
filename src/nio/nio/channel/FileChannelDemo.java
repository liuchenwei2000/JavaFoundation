/**
 * 
 */
package nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import nio.IConst;

/**
 * FileChannel��ʾ��
 * <p>
 * channel(ͨ��)��һ���൱�����Ķ��������������������ڶ�д��ByteBuffer��
 * <p>
 * ��I/O������������౻�Ľ��ˣ����Բ���FileChannel�������ǣ�
 * FileInputStream��FileOutputStream �Լ�RandomAccessFile
 * ע����Щ���ֽ�������Ͳ��nio����һ�¡�
 * <p>
 * Reader��Writer���ַ�ģʽ�಻�����ڲ���ͨ��������java.nio.channels.Channels 
 * �����ṩʵ�÷�����������ͨ���в���Reader��Writer��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-23
 */
public class FileChannelDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/nio.channel/data.txt";
		// ͨ��ͨ��д���ļ�
		FileChannel fc = new FileOutputStream(fileName).getChannel();
		/*
		 * ���ֽڴ����ByteBuffer�ķ���֮һ�ǣ�
		 * ʹ��put()��ط���ֱ�Ӷ����ǽ�����䣬����һ�����ֽڣ�������������͵�ֵ
		 * Ҳ����ʹ��warp()�������Ѵ��ڵ��ֽ�����"��װ"��ByteBuffer��
		 * һ����ˣ��Ͳ��ٸ��Ƶײ�����飬���ǰ�����Ϊ��������ByteBuffer�Ĵ洢��
		 * ��֮Ϊ����֧�ֵ� ByteBuffer
		 */
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		// ͨ��ͨ����ȡ�ļ�
		fc = new FileInputStream(fileName).getChannel();
		/*
		 * ����ֻ�����ʣ�������ʽ��ʹ�þ�̬�� allocate()���������� ByteBuffer
		 * nio ��Ŀ�����Ҫ�����ƶ��������ݣ����ByteBuffer�Ĵ�С���Ե���Ϊ��Ҫ
		 * ʵ���ϣ�����ʹ�õ�1K���ܱ�ͨ��Ӧ��ʹ�õ�ҪСһ��(����ͨ��ʵ���������ǵ�Ӧ�����ҵ���ѳߴ�)
		 * Ҳ����ʹ�� allocateDirect() ������ allocate()����ȡ������ٶ�
		 * ���ڲ���һ���ڸ��߲������ϲ���ϵͳ��"ֱ��"������"
		 * ���ǣ����ַ���Ŀ�֧����󣬲��Ҿ���ʵ��Ҳ�����ϵͳ�Ĳ�ͬ����ͬ
		 * ��˱����ٴ�ʵ������Ӧ�����鿴ֱ�ӻ����Ƿ���Ի���ٶ��ϵ����� 
		 */
		ByteBuffer buff = ByteBuffer.allocate(IConst.K);
		fc.read(buff);
		buff.flip();
		while (buff.hasRemaining()) {
			System.out.print((char) buff.get());
		}
	}
}