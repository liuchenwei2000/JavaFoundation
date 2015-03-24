/**
 * 
 */
package inner;

/**
 * �ڲ�����ʾ1
 * <p>
 * ��;1���ڲ�����һ���������غ���֯�����ģʽ��
 * <p>
 * ���͵�����ǣ��ⲿ����һ���������÷�������һ��ָ���ڲ�������á�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-13
 */
public class InnerClass1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Goods goods1 = new Goods();
		goods1.ship("China");
		Goods goods2 = new Goods();
		// ������ڲ��������
		// ��������ⲿ��ķ�static����֮��ĵط������ڲ�����󣬾ͱ�������ָ�������������ͣ�OutClass.InnerClass
		@SuppressWarnings("unused")
		Goods.Contents c = goods2.getContents();
		@SuppressWarnings("unused")
		Goods.Destination d = goods2.to("Home");
	}
}

class Goods {
	
	class Contents {
		
		private int i = 11;

		public int getValue() {
			return i;
		}
	}

	class Destination {
		
		private String label;

		Destination(String toWhere) {
			label = toWhere;
		}

		String readLabel() {
			return label;
		}
	}

	public Contents getContents() {
		return new Contents();
	}

	public Destination to(String where) {
		return new Destination(where);
	}

	public void ship(String dest) {
		@SuppressWarnings("unused")
		Contents c = getContents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}
}