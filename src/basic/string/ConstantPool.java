/**
 * 
 */
package string;

/**
 * ������
 * <p>
 * ָ�����ڱ����ڱ�ȷ���������������ѱ����.class�ļ��е�һЩ���ݣ�
 * �������˹����ࡢ�������ӿڵ��еĳ�����Ҳ�����ַ���������
 * <p>
 * String��һ�������װ�࣬�������Ǵ����ջ��ģ����������ݱ�����ݴ�����ʽ��ͬ����(�����غͶ�)��
 * �е��Ǳ����ھ��Ѿ������ã�������ַ����������У����е�������ʱ�ű�������ʹ��new�ؼ��֣�����ڶ��С�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-2
 */
public class ConstantPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * String����������������ʽ��������
		 * ��һ����ʽ����new()���½�����ģ����ᱻ����ڶ��У�ÿ����һ�ξͻᴴ��һ���µĶ��� 
		 * �ڶ�����ʽ������ջ�д���һ����String���������ñ�����Ȼ��ȥ�ַ���������������û��"abc"��
		 * ���û�У���"abc"��Ž��ַ��������أ�����str2ָ��"abc"������Ѿ���"abc"��ֱ����str2ָ��"abc"��
		 */
		String str1 = new String("abc");
		String str2 = "abc";
		/*
		 * �������ַ�ʽ����2��"abc"�ַ��������ڴ�����ʵֻ����һ��������ѣ�����д�������ڽ�ʡ�ڴ�ռ䡣 
		 * ͬʱ��������һ���̶�����߳���������ٶȣ���ΪJVM���Զ�����ջ�����ݵ�ʵ������������Ƿ��б�Ҫ�����¶���
		 * �������ַ�ʽ�����ܱ�֤һ���ᴴ������Ҳ����ֻ��ָ��һ����ǰ�Ѿ������Ķ���
		 */
		str1 = "abc";
		str2 = "abc";
		System.out.println(str1 == str2);// true
		/*
		 * �������ַ�ʽ��һ���ڶ��д����¶��󣬶������ַ���ֵ�Ƿ���ȣ��Ƿ��б�Ҫ�����¶��󣬴Ӷ������˳���ĸ�����
		 */
		str1 = new String("abc");
		str2 = new String("abc");
		System.out.println(str1 == str2);// false
		/*
		 * JVM�����ַ���������"+"�����ӣ��ڱ������ͽ������ַ�����"+"�Ż�Ϊ���Ӻ��ֵ��
		 * �������������"a" + 1�����������Ż�����class�ļ��о��Ѿ���a1��
		 */
		String a = "a1";
		String b = "a" + 1;
		System.out.println(a == b);// true

		a = "atrue";
		b = "a" + true;
		System.out.println(a == b);// true

		a = "a3.4";
		b = "a" + 3.4;
		System.out.println(a == b);// true

		a = "ab";
		b = "a" + "b";
		System.out.println(a == b);// true
		/*
		 * �������ַ�����"+"�����У����ַ������ô��ڣ������õ�ֵ�ڳ�����������޷�ȷ���ģ�
		 * ��"a" + bb �޷����������Ż���ֻ���ڳ�������������̬���䲢�����Ӻ���µ�ַ����b�� 
		 */
		String bb = "b";
		a = "ab";
		b = "a" + bb;
		System.out.println(a == b);// false
		/*
		 * ��������ͬ���Ǳ���bbb����final���Σ�����final���εı�����
		 * ���ڱ���ʱ������Ϊ����ֵ��һ�����ؿ����洢���Լ��ĳ������У�
		 * ���Դ�ʱ��"a" + bbb��"a" + "b"Ч����һ���ġ�
		 */
		final String bbb = "b";
		a = "ab";
		b = "a" + bbb;
		System.out.println(a == b);// true
		/*
		 * JVM�����ַ�������bb������ֵ�ڱ������޷�ȷ����
		 * ֻ��������ʱ���÷����󣬽������ķ���ֵ��"a"����̬���Ӳ������ַ��b��
		 */
		final String bbbb = getBBBB();
		a = "ab";
		b = "a" + bbbb;
		System.out.println(a == b);// false
		/*
		 * �����s1/s2������д���ǵȼ۵� 
		 */
		String s1 = "a" + "b" + "c";
		String s2 = "abc";
		/*
		 * �����s1/s2������д���ǵȼ۵�
		 */
		String sa = "a";
		String sb = "b";
		String sc = "c";
		s1 = sa + sb + sc;// ������ʾ�������������StringBuffer����
		s2 = new StringBuffer().append(sa).append(sb).append(sc).toString();
		/*
		 * �ַ���ÿ��һ��"+"�ͻ������StringBuffer����Ȼ��append����ӵ���
		 * ���������������������������ʱStringBuffer����Ч�ʵ��¡�
		 * ��ѭ���У���Ӧ��ֱ��ʹ��StringBuffer��StringBuilder����append������
		 */
		@SuppressWarnings("unused")
		String s = "";
		for (int i = 0; i < 100; i++) {
			s += "a";
		}
		/*
		 * Java��ȷ��һ���ַ�������ֻ��һ������ ��
		 * 
		 * ��Ϊ�����е�s0��s1�е�"kvill"�����ַ��������������ڱ����ھͱ�ȷ���ˣ�����s0==s1Ϊtrue��
		 * ��"kv"��"ill"Ҳ�����ַ�����������һ���ַ����ɶ���ַ����������Ӷ���ʱ�����Լ��϶�Ҳ���ַ���������
		 * ����s2Ҳͬ���ڱ����ھͱ�����Ϊһ���ַ�������Ҳ�ǳ�������"kvill"��һ�����á� 
		 */
		String s0 = "kvill";
		s1 = "kvill";
		s2 = "kv" + "ill";
		System.out.println(s0 == s1);// true
		System.out.println(s0 == s2);// true
		
		/*
		 * ��new String()�������ַ������ǳ����������ڱ����ھ�ȷ����
		 * ����new String()�������ַ��������볣�����У��������Լ��ĵ�ַ�ռ䡣
		 */
		String s3 = "string";
		String s4 = new String("string");
		String s5 = "str" + new String("ing");
		System.out.println(s3 == s4);// false
		System.out.println(s3 == s5);// false
		System.out.println(s4 == s5);// false
		/*
		 * ������.class�ļ��еĳ����أ��������ڱ�JVMװ�أ����ҿ������䡣
		 * String��intern()�����������䳣���ص�һ��������
		 * ��һ��Stringʵ������intern()����ʱ��JVM���ҳ��������Ƿ�����ͬUnicode���ַ���������
		 * ������򷵻������ã����û�����ڳ�����������һ��Unicode���ڸ�ʵ�����ַ����������������á� 
		 */
		String str = "sss";
		String stra = new String("sss");
		String strb = new String("sss");
		System.out.println(str == stra);// false
		stra.intern();
		strb = strb.intern();// �ѳ�������"sss"�����ø���strb
		System.out.println(str == stra);// false
		System.out.println(str == stra.intern());// true
		System.out.println(str == strb);// true
	}
	
	private static String getBBBB(){
		return "b";
	}
}