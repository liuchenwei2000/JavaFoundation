/**
 * 
 */
package inner;

/**
 * �ӿ��е��ڲ���
 * <p>
 * ��������½ӿ����ǲ����о������ģ�����Ƕ���������Ϊ�ӿڵ�һ���֡�
 * �ŵ��ӿ��е��κ��඼�Զ�����public static����Ϊ����static�ģ�ֻ�ǽ������ڽӿڵ������ռ��ڡ�
 * ��������Υ���ӿڵĹ��������������ڲ�����ʵ������ӿڡ�
 * �����Ҫ����ĳЩ�������룬ʹ�����ǿ��Ա�ĳ���ӿڵ����в�ͬʵ�������ã��ýӿ��ڲ���Ƕ������Եúܷ��㡣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-14
 */
public interface InnerClassInInterface {

	public void print();
	
	public static class InnerImpl implements InnerClassInInterface {
		
		public void print() {
			System.out.println("Inside InnerImpl");
		}
	}
}