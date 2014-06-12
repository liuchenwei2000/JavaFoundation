/**
 * 
 */
package primitive;

/**
 * char��װ�����ʾ
 * <p>
 * Character���ṩ�˳��õ��ַ������жϷ���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-13
 */
public class CharacterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Character.isDigit(char)�����ж�һ���ַ��Ƿ�������
		 * Character.isLetter(char)�����ж�һ���ַ��Ƿ�����ĸ
		 * Character.isLetterOrDigit(char)�����ж�һ���ַ��Ƿ�Ϊ��ĸ������
		 */
		char ch = 'a';// ������'1'��'%'��'è'��','��'��'��
		System.out.println(ch
				+ (Character.isDigit(ch) ? " is digit" : " is not digit"));
		System.out.println(ch
				+ (Character.isLetter(ch) ? " is letter" : " is not letter"));
		System.out.println(ch
				+ (Character.isLetterOrDigit(ch) ? " is letter or digit"
						: " is not letter or digit"));
		/*
		 * Character.isLowerCase(char)�жϲ����ַ��Ƿ��Ǵ�д��ʽ
		 * Character.isLowerCase(char)�жϲ����ַ��Ƿ���Сд��ʽ
		 * Character.toUpperCase(char)���ز����ַ��Ĵ�д��ʽ���ַ�
		 * Character.toLowerCase(char)���ز����ַ���Сд��ʽ���ַ�
		 */
		if (Character.isLowerCase(ch))
			System.out.println(ch + " is LowerCase");
		ch = Character.toUpperCase(ch);
		System.out.println("UpperCase : " + ch);
		if (Character.isUpperCase(ch))
			System.out.println(ch + " is UpperCase");
		ch = Character.toLowerCase(ch);
		System.out.println("LowerCase : " + ch);
	}
}