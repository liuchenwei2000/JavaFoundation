/**
 * 
 */
package jdk6;

import java.io.Console;

/**
 * 7，Console类示例
 * <p>
 * JDK6 中提供了 java.io.Console 类专用来访问基于字符的控制台设备。
 * <p>
 * 你的程序如果要与 Windows 下的 cmd 或者 Linux 下的 Terminal 交互，就可以用 Console 类代劳。
 * 但不总是能得到可用的Console, 一个JVM是否有可用的Console依赖于底层平台和JVM如何被调用。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-30
 */
public class ConsoleTest {

	/**
	 * 注：
	 * <p>
	 * 如果在IDE里面运行下面程序,会输出 Console is unavailable.
	 * 表示Console不可获得，那是因为JVM不是在命令行中被调用的或者输入输出被重定向了。
	 * 在命令行模式里运行程序就可用 Console 实例了。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 如果JVM是在交互式命令行(比如Windows的cmd)中启动的，并且输入输出没有重定向到另外的地方。那么就可以得到一个可用的Console实例。
		 * 如果虚拟机是自动启动的（例如，由后台作业调度程序启动），那么它通常没有控制台。 
		 */
		Console console = System.console();
		if (console != null) {// 判断console是否可用
			// 从控制台读取单行文本
			String user = new String(console.readLine("Enter user:"));
			// 从控制台读取密码，禁用回显。
			String pwd = new String(console.readPassword("Enter passowrd:"));
			// 使用指定格式字符串和参数将格式化字符串写入此控制台输出流的便捷方法
			console.printf("User is:" + user + "\n");
			console.printf("Password is:" + pwd + "\n");
		} else {
			System.out.println("Console is unavailable");
		}
	}
}
