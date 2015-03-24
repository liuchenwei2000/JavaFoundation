/**
 * 
 */
package inner.nonstatic;

import inner.IContents;
import inner.IDestination;

/**
 * �ڲ������ 
 * <p>
 * �ڲ�������Ǻʹ��������ⲿ���������ģ��������˶��ⲿ���������ã���
 * ����ֻ���Ժ�һ���ⲿ��������������һ���ⲿ�������Ժͺܶ��ڲ����������������ܶ��ڲ�����󣩡�
 * �ڲ�����Է����ⲿ��������Ա(����˽�е�)���ⲿ��Ҳ����ͨ��һ���ڲ���Ķ����������ڲ����Ա(����˽�е�)��
 * �ڲ����л����������Լ����ڲ��࣬���ǲ��޳��������÷���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-2
 */
public class Goods {
	
	private int valueRate = 2;// ��ֵϵ��

	/**
	 * �ڲ���Contents
	 */
	private class Content implements IContents {
		/*
		 * Java�������ڴ����ڲ������ʱ��ʽ�İ����ⲿ����������Ҳ���˽�ȥ��һֱ������ ��
		 * ������ʹ���ڲ������ʼ�տ��Է������ⲿ�������Ҳ��Ϊʲô���ⲿ�����÷�Χ֮��Ҫ�����ڲ����������ȴ������ⲿ������ԭ��
		 * 
		 * Java�������¸�ʽ����ⲿ������ã�outerClass.this
		 */
		private int i = 10 * valueRate;

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

	public IDestination to(String s) {
		return new GDestination(s);
	}

	public IContents cont() {
		return new Content();
	}

	public void ship(String dest) {
		IDestination d = to(dest);
		System.out.println(d.readLabel());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Goods g1 = new Goods();
		/*
		 * ֱ���� IContents c �� IDestination d ���в������������������ڲ�������ֶ�û�п�����
		 * �ڲ���ĵ�һ���ô�:���ز����ñ���֪���Ĳ�����Ҳ����װ��
		 */
		@SuppressWarnings("unused")
		IContents c = g1.cont();
		@SuppressWarnings("unused")
		IDestination d = g1.to("Beijing");
		g1.ship("Beijing");
		/*
		 * �������ⲿ�������λ�ô���ĳ���ڲ���Ķ��� 
		 * 1���������ⲿ��ķ������������أ������������
		 * 2��������ô���ã� 
		 * OuterClass outerObject= new OuterClass(Constructor Parameters);
		 * OuterClass.InnerClass innerObject= OuterObject.new InnerClass(Constructor Parameters);
		 */
		Goods g2 = new Goods();
		Goods.GDestination gd = g2.new GDestination("Shanghai");
		System.out.println(gd.readLabel());
	}
}