/**
 * 
 */
package generic.erase;

import java.util.ArrayList;

/**
 * ���͵����Ͳ�����ʾ
 * <p>
 * Java������ʹ�ò�����ʵ�ֵģ�����ζ�ŵ�ʹ�÷���ʱ�κξ����������Ϣ���������ˣ�
 * Ψһ֪���ľ�����ʹ��һ������
 * <p>
 * ������List<String>��List<Integer>������ʱ��ʵ������ͬ�����ͣ�
 * ��������ʽ�������������ǵ�"ԭ��"���ͣ���List��
 * <p>
 * ������Ҫ�����������ǴӷǷ������뵽���������ת����̣�
 * �Լ��ڲ��ƻ�������������£�����������Java���ԡ�
 * <p>
 * ����ʹ�����еķǷ��Ϳͻ��˴����ܹ��ڲ��ı������¼���ʹ��ֱ���ͻ���׼�����÷�����д��Щ���룬
 * ������ͻȻ�ƻ����������еĴ��롣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-16
 */
public class TypeErasedDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?> c1 = new ArrayList<Integer>().getClass();
		Class<?> c2 = new ArrayList<String>().getClass();
		if(c1 == c2) {
			System.out.println("ArrayList<Integer> and ArrayList<String> are the same class type.");
		}
	}
}
/**
 * ���ͽӿڵ����Ͳ���
 * <p>
 * Ҫ֧�ֲ�����ת������Ҫǿ������һ��������ͱ�������ͬʱ��Ϊ�����ӿ����͵����࣬
 * ���������ӿ���ͬһ�ӿڵĲ�ͬ��������
 */
interface Payable<T> {

}

class Employee implements Payable<Employee> {

}
/**
 * ��Ϊ�����ὫPayable<Employee>��Payable<Hourly>��Ϊ��ͬ����Payable��
 * ��������Ĵ������ζ�����ظ����ε�ʵ����ͬ�Ľӿڡ�
 * �����Payable�����ֱ����ж��Ƴ������Ͳ����Ϳ��Ա����ˡ�
 */
//class Hourly extends Employee implements Payable<Hourly> {
//
//}