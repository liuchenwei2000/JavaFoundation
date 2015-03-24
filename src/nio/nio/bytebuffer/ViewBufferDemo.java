/**
 * 
 */
package nio.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import nio.IConst;

/**
 * 3，视图缓冲器演示类
 * <p>
 * 视图缓冲器(view buffer)可以通过某个特定的基本数据类型的视窗查看其底层的ByteBuffer。
 * ByteBuffer依然是实际存储数据的地方，"支持"着前面的视图，因此对视图的任何修改都会映射成为对ByteBuffer中数据的修改。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-23
 */
public class ViewBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(IConst.K);
		IntBuffer intBuffer = byteBuffer.asIntBuffer();
		// 通过IntBuffer存储一组整数
		intBuffer.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
		// 通过IntBuffer进行get和put操作，操作结果直接影响ByteBuffer
		System.out.println(intBuffer.get(3));
		intBuffer.put(3, 1811);
		// 重绕此缓冲区，将位置设置为 0 并丢弃标记。 
		intBuffer.rewind();
		while (intBuffer.hasRemaining()) {
			int i = intBuffer.get();
			// 如果没有下句将会返回整个buffer，里面没存储数据的位置都是\0
			if (i == 0) break; 
			System.out.print(i + " ");
		}
	}
}