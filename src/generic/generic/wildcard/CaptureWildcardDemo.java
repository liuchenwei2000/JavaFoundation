/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * ͨ���������ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-8-3
 */
public class CaptureWildcardDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pair<?> pair = new Pair<String>("head", "tail");
		System.out.println(pair.toString());
		swap(pair);
		System.out.println(pair.toString());
		Pair<Father> pair2 = new Pair<Father>(new Father("f1"), new Father("f2"));
		System.out.println(pair2.toString());
		swapMustCapture(pair2);
		System.out.println(pair2.toString());
	}

	/**
	 * ����Pair������Ԫ�صķ���
	 */
	private static void swap(Pair<?> pair) {
		// ����������б����
		// ͨ����������ͱ�������˲����ڴ�����ʹ��"?"��Ϊһ������
//		? t = pair.getFirst();
		// ��ʹʹ��ObjectҲ�����ԣ���ΪsetFirst�����ã����£�
//		Object t = pair.getFirst();
//		pair.setFirst(pair.getSecond());
//		pair.setSecond(t);
		// ��Ϊ�ڽ���ʱ������һ��������ʱ����һ��Ԫ��
		// ���ҵ������������һ����Ȥ�Ľ��������ʹ��һ�����͸�������
		swapHelper(pair);
	}
	
	/**
	 * swapHelper��һ�����ͷ�������swap���ǣ������й̶���Pair<?>���͵Ĳ�����
	 * ���� T �ܹ�����(capture)ͨ���������֪�����������͵�ͨ��������ǿ϶���һ����ȷ�����͡�
	 * ����<T>swapHelper�Ķ���ֻ����Tָ������ʱ��������ȷ�ĺ��塣
	 */
	private static <T> void swapHelper(Pair<T> pair) {
		T t = pair.getFirst();
		pair.setFirst(pair.getSecond());
		pair.setSecond(t);
	}
	
	/**
	 * ��Ȼ�������������ֱ��ʹ��swapHelper��Ϊ�����ӿھͿ��ԣ�
	 * ����ͨ����������������ʽ����ʱ����������ǲ��ɱ���ġ�
	 */
	private static void swapMustCapture(Pair<? super Son> pair){
		// ����������б����
//		Object object = pair.getSecond();// ����Object���Ͷ���
//		pair.setFirst(object);// �÷����Ĳ�����Son���Ͷ���
		swapHelper(pair);
	}
}