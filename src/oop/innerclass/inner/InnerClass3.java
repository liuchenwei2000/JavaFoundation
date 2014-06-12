/**
 * 
 */
package inner;

/**
 * �ڲ�����ʾ3
 * <p>
 * ��;3��</br>
 * �����ڲ�������ת��Ϊ����࣬������һ���ӿڵ�ʱ���ڲ�������������;�ˡ�
 * ������Ϊ�ڲ���(ĳ���ӿڵ�ʵ��)�ܹ���ȫ���ɼ������Ҳ����ã�
 * ���õ���ֻ��ָ���������߽ӿڵ����ã������ܹ����������ʵ��ϸ�ڡ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-13
 */
public class InnerClass3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewGoods goods = new NewGoods();
		@SuppressWarnings("unused")
		IContents c = goods.getContents();
		@SuppressWarnings("unused")
		IDestination d = goods.getDestination("Beijing");
	}
}

class NewGoods {

	/**
	 * �ڲ���Contents
	 * <p>
	 * private�ڲ��������ȫ��ֹ�κ����������͵ı��룬������ȫ����ʵ��ϸ�ڡ�
	 * �ӿͻ��˳���Ա�ĽǶ����������ڲ��ܷ����κ������ӵ�ԭ�������ڹ����ӿڵķ�����������չ�ӿ���û�м�ֵ�ġ�
	 */
	private class Contents implements IContents {

		private int i = 11;

		public int value() {
			return i;
		}
	}

	/**
	 * �ڲ���GDestination
	 */
	protected class GDestination implements IDestination {
		
		private String label;

		private GDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}

	public IContents getContents() {
		return new Contents();
	}

	public IDestination getDestination(String s) {
		return new GDestination(s);
	}
}