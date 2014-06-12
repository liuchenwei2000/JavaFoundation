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
 * 通过通道执行文件拷贝
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-23
 */
public class FileCopyByChannel {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String source = "files/nio.channel/data.txt";
		String dest = "files/nio.channel/data2.txt";
		// 用于读的FileChannel
		FileChannel inchannel = new FileInputStream(source).getChannel();
		// 用于写的FileChannel
		FileChannel outchannel = new FileOutputStream(dest).getChannel();
		// ByteBuffer 被分配了空间
		ByteBuffer buffer = ByteBuffer.allocate(IConst.K);
		/*
		 * 一旦调用了read()，就会告知FileChannel向ByteBuffer存储字节
		 * 必须调用缓冲器上的flip()，让它做好让别人读取字节的准备
		 * (是的，这似乎有一点拙劣，但是适用于获取最大速度)
		 * 如果打算使用缓冲器执行进一步的read()操作
		 * 也必须得调用clear()来为每个read()做好准备
		 * 
		 * 当FileChannel.read()返回 -1 时表示已经到达了输入的末尾
		 * 每次read()操作之后，就会将数据输入到缓冲器中
		 * flip()则是准备缓冲器以便它的信息可以由write()提取
		 * write()操作之后，信息仍在缓冲器中，接着clear()操作则对所有的内部指针重新安排
		 * 以便缓冲器在另一个read()操作期间，能够做好接受数据的准备
		 */
		while (inchannel.read(buffer) != -1) {
			buffer.flip(); // Prepare for writing
			outchannel.write(buffer);
			buffer.clear(); // Prepare for reading 
		}
		/* 
		 * 上面程序并不是处理此类操作的理想方式，特殊方法transferTo()和
		 * transferFrom()可以将一个通道和另一个通道直接相连
		 * 尤其是复制比较大的文件的时候，下面的方法更好
		 */
//		inchannel.transferTo(0, inchannel.size(), outchannel); 
//		outchannel.transferFrom(inchannel, 0, inchannel.size()); 
	}
}