/**
 * 
 */
package string;

/**
 * StringBuilder��ʾһ���ɱ���ַ�����(Ĭ������16)
 * <p>
 * �����ṩһ����StringBuffer���ݵ�API��������֤ͬ����
 * ���౻�������StringBuffer��һ�������滻�� �����ַ����������������߳�ʹ�õ�ʱ��
 * �������Ȳ��ø��࣬��Ϊ�ڴ����ʵ���У�����StringBufferҪ�졣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-13
 */
public class StringBuilderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		/*
		 * ��StringBuilder�ϵ���Ҫ������append��insert��������������Щ�������Խ����������͵����ݣ�
		 * ÿ������������Ч�ؽ�����������ת�����ַ�����Ȼ�󽫸��ַ������ַ�׷�ӻ���뵽�ַ����������С�
		 * append����ʼ�ս���Щ�ַ���ӵ���������ĩ�ˣ���insert��������ָ���ĵ�����ַ���
		 * */
		sb.append("this a sb");
		sb.insert(4, " is");
		System.out.println(sb);
		/*
		 * delete(int start,int end)�Ƴ������е����ַ����е��ַ���
		 * �����ַ�����ָ���� start ����ʼ��һֱ������ end - 1�����ַ�����������������ַ�����һֱ������β����
		 * ���start����end���򲻷����κθ��ġ�
		 * 
		 * deleteCharAt(int index)�Ƴ�������ָ��λ���ϵ�char��
		 */
		System.out.println("after deleting " + sb.substring(4, 7) + " : "
				+ sb.delete(4, 7));
		System.out.println("after deleting char " + sb.charAt(sb.length() - 1)
				+ " : " + sb.deleteCharAt(sb.length() - 1));
		// setCharAt(int index,char ch)���������������ַ�����Ϊch
		sb.setCharAt(0, 'T');
		System.out.println(sb);
		// length()���������������ַ�����
		System.out.println("length of sb : " + sb.length());
		// capacity()�������ĵ�ǰ����(Ĭ��16������Ҫ����ʱ�Զ�����)
		System.out.println("capacity of sb : " + sb.capacity());
		// �����ַ��������䷴ת��ʽȡ��
		System.out.println("reverse : " + sb.reverse());
		System.out.println("after revercing sb : " + sb);
	}
}