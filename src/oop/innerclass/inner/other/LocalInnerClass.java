/**
 * 
 */
package inner.other;

/**
 * �ֲ��ڲ�����ʾ
 * <p>
 * �����ڴ�����д����ڲ��࣬���͵ķ�ʽ����һ������������洴����
 * �ֲ��ڲ��಻���з������η����������ⲿ���һ���֡�
 * ���������Է��ʵ�ǰ�����ĳ������Լ����ⲿ������г�Ա��
 * <p>
 * ʹ�þֲ��ڲ������ʹ�������ڲ����ԭ���У�</br>
 * <li>1����Ҫһ�������Ĺ�������������Ҫ���ع�����
 * <li>2����Ҫ��ֹһ�����ڲ���Ķ���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-18
 */
public class LocalInnerClass {
	
	private int count = 0;
	
	/**
	 * �ֲ��ڲ���չʾ
	 */
	Counter getLocalCounter(final String name) {
		
		class LocalCounter implements Counter {
			
			/**
			 * �ֲ��ڲ���������Լ��Ĺ�����
			 */
			public LocalCounter() {
				System.out.println("LocalCounter()");
			}

			public int next() {
				System.out.println(name);
				return count++;
			}
		}
		return new LocalCounter();
	}
	
	/**
	 * �����ڲ���չʾ
	 */
	Counter getCounter(final String name) {
		
		return new Counter() {
			/**
			 * �����ڲ��಻�����Լ��Ĺ��췽����ֻ��ʹ��ʵ����ʼ���ķ������г�ʼ������
			 */
			{
				System.out.println("AnonymousCounter()");
			}

			public int next() {
				System.out.println(name);
				return count++;
			}
		};
	}
}

interface Counter{
	int next();
}