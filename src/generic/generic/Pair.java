/**
 * 
 */
package generic;

/**
 * ��������Ǿ���һ���������ͱ�������
 * <p>
 * Pair��������һ�����ͱ���T���ü�����(<>)���𣬲����������ĺ��档
 * <p>
 * ����������ж�����ͱ�����
 * ���磬���Զ���Pair�࣬���е�һ����͵ڶ�����ʹ�ò�ͬ�����ͣ�</br>
 * public class Pair<T,U>{...}
 * <p>
 * ���ͱ���ʹ�ô�д��ʽ���ұȽ϶̣����Ǻܳ����ġ�����Java�淶��</br>
 * <li>һ��ʹ�ñ���E��ʾ���ϵ�Ԫ������
 * <li>K��V�ֱ��ʾ��Ĺؼ�����ֵ������
 * <li>T(��Ҫʱ������ʹ��U��S)��ʾ��������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-8-3
 */
public class Pair<T> {

	// �ඨ���е����ͱ���ָ�������ķ��������Լ��ֶκ;ֲ�����������
	private T first;// ʹ�������ͱ���T
	private T second;

	public Pair() {
	}

	/**
	 * ʹ�������ͱ���T
	 */
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
	
	public String toString() {
		return "first=" + first.toString() + "  second=" + second.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] ss = { "this", "Hello", "is", "world", "Java" };
		Pair<String> minmax = minmax(ss);
		System.out.println("min=" + minmax.getFirst());
		System.out.println("max=" + minmax.getSecond());
	}
	
	private static Pair<String> minmax(String[] array){
		if(array == null || array.length == 0) return null;
		String min = array[0];
		String max = array[0];
		for (String s : array) {
			if (s.compareTo(min) < 0)
				min = s;
			if (s.compareTo(max) > 0)
				max = s;
		}
		/*
		 * �þ���������滻���ͱ����Ϳ���ʵ������������
		 * ���磺Pair<String>
		 * ���仰˵��������ɿ�����ͨ��Ĺ�����
		 */
		return new Pair<String>(min,max);
	}
}