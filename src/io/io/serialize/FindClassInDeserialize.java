/**
 * 
 */
package io.serialize;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 反序列化过程时寻找类演示
 * <p>
 * 将一个对象从它的序列化状态中恢复出来有哪些工作是必须的呢？
 * 假如将一个对象序列化，并通过网络将其作为文件传送给另一台计算机，
 * 那么另一台计算机上的程序可以只利用该文件内容来重组这个对象吗？
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-26
 */
public class FindClassInDeserialize {

	/**
	 * 本例中对象对应的类文件已经被删除了 
	 * 这样可以模拟在两个计算机间传递一个序列化对象时恢复对象的情形
	 * 
	 * 打开文件和读取对象中的内容都需要Lost的Class对象
	 * 而Java虚拟机找不到Lost.class(除非它正好在classpath内，而本例却不在类路径之内)
	 * 这样就会得到一个ClassNotFoundException 的异常
	 * 除非能够验证Lost存在，否则它等于消失，必须保证Java虚拟机能找到相关的.class文件
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 对象序列化文件路径
		String fileName = "files/io.serialize/Lost.out";
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(fileName)));
		System.out.println(in.readObject().getClass());
		in.close();
	}
}