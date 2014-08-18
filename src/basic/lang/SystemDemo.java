/**
 * 
 */
package lang;

import java.util.Arrays;

/**
 * System��Ļ�������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-7
 */
public class SystemDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.err.println("��׼�����������");
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = new int[8];
		
		// ��ָ��Դ�����и���һ�����顣�����б�
		// (Դ����,Դ���鿪ʼ���Ƶ�λ��,Ŀ������,Ŀ�����鿪ʼ���Ƶ�λ��,���Ƴ���)
		System.arraycopy(a, 0, b, 0, b.length);
		System.out.println(Arrays.toString(b));
		
		// ���ص�ǰ��ϵͳ����
		String properties = System.getProperties().toString();
		System.out.println(properties.replaceAll(",", "\n"));
		
		long start, end;
		// �����Ժ���Ϊ��λ�ĵ�ǰʱ��
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			// do nothing
		}
		end = System.currentTimeMillis();
		System.out.println("Run Time:" + (end - start) + " ms");
		
		System.gc();// ��������������
		
		/*
		 * ��ֹ��ǰ�������е�Java�����
		 * ��������״̬�룬���ݹ����������״̬���ʾ�쳣��ֹ
		 * exit����ʵ���ϵ���Runtime���е�exit�������÷�����Զ������������
		 * �÷���������main�����п��Ա������⣬�����ĵط�����Ӧ�õ���
		 */
		System.exit(0);
	}
}