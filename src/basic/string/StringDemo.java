/**
 * 
 */
package string;

/**
 * String��Ļ�������
 * <p>
 * String���Ƿǿɱ���(����һ�������˾Ͳ��ܹ��ı�������״̬��)��
 * <p>
 * String s1 = new String("kill"); 
 * ������ô����Ҫ�ڶ��д���һ������
 * <p>
 * String s2 = "kill"; 
 * ������String Pool��(ջ)����(ͨ��equal)��û��"kill"�������
 * �������ֱ�Ӱ�����ָ�����"kill"�������û�����ڶ��д���һ������
 * ���ҰѸ�������ӵ�String Pool�У����Ե�һ�����JVM�ǲ���������ӵ�String Pool��ȥ�ġ�
 * <p>
 * String���е�ÿһ�����������޸�Stringֵ�ķ����� ʵ���϶��Ǵ�����һ��ȫ�µ�String�����԰����޸ĺ���ַ����� �������String������˿��δ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-8
 */
public class StringDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String s = "This is a string.";
        // ͨ���ַ����鴴���ַ���
		char[] ch = { 't', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 's',
				't', 'r', 'i', 'n', 'g' };
		s = new String(ch);
		System.out.println("s : " + s);
		// ���ش��ַ����Ĺ�ϣ��
		System.out.println("s.hashCode()=" + s.hashCode());
		// ���ش��ַ����ĳ���
		System.out.println("s.length()=" + s.length());
		// ����ָ����������charֵ
		System.out.println("s.charAt(0) : " + s.charAt(0));
		String as = "Another string.";
		System.out.println("as : " + as);
		/*
		 * compareTo(String str)���ֵ�˳��Ƚ������ַ��� 
		 * ������ֵ�˳���String�����ڲ����ַ���֮ǰ��֮����� ��ȽϽ��Ϊһ������������������0 
		 * 
		 * compareToIgnoreCase(String str)
		 * �����Ǵ�Сд�����ֵ�˳��Ƚ������ַ���
		 */
		if (s.compareTo(as) < 0) {
			System.out.println("s is before as.");
		} else if (s.compareTo(as) > 0) {
			System.out.println("s is after as.");
		} else {
			System.out.println("s equals as.");
		}
		/*
		 * equals(Object anObject)�Ƚϴ��ַ�����ָ���Ķ��� 
		 * 
		 * equalsIgnoreCase(String anotherString) 
		 * ���� String ����һ�� String ���бȽϣ������Ǵ�Сд
		 */
		as = "this is a string.";
		System.out.println("Now as : " + as);
		if (s.equals(as)) {
			System.out.println("s equals as.");
		} else if (s.equalsIgnoreCase(as)) {
			System.out.println("s equals as (ignore case).");
		} else {
			System.out.println("s not equals as.");
		}
		/*
		 * contentEquals(StringBuffer sb) 
		 * ���ҽ�����String��ʾ��ָ����StringBuffer��ͬ���ַ�����ʱ���ŷ��� true��
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("This is a string.");
		System.out.println("sb : " + sb);
		if (s.contentEquals(sb)) {
			System.out.println("s content equals sb.");
		} else {
			System.out.println("s content not equals sb.");
		}
		/*
		 * indexOf(int ch)����ָ���ַ��ڴ��ַ����е�һ�γ��ִ������� 
		 * indexOf(String str)���ص�һ�γ��ֵ�ָ�����ַ����ڴ��ַ����е����� 
		 * lastIndexOf(int ch)�������һ�γ��ֵ�ָ���ַ��ڴ��ַ����е�����
		 * lastIndexOf(String str)�����ڴ��ַ��������ұ߳��ֵ�ָ�����ַ���������
		 */
		System.out.println("'s' is first found at " + s.indexOf('s'));
		System.out.println("'s' is last found at " + s.lastIndexOf('s'));
		/*
		 * replace(char oldChar, char newChar)����һ���µ��ַ���
		 * ����ͨ����newChar�滻���ַ����г��ֵ�����oldChar�����ɵ� 
		 * 
		 * replaceAll(String regex, String replacement) 
		 * ʹ�ø�����replacement�ַ����滻���ַ���ƥ�������������ʽ��ÿ�����ַ���
		 * 
		 * replaceFirst(String regex, String replacement)
		 * ʹ�ø�����replacement�ַ����滻���ַ���ƥ�������������ʽ�ĵ�һ�����ַ���
		 */
		System.out.println("After replacing s is : " + s.replace('s', 'S'));
		/*
		 * endsWith(String suffix)���Դ��ַ����Ƿ���ָ���ĺ�׺����
		 * 
		 * startsWith(String prefix)���Դ��ַ����Ƿ���ָ����ǰ׺��ʼ
		 * 
		 * startsWith(String prefix,int toffset)���Դ��ַ����Ƿ���ָ��ǰ׺��ʼ����ǰ׺��ָ��������ʼ
		 */
		if (s.startsWith("Th"))
			System.out.println("s starts with 'Th'.");
		else
			System.out.println("s not starts with 'Th'.");
		if (s.startsWith("hi", 1))
			System.out.println("s starts with 'hi' at index = 1.");
		else
			System.out.println("s not starts with 'hi' at index = 1.");
		if (s.endsWith("ing"))
			System.out.println("s ends with 'ing'.");
		else
			System.out.println("s not ends with 'ing'.");
		// substring(int beginIndex)������λ�÷���һ���µ��ַ��������Ǵ��ַ�����һ�����ַ�����
		System.out.println("Sub string after 3 of s : " + s.substring(3));
		// toCharArray()�����ַ���ת��Ϊһ���µ��ַ�����
		char[] c = s.toCharArray();
		System.out.print("s to char array : ");
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.println();
		/*
		 * toLowerCase()ʹ��Ĭ�����Ի����Ĺ��򽫴�String�е������ַ���ת��ΪСд
		 * 
		 * toUpperCase()ʹ��Ĭ�����Ի����Ĺ��򽫴�String�е������ַ���ת��Ϊ��д
		 */
		System.out.println("s.toLowerCase() : " + s.toLowerCase());
		System.out.println("s.toUpperCase() : " + s.toUpperCase());
		// split(String regex)���ݸ�����������ʽ��ƥ������ִ��ַ���
		String[] sArray = s.split(" ");
		System.out.print("After s.split(\" \") s :");
		for (int i = 0; i < sArray.length; i++) {
			System.out.print(sArray[i]);
		}
		System.out.println();
		/*
		 * intern()��������һ���ַ�������������ø÷������ַ�����ͬ��������֤�����ַ�������
		 * 
		 * String����һ����ʼʱΪ�յ��ַ����أ�������String˽�е�ά��
		 * ������intern����ʱ��������Ѿ�����һ�����ڴ�String������ַ���(�ö�����equals(Object)����ȷ��)
		 * �򷵻س��е��ַ��������򣬽��� String ������ӵ����У����ҷ��ش� String ��������� 
		 * ����ѭ�����κ������ַ���s��t�����ҽ���s.equals(t)Ϊtrueʱ��s.intern() == t.intern()��Ϊtrue
		 */
		s = "test intern";
		String s1 = "test intern".intern();
		String result = s == s1 ? "" : " not";
		System.out.println("s and s1 " + result + "have the same string object");
		// trim()ʹ���ַ���ɾ����ǰ�����Ŀո�
		s = "  I see it  ";
		System.out.println("s.trim() : " + s.trim());
	}
}