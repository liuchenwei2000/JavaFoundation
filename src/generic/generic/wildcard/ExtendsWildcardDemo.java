/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * ͨ����������޶���ʾ��
 * <p>
 * ��������ȫ(����)���޸�������ȫ(������)��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-8-3
 */
public class ExtendsWildcardDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Father f1 = new Father("f1");
		Father f2 = new Father("f2");

		Son s1 = new Son("s1");
		Son s2 = new Son("s2");

		Pair<Father> p1 = new Pair<Father>(f1, f2);
		Pair<Son> p2 = new Pair<Son>(s1, s2);

		printFather(p1);
		// ����������б����
//		printFather(p2);
//		printSon(p1);
		printSon(p2);
		printAll(p1);
		printAll(p2);
		
		/* 
		 * ʹ��Pair<? extends Father>���ͽ������Ե���set����
		 * ������ֻ֪������Ҫĳ��Father�������ͣ����ǲ�֪��������ʲô����
		 * ���ܾ������κ��ض������ͣ���get�����ǰ�ȫ���õ�
		 */
		Pair<? extends Father> pair = p2;
		// ����������б����
//		pair.setFirst(s1);
		Father f3 = pair.getFirst();
		System.out.println(f3.getName());
	}

	/**
	 * ͨ�������Pair<? extends Father>��ʾ�κη���Pair���͡�
	 * �������Ͳ�����Father�����࣬��Pair<Son>��������Pair<String>��
	 * Pair<Father>��Pair<Son>����Pair<? extends Father>�������͡�
	 */
	private static void printAll(Pair<? extends Father> pair) {
		System.out.println("first=" + pair.getFirst().getName());
		System.out.println("second=" + pair.getSecond().getName());
		System.out.println();
	}
	
	/**
	 * �������ͰѲ������Ƶ�̫���ˣ�ֻ���Դ���Pair<Father>����Pair<Son>�Ͳ��С�
	 * ��ΪPair<Son>������Pair<Father>�����ࡣ
	 */
	private static void printFather(Pair<Father> pair) {
		System.out.println("first=" + pair.getFirst().getName());
		System.out.println("second=" + pair.getSecond().getName());
		System.out.println();
	}

	/**
	 * ͬ�Ϸ���
	 */
	private static void printSon(Pair<Son> pair) {
		System.out.println("first=" + pair.getFirst().getName());
		System.out.println("second=" + pair.getSecond().getName());
		System.out.println();
	}
}