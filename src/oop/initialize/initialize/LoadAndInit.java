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
public class LoadAndInit extends Super{
	
	private int k = printInt("Beetle.k initialized");

	LoadAndInit() {
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}

	public static int x2 = printInt("static Beetle.x2 initialized");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Beetle constructor");
		/**
		 * ���и���ʱ�����ȷ������µ����˸����main����(����static��)��
		 * ���Ǽ�������ʼ�������ҳ�LoadAndInit��ı������(LoadAndInit.class)��
		 * �ڼ��صĹ����У�������ע�⵽����һ�����ࡣ
		 * ������������������࣬�����Ƿ�������һ���û���Ķ����ⶼ�ᷢ����
		 * ����û��໹��������Ļ��࣬��ô�ڶ�������ͻᱻ���أ��Դ����ơ�
		 * ���������������static��ʼ���ͻ�ִ�У�Ȼ������һ�����࣬�Դ����ơ�
		 * ���ַ�ʽ����Ҫ����Ϊ�����static��ʼ�����ܻ������ڻ����Ա�ܷ���ȷ��ʼ����
		 * ����Ϊֹ����Ҫ���඼�Ѽ�����ϣ�����Ϳ��Ա������ˡ�
		 * 
		 * ���ȶ����е����л������Ͷ��ᱻ��ΪĬ��ֵ������������Ϊnull��
		 * Ȼ�����Ĺ������ᱻ���ã��ڻ��๹�������֮��ʵ������������򱻳�ʼ����
		 * Ȼ�󣬹����������ಿ�ֱ�ִ�У��������Ĺ����������á�
		 */
		new LoadAndInit();
	}
}

class Super {
	
	private int i = 9;
	protected int j;

	Super() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	public static int x1 = printInt("static Insect.x1 initialized");

	static int printInt(String s) {
		System.out.println(s);
		return 47;
	}
}