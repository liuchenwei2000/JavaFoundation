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
 * FileChannel演示类
 * <p>
 * channel(通道)是一种相当基础的东西：可以向它传送用于读写的ByteBuffer。
 * <p>
 * 旧I/O类库中有三个类被改进了，用以产生FileChannel，它们是：
 * FileInputStream、FileOutputStream 以及RandomAccessFile
 * 注意这些是字节流，与低层的nio特性一致。
 * <p>
 * Reader和Writer的字符模式类不能用于产生通道，但是 java.nio.channels.Channels 类
 * 能提供实用方法，用以在通道中产生Reader和Writer。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-23
 */
public class FileChannelDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		String fileName = "files/nio.channel/data.txt";
		
		// 通过通道写入文件
		FileChannel fc = new FileOutputStream(fileName).getChannel();
		/*
		 * 将字节存放于ByteBuffer的方法之一是：
		 * 使用put()相关方法直接对它们进行填充，填入一或多个字节，或基本数据类型的值；
		 * 也可以使用warp()方法将已存在的字节数组"包装"到ByteBuffer中。
		 * 一旦如此，就不再复制底层的数组，而是把它作为所产生的ByteBuffer的存储器，称之为数组支持的 ByteBuffer。
		 */
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		
		// 通过通道读取文件
		fc = new FileInputStream(fileName).getChannel();
		/*
		 * 对于只读访问，必须显式地使用静态的 allocate()方法来分配 ByteBuffer。
		 * nio 的目标就是要快速移动大量数据，因此ByteBuffer的大小就显得尤为重要，
		 * 实际上，这里使用的1K可能比通常应该使用的要小一点（必须通过实际运行来找到最佳大小）。
		 * 
		 * 也可以使用 allocateDirect() 而不是 allocate()来获取更快的速度，用于产生一个在更高层次上耦合操作系统的"直接"缓冲器"。
		 * 但是，这种分配的开支会更大，并且具体实现也随操作系统的不同而不同。
		 * 因此必须再次实际运行应用来查看直接缓冲是否可以获得速度上的优势 。
		 */
		ByteBuffer buff = ByteBuffer.allocate(IConst.K);
		fc.read(buff);
		buff.flip();
		while (buff.hasRemaining()) {
			System.out.print((char) buff.get());
		}
		fc.close();
	}
}
