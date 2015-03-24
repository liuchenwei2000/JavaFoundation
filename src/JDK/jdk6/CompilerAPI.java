/**
 * 
 */
package jdk6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 4，从程序中调用 Java编译器示例
 * <p>
 * 可以用JDK6的Compiler API(JSR 199)去动态编译Java源文件。
 * <p>
 * Compiler API结合反射功能就可以实现动态的产生Java代码并编译执行这些代码，有点动态语言的特征。
 * 这个特性对于某些需要用到动态编译的应用程序相当有用， 比如JSP Web Server。
 * 当手动修改JSP后，是不希望重启Web Server才可以看到效果的，这时候就可以用Compiler API来实现动态编译JSP文件。
 * 当然，现在的JSP Web Server也是支持JSP热部署的，但它是在运行期间通过  Runtime.exec或 ProcessBuilder 调用javac来编译代码，
 * 这种方式需要产生另一个进程去做编译工作，不够优雅而且容易使代码依赖于特定的操作系统。
 * Compiler API通过一套易用的标准的API提供了更加丰富的方式去做动态编译，而且是跨平台的。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-29
 */
public class CompilerAPI {

	private static String JAVA_SOURCE_FILE = "files/jdk6/DynamicClass.java";
	private static String JAVA_CLASS_FILE = "files/jdk6/DynamicClass.class";
	private static String JAVA_CLASS_NAME = "DynamicClass";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			generateJavaSourceFile();// 先生成Java源文件
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 获取此平台提供的 Java 语言编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// 获取一个标准文件管理器实现的新实例
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		
		try {
			// 获取表示给定文件的文件对象
			Iterable<? extends JavaFileObject> sourcefiles = fileManager.getJavaFileObjects(JAVA_SOURCE_FILE);
			// 使用给定组件和参数创建编译任务的 future ，并执行此编译任务（call方法）。
			compiler.getTask(null, fileManager, null, null, null, sourcefiles).call();
			fileManager.close();// 编译完成
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// 将编译后的class文件挪到classpath路径下
		new File(JAVA_CLASS_FILE).renameTo(new File("bin/DynamicClass.class"));
		try {
			// 创建动态编译得到的DynamicClass类的实例
			Class.forName(JAVA_CLASS_NAME).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成Java类源文件
	 */
	private static void generateJavaSourceFile() throws IOException {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(JAVA_SOURCE_FILE));
			bw.write("public class " + JAVA_CLASS_NAME + "{");
			bw.newLine();
			bw.write("public "
					+ JAVA_CLASS_NAME
					+ "(){System.out.println(\"In the constructor of DynamicClass\");}}");
			bw.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}
}
