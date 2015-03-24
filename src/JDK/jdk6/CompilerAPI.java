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
 * 4���ӳ����е��� Java������ʾ��
 * <p>
 * ������JDK6��Compiler API(JSR 199)ȥ��̬����JavaԴ�ļ���
 * <p>
 * Compiler API��Ϸ��书�ܾͿ���ʵ�ֶ�̬�Ĳ���Java���벢����ִ����Щ���룬�е㶯̬���Ե�������
 * ������Զ���ĳЩ��Ҫ�õ���̬�����Ӧ�ó����൱���ã� ����JSP Web Server��
 * ���ֶ��޸�JSP���ǲ�ϣ������Web Server�ſ��Կ���Ч���ģ���ʱ��Ϳ�����Compiler API��ʵ�ֶ�̬����JSP�ļ���
 * ��Ȼ�����ڵ�JSP Web ServerҲ��֧��JSP�Ȳ���ģ��������������ڼ�ͨ��  Runtime.exec�� ProcessBuilder ����javac��������룬
 * ���ַ�ʽ��Ҫ������һ������ȥ�����빤�����������Ŷ�������ʹ�����������ض��Ĳ���ϵͳ��
 * Compiler APIͨ��һ�����õı�׼��API�ṩ�˸��ӷḻ�ķ�ʽȥ����̬���룬�����ǿ�ƽ̨�ġ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-29
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
			generateJavaSourceFile();// ������JavaԴ�ļ�
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ��ȡ��ƽ̨�ṩ�� Java ���Ա�����
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// ��ȡһ����׼�ļ�������ʵ�ֵ���ʵ��
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		
		try {
			// ��ȡ��ʾ�����ļ����ļ�����
			Iterable<? extends JavaFileObject> sourcefiles = fileManager.getJavaFileObjects(JAVA_SOURCE_FILE);
			// ʹ�ø�������Ͳ���������������� future ����ִ�д˱�������call��������
			compiler.getTask(null, fileManager, null, null, null, sourcefiles).call();
			fileManager.close();// �������
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// ��������class�ļ�Ų��classpath·����
		new File(JAVA_CLASS_FILE).renameTo(new File("bin/DynamicClass.class"));
		try {
			// ������̬����õ���DynamicClass���ʵ��
			Class.forName(JAVA_CLASS_NAME).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����Java��Դ�ļ�
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
