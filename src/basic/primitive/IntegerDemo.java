/**
 * 
 */
package primitive;

/**
 * int��װ����ʾ
 * <p>
 * ��������������short��byte��long�İ�װ��ķ���������
 * <p>
 * int�����ݵ��ֽڳ���Ϊ4��һ����32λ(bit)��
 * ��һλ���ڱ�ʾ�����ţ�����λ������������������ֵ��
 * int�����ݵ����ֵ���ǳ��˵�һλΪ0(��ʾ����)���⣬����λ����1������Ҳ���� 2<sup>31</sup>-1����Сֵ��-2<sup>31</sup>��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-13
 */
public class IntegerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Integer.parseInt����ʹ�õڶ�������ָ���Ļ���(Ĭ��Ϊ10)�����ַ�����������Ϊ�з��ŵ�����(ԭʼ����)
		 * �����ַ����ĵ�һ���ַ�ֻ�������ֻ�����'-'(����)������������ָ������������(��2Ϊ����ʱֻ����0��1)
		 * �������NumberFormatException
		 */
		int i = Integer.parseInt("-101");
		System.out.print(i + " ");
		i = Integer.parseInt("-101", 2);
		System.out.print(i + " ");
		/*
		 * Integer.valueOf����ʹ�ú�perseInt�������ƣ�ֻ�������ص�������һ����װ�����(��Integer)��
		 */
		Integer in = Integer.valueOf("-101");
		System.out.print(in + " ");
		in = Integer.valueOf("-101", 2);
		System.out.print(in + " ");
		/*
		 * Integer.toString�����õڶ�������ָ���Ļ������ص�һ���������ַ�����ʾ��ʽ
		 * �������������[Character.MIN_RADIX,Character.MAX_RADIX]�����Χ�����10
		 */
		String s = Integer.toString(-101, 10);
		System.out.print(s + " ");
		s = Integer.toString(-5, 2);
		System.out.print(s + " ");
		/*
		 * Integer�໹�ṩ�˽�������ʾΪ�����ơ��˽��ƺ�ʮ�������ַ�����ʽ�ķ���
		 */
		s = Integer.toBinaryString(15);// ������
		System.out.print(s + " ");
		s = Integer.toOctalString(15);// �˽���
		System.out.print(s + " ");
		s = Integer.toHexString(15);// ʮ������
		System.out.print(s + " ");
	}
}