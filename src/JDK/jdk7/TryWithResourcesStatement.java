/**
 * 
 */
package jdk7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 5��try-with-resources���
 * <p>
 * Java SE 7��������try-with-resources��䡣try-with-resources�����һ��������һ��������Դ��try��䡣
 * �����һ����Դָ������ʹ����ɺ����ر��ͷŵĶ���try-with-resources������ȷ���ڸ����ִ��֮��ر�ÿ����Դ��
 * ����ʵ����java.lang.AutoCloseable�ӿڵĶ����������Ϊ��Դ��try-with-resources�����ʹ��(java.io.Closeable�����ӽӿڣ����Ҳ֧��)��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��19��
 */
public class TryWithResourcesStatement {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String path = "";
		doBeforeJDK1_7(path);
		doAfterJDK1_7(path);
		doAfterJDK1_7_2();
	}

	/**
	 * ��Java SE 7֮ǰ��Ϊ��ȷ����Դ���رգ����ܻ��д���´��룺
	 */
	private static String doBeforeJDK1_7(String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			return br.readLine();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	/**
	 * ��Java SE 7�У�����������Ĵ������滻����Ĵ����ˣ�
	 */
	private static String doAfterJDK1_7(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
	
	/**
	 * try�п���ͬʱ���������Դ��
	 * <p>
	 * try-with-resources���ִ����Ϻ�ϵͳ�ȹر��ͷ�bw���ٹر��ͷ�br��
	 * Ҳ����˵��try-with-resources�������Դ�Ĺر��ͷ�˳������Ǵ�����˳���෴��
	 */
	private static void doAfterJDK1_7_2() throws IOException {
		try (
				BufferedReader br = new BufferedReader(new FileReader("in.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"))
			) 
		{
			bw.write(br.readLine());
		}
	}
}
