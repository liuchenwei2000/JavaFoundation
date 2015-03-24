/**
 * 
 */
package initialize;

/**
 * ����غͳ�ʼ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-8
 */
public class LoadAndInit {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Derived constructor");
		/**
		 * ���и���ʱ�����ȷ������ǵ����˸����main����(����static��)��
		 * ���Ǽ�������ʼ�������ҳ�LoadAndInit��ı������(LoadAndInit.class)��
		 * �ڼ��صĹ����У�������ע�⵽����һ�����ࡣ������������������࣬�����Ƿ�������һ���û���Ķ����ⶼ�ᷢ����
		 * ����û��໹��������Ļ��࣬��ô�ڶ�������ͻᱻ���أ��Դ����ơ�
		 * ���������������static��ʼ���ͻ�ִ�У�Ȼ������һ�����࣬�Դ����ơ�
		 * ���ַ�ʽ����Ҫ����Ϊ�����static��ʼ�����ܻ������ڻ����Ա�ܷ���ȷ��ʼ����
		 * ����Ϊֹ����Ҫ���඼�Ѽ�����ϣ�����Ϳ��Ա������ˡ�
		 * 
		 * ���ȶ����е����л������Ͷ��ᱻ��ΪĬ��ֵ������������Ϊnull��
		 * Ȼ�����Ĺ������ᱻ���ã��ڻ��๹�������֮��ʵ������������򱻳�ʼ����
		 * Ȼ�󣬹����������ಿ�ֱ�ִ�У��������Ĺ����������á�
		 */
		new Derived();
	}
}

class Super {
	
	private int i = 9;
	protected int j;

	Super() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	public static int x1 = printInt("static Super.x1 initialized");

	static int printInt(String s) {
		System.out.println(s);
		return 47;
	}
}

class Derived extends Super {

	private int k = printInt("Derived.k initialized");

	Derived() {
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}

	public static int x2 = printInt("static Derived.x2 initialized");
}