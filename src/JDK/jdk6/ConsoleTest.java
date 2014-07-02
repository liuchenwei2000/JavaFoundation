/**
 * 
 */
package jdk6;

import java.io.Console;

/**
 * 7��Console��ʾ��
 * <p>
 * JDK6���ṩ��java.io.Console��ר�������ʻ����ַ��Ŀ���̨�豸��
 * <p>
 * ��ĳ������Ҫ��Windows�µ�cmd����Linux�µ�Terminal�������Ϳ�����Console����͡�
 * ���������ܵõ����õ�Console, һ��JVM�Ƿ��п��õ�Console�����ڵײ�ƽ̨��JVM��α����á�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-30
 */
public class ConsoleTest {

	/**
	 * ע��
	 * <p>
	 * �����IDE���������������,����� Console is unavailable.
	 * ��ʾConsole���ɻ�ã�������ΪJVM�������������б����õĻ�������������ض����ˡ�
	 * ��������ģʽ�����г���Ϳ���Consoleʵ���ˡ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ���JVM���ڽ���ʽ������(����Windows��cmd)�������ģ������������û���ض�������ĵط���
		 * ��ô�Ϳ��Եõ�һ�����õ�Consoleʵ����
		 * �����������Զ������ģ����磬�ɺ�̨��ҵ���ȳ�������������ô��ͨ��û�п���̨�� 
		 */
		Console console = System.console();
		if (console != null) {// �ж�console�Ƿ����
			// �ӿ���̨��ȡ�����ı�
			String user = new String(console.readLine("Enter user:"));
			// �ӿ���̨��ȡ���룬���û��ԡ�
			String pwd = new String(console.readPassword("Enter passowrd:"));
			// ʹ��ָ����ʽ�ַ����Ͳ�������ʽ���ַ���д��˿���̨������ı�ݷ���
			console.printf("User is:" + user + "\n");
			console.printf("Password is:" + pwd + "\n");
		} else {
			System.out.println("Console is unavailable");
		}
	}
}
