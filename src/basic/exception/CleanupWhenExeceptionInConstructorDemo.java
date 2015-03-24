/**
 * 
 */
package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ������ʾ
 * <p>
 * �����ڹ���׶ο��ܻ��׳��쳣����Ҫ��������࣬�ȫ�ķ�ʽ��ʹ��Ƕ�׵�try�Ӿ䣬����������ǣ�
 * �ڴ�����Ҫ����Ķ���֮����������һ�� try-finally ���顣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-6
 */
public class CleanupWhenExeceptionInConstructorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "files/exception.constructor/CleanupDemo.txt";
		try {
			InputFile in = new InputFile(filePath);
			try {
				String s;
				while ((s = in.getLine()) != null) {
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println("caught exception in main");
				e.printStackTrace();
			} finally {
				in.dispose();
			}
		} catch (Exception e) {
			System.out.println("InputFile construction failed");
		}
	}
}

/**
 * �������е��쳣������ʾ
 * <p>
 * ����쳣�����ˣ����еĶ������ܱ���ȷ����ô�����ܴ����������Ƿǳ���ȫ�ģ����漰��������ʱ����ͳ����ˣ�
 * ��������Ѷ������óɰ�ȫ�ĳ�ʼ״̬���������б�Ķ����������һ���ļ���
 * �����Ķ���ֻ���ڶ���ʹ����ϲ��ҵ����������������֮����ܵ�����������ڹ��������׳����쳣����Щ������ΪҲ��Ͳ�������������
 * Ҳ��ʹ��finally�Ϳ��Խ�����⣬������ֻ����ô�򵥣���Ϊfinally��ÿ�ζ�ִ��������룬
 * �������������ִ�й����а�;���ϣ�Ҳ��ö����ĳЩ���Ի�û�б��ɹ�����ȴҪ��finally�б�����
 */
class InputFile {
	
	private BufferedReader in;

	public InputFile(String fileName) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fileName));
			// other code that might throws exception
		} catch (FileNotFoundException e) {
			System.out.println("could not open " + fileName);
			// wasn't open,so don't close it
			throw e;
		} catch (Exception e) {
			// all other exception must close it
			try {
				in.close();
			} catch (IOException ex) {
				System.out.println("in.close unsuccessful");
			}
			throw e;
		} finally {
			// don't close it here
			// ����finally����ÿ�ι��������֮��ִ��һ�飬������ʵ�ڲ�Ӧ���ǵ���close()�ر��ļ��ĵط���
			// ��Ϊϣ���ļ���InputFile��������������������ļ������ڴ�״̬��
		}
	}

	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readline() failed");
		}
		return s;
	}

	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() successful");
		} catch (IOException e) {
			throw new RuntimeException("in.close() failed");
		}
	}
}