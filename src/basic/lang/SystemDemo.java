/**
 * 
 */
package lang;

import java.util.Arrays;

/**
 * System类的基本方法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-7
 */
public class SystemDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.err.println("标准错误输出流！");
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = new int[8];
		
		// 从指定源数组中复制一个数组。参数列表：
		// (源数组,源数组开始复制的位置,目标数组,目标数组开始复制的位置,复制长度)
		System.arraycopy(a, 0, b, 0, b.length);
		System.out.println(Arrays.toString(b));
		
		// 返回当前的系统属性
		String properties = System.getProperties().toString();
		System.out.println(properties.replaceAll(",", "\n"));
		
		long start, end;
		// 返回以毫秒为单位的当前时间
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			// do nothing
		}
		end = System.currentTimeMillis();
		System.out.println("Run Time:" + (end - start) + " ms");
		
		System.gc();// 运行垃圾回收器
		
		/*
		 * 终止当前正在运行的Java虚拟机
		 * 参数用作状态码，根据惯例，非零的状态码表示异常终止
		 * exit方法实际上调用Runtime类中的exit方法，该方法永远不会正常返回
		 * 该方法除了在main方法中可以被调用外，其他的地方都不应该调用
		 */
		System.exit(0);
	}
}