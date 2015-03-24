/**
 * 
 */
package lang;

/**
 * Runtime��ʾ��
 * <p>
 * Runtime���װ������ʱ�Ļ�����
 * ÿ��JavaӦ�ó�����һ��Runtime��ʵ����ʹӦ�ó����ܹ��������еĻ��������ӡ�
 * <p>
 * һ�㲻��ʵ����һ��Runtime����Ӧ�ó���Ҳ���ܴ����Լ���Runtime��ʵ����
 * ������ͨ��getRuntime()������ȡ��ǰRuntime����ʱ��������á�
 * һ���õ���һ����ǰ��Runtime��������ã��Ϳ��Ե���Runtime����ķ���ȥ����Java�������״̬����Ϊ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-13
 */
public class RuntimeDemo {

	/**
	 * Runtime����Ӧ����Ҫ��������
	 * 1���ڴ����
	 * 2��ִ����������
	 */
	public static void main(String[] args) {
		/*
		 * Java�ṩ�����õ�Ԫ�Զ��ռ����ơ�
		 * ͨ��totalMemory()��freeMemory()��������֪������Ķ��ڴ��ж�󣬻�ʣ����
		 * Java�������ԵĻ�����������(δʹ�õĶ���)���Ա��ͷ��ڴ�ռ�
		 * ��������������ռ�������һ��ָ���������ռ������Ķ��󣬿���ͨ������gc()������������Ҫ�������õ�Ԫ�ռ���
		 */
		Runtime runtime = Runtime.getRuntime();
		long mem1, mem2;// �����ڴ��ֽ���
		Integer someints[] = new Integer[1000];
		// ���� Java ������е��ڴ�����(��λ �ֽ�)
		System.out.println("�ڴ�����(B) ��" + runtime.totalMemory());
		// ���� Java ������еĿ����ڴ��������� gc �������ܵ��� freeMemory ����ֵ������
		mem1 = runtime.freeMemory();
		System.out.println("��ʼ�����ڴ�(B) : " + mem1);
		runtime.gc();
		mem1 = runtime.freeMemory();
		System.out.println("�������պ�����ڴ�(B) : " + mem1);
		for (int i = 0; i < 1000; i++) {
			someints[i] = new Integer(i);
		}
		mem2 = runtime.freeMemory();
		System.out.println("�ڴ�����Ŀ����ڴ�(B) : " + mem2);
		System.out.println("�ڴ����ʹ�õ��ڴ�(B) : " + (mem1 - mem2));
		for (int i = 0; i < 1000; i++) {
			someints[i] = null;
		}
		// �������������������� System.gc() �ǵ��ô˷�����һ�ִ�ͳ����ݵķ�ʽ
		runtime.gc();
		mem2 = runtime.freeMemory();
		System.out.println("�ڴ��ͷŲ����������պ�Ŀ����ڴ�(B) : " + mem2);
		
		
		/*
		 * �ڰ�ȫ�Ļ����У������ڶ��������ϵͳ��ʹ��Javaȥִ�������ر��Ľ���(Ҳ���ǳ���)
		 * exec()�����м�����ʽ������Ҫ���еĳ���������������
		 * exec()��������һ��Process���󣬿���ʹ������������Java�����������еĽ��̽��н���
		 */
		Process p = null;
		try {
			// ��Windows���±����򣬵����±����رպ��̲߳Ż���������
			p = runtime.exec("notepad");
			// �̵߳ȴ���ֱ�����±����̽���
			p.waitFor();
		} catch (Exception e) {
			System.out.println("Error executing notepad.");
		}
		 System.out.println("Notepad returned " + p.exitValue());
	}
}