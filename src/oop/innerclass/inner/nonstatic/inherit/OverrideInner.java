/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * �ڲ���ĸ�����ʾ
 * <p>
 * ����һ���ڲ��࣬Ȼ��̳����ⲿ�ಢ���¶�����ڲ���ʱ��
 * �����ڲ��ಢ���񸲸��ⲿ�෽�����������������õġ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-18
 */
public class OverrideInner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BigEgg();
	}
}

class Egg {
	
	@SuppressWarnings("unused")
	private Yolk yolk;

	protected class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}

	public Egg() {
		System.out.println("New Egg()");
		yolk = new Yolk();
	}
}

class BigEgg extends Egg {
	
	/**
	 * ���̳�ĳ���ⲿ���ʱ���ڲ��ಢû�з���ʲô�仯��
	 * �������ڲ�������ȫ����������ʵ�壬�������Լ��������ռ��ڡ�
	 */
	public class Yolk {
		
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}
}