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
 * ͨ��ͨ��ִ���ļ�����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-23
 */
public class FileCopyByChannel {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String source = "files/nio.channel/data.txt";
		String dest = "files/nio.channel/data2.txt";
		// ���ڶ���FileChannel
		FileChannel inchannel = new FileInputStream(source).getChannel();
		// ����д��FileChannel
		FileChannel outchannel = new FileOutputStream(dest).getChannel();
		// ByteBuffer �������˿ռ�
		ByteBuffer buffer = ByteBuffer.allocate(IConst.K);
		/*
		 * һ��������read()���ͻ��֪FileChannel��ByteBuffer�洢�ֽ�
		 * ������û������ϵ�flip()�����������ñ��˶�ȡ�ֽڵ�׼��
		 * (�ǵģ����ƺ���һ��׾�ӣ����������ڻ�ȡ����ٶ�)
		 * �������ʹ�û�����ִ�н�һ����read()����
		 * Ҳ����õ���clear()��Ϊÿ��read()����׼��
		 * 
		 * ��FileChannel.read()���� -1 ʱ��ʾ�Ѿ������������ĩβ
		 * ÿ��read()����֮�󣬾ͻὫ�������뵽��������
		 * flip()����׼���������Ա�������Ϣ������write()��ȡ
		 * write()����֮����Ϣ���ڻ������У�����clear()����������е��ڲ�ָ�����°���
		 * �Ա㻺��������һ��read()�����ڼ䣬�ܹ����ý������ݵ�׼��
		 */
		while (inchannel.read(buffer) != -1) {
			buffer.flip(); // Prepare for writing
			outchannel.write(buffer);
			buffer.clear(); // Prepare for reading 
		}
		/* 
		 * ������򲢲��Ǵ��������������뷽ʽ�����ⷽ��transferTo()��
		 * transferFrom()���Խ�һ��ͨ������һ��ͨ��ֱ������
		 * �����Ǹ��ƱȽϴ���ļ���ʱ������ķ�������
		 */
//		inchannel.transferTo(0, inchannel.size(), outchannel); 
//		outchannel.transferFrom(inchannel, 0, inchannel.size()); 
	}
}