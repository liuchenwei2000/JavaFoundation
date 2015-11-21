package nio.bytebuffer.mapped;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

/**
 * MappedByteBuffer 高级演示类
 * <p>
 * 大多数操作系统可以利用虚拟内存将文件或文件的一段区域"映射"到内存中，
 * 这样就可以像文件在内存中一样访问了，这比传统的文件系统要快得多。
 * 尽管"旧"的I/O流在用nio实现后性能有所提高， 但是映射文件访问往往可以更加显著地加快速度。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-21
 */
public class AdvMappedByteBufferDemo {

	/**
	 * 本例通过计算压缩文件CRC32校验和来证明：内存映射文件比传统输入流、缓冲输入流都要快。
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
 * 内存映射计算CRC和
 * <p>
 * 即使建立映射文件的花费很大，但是整体受益比起I/O流来说还是很显著的。
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
			 * map方法将文件的一部分映射到内存中
			 * <p>
			 * 通过调用FileChannel类的map方法可以获得MappedByteBuffer，可以指定需要进行映射的文件区域和映射模式。
			 * 有三种模式：
			 * 1，FileChannel.MapMode.READ_ONLY
			 * 结果缓冲区是只读的，任何试图写入缓冲区的举动都将依法抛出ReadOnlyBufferException。
			 * 2，FileChannel.MapMode.READ_WRITE
			 * 结果缓冲区可写，这些改变会及时写回文件中。
			 * 3，FileChannel.MapMode.PRIVATE：
			 * 结果缓冲区可写，但是任何改变都是私有的，仅仅对该缓冲区有效，并不会写入文件中。
			 */
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, (int) channel.size());
			
			/* 
			 * 一旦获取了缓冲区，可以用 ByteBuffer 类和 Buffer 超类读写数据。
			 * 缓冲区支持顺序和随机数据访问，缓冲区有一个被get和put操作使用的位置。
			 */
			
		    // 顺序遍历缓冲区中的全部字节：
			// hasRemaining判断当前缓冲区位置是否达到缓冲区的最后位置，如果没有则返回true
			while (buffer.hasRemaining()) {
				// get获取当前位置的字节并移动到当前位置的下一个字节位置
				crc.update(buffer.get());
			}
			// 随机访问
			// limit返回缓冲区的限制(即最后位置)
//			for (int i = 0; i < buffer.limit(); i++) {
			    // 获取指定位置的字节
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
 * 传统输入流计算CRC和
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
 * 缓冲输入流计算CRC和
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
