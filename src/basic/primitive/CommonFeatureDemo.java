/**
 * 
 */
package primitive;

/**
 * �������ͺ����װ��ʹ����ʾ
 * <p>
 * ԭʼ���Ͱ�װ���ṩ�˶������������ԭʼ���ͺ�String����֮�以��ת�� ��
 * ���ṩ�˴���ԭʼ����ʱ�ǳ����õ�����һЩ�����ͷ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-11-13
 */
public class CommonFeatureDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ����Character֮�⣬�����ԭʼ���Ͱ�װ�඼��һ����String��Ϊ�����Ĺ��췽�� 
		 */
		Character c = new Character('a');
		Integer i = new Integer(1);
		i = new Integer("1");		
		/*
		 * ����װ���valueOf��������һ���½���ʵ�����߻����е��Ѵ��ڵ�ʵ��
		 * �˷����ȹ��췽��Ч��Ҫ��(������ھ���ʹ�õ�ʵ��)��Ӧ����ʹ����
		 * ����ȷʵ��Ҫһ��������ͬ��ֵ�Ĳ�ͬ��ʵ��
		 * Character����û��valueOf(String)�������
		 */
		Integer ii = Integer.valueOf(1);
		ii = Integer.valueOf("1");	
		/*
		 * ����װ���compareTo(Type other)���������Ƚ������������͵Ĵ�С
		 * �����Type����ֵ�ϵ���other���򷵻� 0 ֵ��
		 * �����Type����ֵ��С��other���򷵻�С�� 0 ��ֵ��
		 * �����Type����ֵ�ϴ���other���򷵻ش��� 0 ��ֵ(�з��ŵıȽ�)
		 * Boolean����û�и÷���
		 */
		System.out.println(ii + " " + (ii.compareTo(2) < 0 ? "<" : ">") + " 2");
		System.out.println(ii + " " + (ii.compareTo(1) == 0 ? "=" : "<>") + " 1");
		System.out.println(ii + " " + (ii.compareTo(-2) > 0 ? ">" : "<") + " -2");
		/*
		 * ����װ���typeValue()�������ذ�װ���Ͷ����Ӧ�Ļ�������ֵ
		 */
		int value = ii.intValue();
		System.out.println(c + " " + i + " " + ii + " " + value);
	}
}