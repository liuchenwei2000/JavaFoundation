/**
 * 
 */
package primitive;

/**
 * ��������ʾ��
 * <p>
 * ��������������Java���Ե��������ͣ����ǲ��������ഴ���Ķ���
 * ������(literal)��һ����ֵ��Դ���﷽ʽ�������ڴ�����ֱ�ӱ�ʾ������Ҫ���㡣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-8-14
 */
public class LiteralDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����� true��c��1����������
		boolean b = true;
		System.out.println(b);
		char c = 'c';
		System.out.println(c);
		int i = 1;
		System.out.println(i);
		// ��������(byte, short, int, long)������ʮ���ơ��˽��ơ�ʮ�����Ƶ���������ʾ
		// �������е�ǰ׺"0"��ʾ���ǰ˽��ƣ�"0x"��ʾ����ʮ������
		int dec = 26; // ʮ���Ʊ�ʾ 26
		System.out.println(dec);
		int oct = 032; // �˽��Ʊ�ʾ 26
		System.out.println(oct);
		int hex = 0x1a; // ʮ�����Ʊ�ʾ 26
		System.out.println(hex);
		// ����������(float, double)����ʹ��E����e(��ѧ������)��
		double d1 = 123.4;
		System.out.println(d1);
		double d2 = 1.234e2;// ��ѧ��������ʾ123.4
		System.out.println(d2);
		// F����f��׺��ʾ32λ������������(��������float����)��
		float f1 = 123.4f;
		System.out.println(f1);
		// D����d��׺��ʾ64λ������������(��������double���ͣ�Java��Ĭ��ʡ��)
		double d3 = 123.4D;
		System.out.println(d3);
		/*
		 * char���ͺ�String���͵����������԰���Unicode(UTF-16)�ַ�
		 * ����༭�����ļ�ϵͳ������ô�����ǾͿ����ڴ�����ֱ��ʹ����Щ�ַ�
		 * ���򣬾ͱ���ʹ��Unicodeת��(Unicode escape����'��б��u'ǰ׺��ʶ)
		 * ����'\u0144'(����Сдn)������"S\u0144 se\u0144"
		 * char����������ʹ�õ�����('')��������String����������ʹ��˫����("")������ 
		 * Unicodeת�����п����ڳ����е��κεط�ʹ�ã�����������ȵȣ���������char��String��������
		 */
		char ch = '\u0144';
		System.out.println(ch);
		String s = "S\u0144 se\u0144";
		System.out.println(s);
	}
}