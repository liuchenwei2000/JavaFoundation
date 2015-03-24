package nio.bytebuffer.mapped;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

/**
 * MappedByteBuffer �߼���ʾ��
 * <p>
 * ���������ϵͳ�������������ڴ潫�ļ����ļ���һ������"ӳ��"���ڴ��У�
 * �����Ϳ������ļ����ڴ���һ�������ˣ���ȴ�ͳ���ļ�ϵͳҪ��öࡣ
 * ����"��"��I/O������nioʵ�ֺ�����������ߣ� ����ӳ���ļ������������Ը��������ؼӿ��ٶȡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-21
 */
public class AdvMappedByteBufferDemo {

	/**
	 * ����ͨ������ѹ���ļ�CRC32У�����֤�����ڴ�ӳ���ļ��ȴ�ͳ��������������������Ҫ�졣
	 */
	public static void main(String[] args) throws Exception {
		String JAVA_HOME = System.getProperty("java.home");
		String jarFilePath = JAVA_HOME + "/lib/charsets.jar";
		
		printResult(new InputStreamCRCSumChecker(), jarFilePath);
		printResult(new BufferedInputStreamCRCSumChecker(), jarFilePath);
		printResult(new MappedFileCRCSumChecker(), jarFilePath);
	}

	private static void printResult(ICRCSumChecker checker, String filePath) {
		System.out.println(checker.getClass().getSimpleName());
		try {
			long start = System.currentTimeMillis();
			long sum = checker.checkCRCSum(filePath);
			long end = System.currentTimeMillis();
			System.out.println("CRC Sum = " + Long.toHexString(sum));
			System.out.println((end - start) / (double) 1000 + " s");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}

interface ICRCSumChecker {
	
	public long checkCRCSum(String filePath) throws Exception;
}

/**
 * �ڴ�ӳ�����CRC��
 * <p>
 * ��ʹ����ӳ���ļ��Ļ��Ѻܴ󣬵��������������I/O����˵���Ǻ������ġ�
 */
class MappedFileCRCSumChecker implements ICRCSumChecker {

	public long checkCRCSum(String filePath) throws Exception {
		FileInputStream fis = null;
		FileChannel channel = null;
		try {
			fis = new FileInputStream(filePath);
			channel = fis.getChannel();
			
			CRC32 crc = new CRC32();
			
			/*
			 * map�������ļ���һ����ӳ�䵽�ڴ���
			 * <p>
			 * ͨ������FileChannel���map�������Ի��MappedByteBuffer������ָ����Ҫ����ӳ����ļ������ӳ��ģʽ��
			 * ������ģʽ��
			 * 1��FileChannel.MapMode.READ_ONLY
			 * �����������ֻ���ģ��κ���ͼд�뻺�����ľٶ����������׳�ReadOnlyBufferException��
			 * 2��FileChannel.MapMode.READ_WRITE
			 * �����������д����Щ�ı�ἰʱд���ļ��С�
			 * 3��FileChannel.MapMode.PRIVATE��
			 * �����������д�������κθı䶼��˽�еģ������Ըû�������Ч��������д���ļ��С�
			 */
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, (int) channel.size());
			
			/* 
			 * һ����ȡ�˻������������� ByteBuffer ��� Buffer �����д���ݡ�
			 * ������֧��˳���������ݷ��ʣ���������һ����get��put����ʹ�õ�λ�á�
			 */
			
		    // ˳������������е�ȫ���ֽڣ�
			// hasRemaining�жϵ�ǰ������λ���Ƿ�ﵽ�����������λ�ã����û���򷵻�true
			while (buffer.hasRemaining()) {
				// get��ȡ��ǰλ�õ��ֽڲ��ƶ�����ǰλ�õ���һ���ֽ�λ��
				crc.update(buffer.get());
			}
			// �������
			// limit���ػ�����������(�����λ��)
//			for (int i = 0; i < buffer.limit(); i++) {
			    // ��ȡָ��λ�õ��ֽ�
//				byte b = buffer.get(i);
//			}
			return crc.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (channel != null) {
				channel.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}
}

/**
 * ��ͳ����������CRC��
 */
class InputStreamCRCSumChecker implements ICRCSumChecker {

	public long checkCRCSum(String filePath) throws Exception {
		InputStream in = null;
		try {
			in = new FileInputStream(filePath);
			CRC32 crc = new CRC32();
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
			return crc.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}

/**
 * ��������������CRC��
 */
class BufferedInputStreamCRCSumChecker implements ICRCSumChecker {

	public long checkCRCSum(String filePath) throws Exception {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			CRC32 crc = new CRC32();
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
			return crc.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}