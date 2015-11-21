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
 * 2，CharBuffer的字节/字符转换的编码/解码演示
 * <p>
 * 缓冲器容纳的是普通的字节，为了把它们转换成字符：
 * <li>1，要么在输入它们的时候对其进行编码（这样它们输出时才具有意义）
 * <li>2，要么在将其从缓冲器输出时对它们进行解码。
 * <p>
 * 可以使用java.nio.charset.Charset类实现这些功能，该类提供了把数据编码成多种不同类型的字符集的工具。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-23
 */
public class CharBufferEnDecodeDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String fileName = "files/nio.bytebuffer/data1.txt";
		
		try {
			FileChannel channel = new FileOutputStream(fileName).getChannel();
			channel.write(ByteBuffer.wrap("Some text".getBytes()));
			channel.close();
			
			channel = new FileInputStream(fileName).getChannel();
			ByteBuffer buff = ByteBuffer.allocate(IConst.K);
			channel.read(buff);
			// 反转此缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。
			buff.flip();
			// CharBuffer的toString是这样定义的：返回一个包含缓冲期中所有字符的字符串。
			// 但是这里的调用却打印出来了一堆乱码
			System.out.println(buff.asCharBuffer());
			
			/** 使用系统默认字符集进行解码(对应第2种方式) */
			// rewind()方法是为了让缓冲器回到数据开始的地方
			buff.rewind();
			// 返回系统默认字符集字符串
			String encoding = System.getProperty("file.encoding");
			// Charset.forName()用以产生Charset对象，可以用它对字符串进行解码
			System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));
			
			/** 使用指定的字符集(UTF-16BE)对输出的字节进行编码(对应第1种方式) */
			channel = new FileOutputStream(fileName).getChannel();
			channel.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
			channel.close();
			
			// 现在试着以CharBuffer读回这些字节，就是所期望的文本
			channel = new FileInputStream(fileName).getChannel();
			buff.clear();
			channel.read(buff);
			buff.flip();
			System.out.println(buff.asCharBuffer());
			
			/** 使用CharBuffer向ByteBuffer写入 */ 
			channel = new FileOutputStream(fileName).getChannel();
			buff = ByteBuffer.allocate(24); // more than "Some text" 
			buff.asCharBuffer().put("Some text");
			channel.write(buff);
			channel.close();
			
			// 通过 CharBuffer读回这些字符并打印出来
			// 缓冲器还有3个字符空间，都会以\0形式填充，打印出来可见效果
			channel = new FileInputStream(fileName).getChannel();
			buff.clear();
			channel.read(buff);
			buff.flip();
			System.out.println(buff.asCharBuffer());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
