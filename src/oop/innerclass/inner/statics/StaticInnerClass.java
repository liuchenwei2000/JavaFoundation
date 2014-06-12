/**
 * 
 */
package inner.statics;

import inner.IContents;
import inner.IDestination;

/**
 * ��̬�ڲ�����ʾ
 * <p>
 * �������Ҫ�ڲ���������ⲿ�����֮������ϵ�����Խ��ڲ�������Ϊstatic��ͨ����ΪǶ���ࡣ
 * ��ͨ���ڲ��������ʽ�ı�����һ�����ô��������ⲿ����󣬵��ڲ�����static��ʱ����û����������ˣ�
 * </br>����ζ�ţ�</br>
 * <li>1��Ҫ����Ƕ����Ķ��󲢲���Ҫ���ⲿ��Ķ���
 * <li>2�����ܴ�Ƕ����Ķ����з��ʷǾ�̬���ⲿ�����</br>
 * ���⣬��ͨ���ڲ��಻����static���ݺ�static�ֶΣ�Ҳ���ܰ���Ƕ���࣬����Ƕ������԰�����Щ������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-14
 */
public class StaticInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		IContents c = NewGoods2.getContents();
		@SuppressWarnings("unused")
		IDestination d = NewGoods2.getDestination("China");
	}
}

class NewGoods2 {

	private static class Contents implements IContents {

		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected static class GDestination implements IDestination {
		
		private String label;

		private GDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}

		static int x = 2;

		static class AnotherLevel {
			static int x = 1;

			public static void f() {
			}
		}
	}

	public static IContents getContents() {
		return new Contents();
	}

	public static IDestination getDestination(String s) {
		return new GDestination(s);
	}
}