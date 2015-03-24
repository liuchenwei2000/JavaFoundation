/**
 * 
 */
package lang;

/**
 * Runtime演示类
 * <p>
 * Runtime类封装了运行时的环境。
 * 每个Java应用程序都有一个Runtime类实例，使应用程序能够与其运行的环境相连接。
 * <p>
 * 一般不能实例化一个Runtime对象，应用程序也不能创建自己的Runtime类实例。
 * 但可以通过getRuntime()方法获取当前Runtime运行时对象的引用。
 * 一旦得到了一个当前的Runtime对象的引用，就可以调用Runtime对象的方法去控制Java虚拟机的状态和行为。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-13
 */
public class RuntimeDemo {

	/**
	 * Runtime常见应用主要有两个：
	 * 1，内存管理
	 * 2，执行其他程序
	 */
	public static void main(String[] args) {
		/*
		 * Java提供了无用单元自动收集机制。
		 * 通过totalMemory()和freeMemory()方法可以知道对象的堆内存有多大，还剩多少
		 * Java会周期性的回收垃圾对象(未使用的对象)，以便释放内存空间
		 * 但是如果想先于收集器的下一次指定周期来收集废弃的对象，可以通过调用gc()方法来根据需要运行无用单元收集器
		 */
		Runtime runtime = Runtime.getRuntime();
		long mem1, mem2;// 保存内存字节数
		Integer someints[] = new Integer[1000];
		// 返回 Java 虚拟机中的内存总量(单位 字节)
		System.out.println("内存总量(B) ：" + runtime.totalMemory());
		// 返回 Java 虚拟机中的空闲内存量，调用 gc 方法可能导致 freeMemory 返回值的增加
		mem1 = runtime.freeMemory();
		System.out.println("初始空闲内存(B) : " + mem1);
		runtime.gc();
		mem1 = runtime.freeMemory();
		System.out.println("垃圾回收后空闲内存(B) : " + mem1);
		for (int i = 0; i < 1000; i++) {
			someints[i] = new Integer(i);
		}
		mem2 = runtime.freeMemory();
		System.out.println("内存分配后的空闲内存(B) : " + mem2);
		System.out.println("内存分配使用的内存(B) : " + (mem1 - mem2));
		for (int i = 0; i < 1000; i++) {
			someints[i] = null;
		}
		// 运行垃圾回收器，方法 System.gc() 是调用此方法的一种传统而便捷的方式
		runtime.gc();
		mem2 = runtime.freeMemory();
		System.out.println("内存释放并且垃圾回收后的空闲内存(B) : " + mem2);
		
		
		/*
		 * 在安全的环境中，可以在多任务操作系统中使用Java去执行其他特别大的进程(也就是程序)
		 * exec()方法有几种形式命名想要运行的程序和它的输入参数
		 * exec()方法返回一个Process对象，可以使用这个对象控制Java程序与新运行的进程进行交互
		 */
		Process p = null;
		try {
			// 打开Windows记事本程序，当记事本被关闭后线程才会向下运行
			p = runtime.exec("notepad");
			// 线程等待，直到记事本进程结束
			p.waitFor();
		} catch (Exception e) {
			System.out.println("Error executing notepad.");
		}
		 System.out.println("Notepad returned " + p.exitValue());
	}
}