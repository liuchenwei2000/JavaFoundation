/**
 * 
 */
package object;

/**
 * ���������ʾ
 * <p>
 * ����ЧӦ��ָ�������ָ��ͬһ������</br>
 * ��ĳ���޸��Ǹ�����ʱ����������������ͻ����ֳ�����</br>
 * ����˶���������������ָ��������ʹ����Щ���õ��˸���û�뵽������б仯��
 * ��Ȼ��Դ˸е�ʮ�ֲ��죬����
 * <li><strong>��Ҫ����ͬ������������ͬһ������Ķ������</strong>
 * <li><strong>��������Ϊ��������ʱ�������Զ���������(Java�Ĺ�����ʽ)</strong>
 * <li><strong>�ڷ����ڴ����ľֲ������ܹ��޸�"�ⲿ�Ķ���"</strong>
 *
 * @author ����ΰ
 *
 * �������ڣ�2009-6-4
 */
public class ObjectAlias {
	
	private int i;

	public ObjectAlias(int i) {
		this.i = i;
	}

	/**
	 * �������ÿ����ڷ��������޸�����ָ��Ķ���
	 * <p>
	 * ���÷�����Ϊ�˲�������ֵ������Ϊ�˸ı䱻�����ߵ�״̬��
	 * ͨ������Ϊ�˴�������������÷������Ǳ�����"Ϊ�˸����ö����÷���"��
	 * ����������޸�������������������������˵������ʹ�÷�ʽ�Լ�Ǳ��Σ�ա�
	 * <p>
	 * ���ȷʵҪ�ڷ����������޸Ĳ��������ֲ�ϣ���޸��ⲿ������
	 * ��ô��Ӧ���ڷ����ڲ�����һ�ݲ����ĸ������Ա���ԭ������
	 */
	private static void method(ObjectAlias ref) {
		ref.i++;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// x��yָ��ͬһ������
		ObjectAlias x = new ObjectAlias(7);
		ObjectAlias y = x;
		System.out.println("x: " + x.i);
		System.out.println("y: " + y.i);
		System.out.println("Incrementing x");
		x.i++;
		System.out.println("x: " + x.i);
		System.out.println("y: " + y.i);
		
		ObjectAlias z = new ObjectAlias(1);
		System.out.println("z: " + z.i);
		System.out.println("Calling method(z)");
		method(z);
		System.out.println("z: " + z.i);
	}
}