/**
 * 
 */
package inner.nonstatic;

import inner.IContents;
import inner.IDestination;

/**
 * 内部类概览 
 * <p>
 * 内部类对象是和创建它的外部类对象关联的（即保存了对外部类对象的引用），
 * 并且只可以和一个外部类对象关联，但是一个外部类对象可以和很多内部类对象关联（创建很多内部类对象）。
 * 内部类可以访问外部类的任意成员(包括私有的)。外部类也可以通过一个内部类的对象来访问内部类成员(包括私有的)。
 * 内部类中还可以有它自己的内部类，但是不赞成这样的用法。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-2
 */
public class Goods {
	
	private int valueRate = 2;// 价值系数

	/**
	 * 内部类Contents
	 */
	private class Content implements IContents {
		/*
		 * Java编译器在创建内部类对象时隐式的把其外部类对象的引用也传了进去并一直保存着 ，
		 * 这样就使得内部类对象始终可以访问其外部类对象，这也是为什么在外部类作用范围之外要创建内部类对象必须先创建其外部类对象的原因。
		 * 
		 * Java里用如下格式表达外部类的引用：outerClass.this
		 */
		private int i = 10 * valueRate;

		public int value() {
			return i;
		}
	}

	/**
	 * 内部类GDestination
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
		 * 直接用 IContents c 和 IDestination d 进行操作，甚至连这两个内部类的名字都没有看见。
		 * 内部类的第一个好处:隐藏不想让别人知道的操作，也即封装性
		 */
		@SuppressWarnings("unused")
		IContents c = g1.cont();
		@SuppressWarnings("unused")
		IDestination d = g1.to("Beijing");
		g1.ship("Beijing");
		/*
		 * 如果想从外部类的任意位置创建某个内部类的对象 
		 * 1，利用其外部类的方法创建并返回，如上面的做法
		 * 2，必须这么调用： 
		 * OuterClass outerObject= new OuterClass(Constructor Parameters);
		 * OuterClass.InnerClass innerObject= OuterObject.new InnerClass(Constructor Parameters);
		 */
		Goods g2 = new Goods();
		Goods.GDestination gd = g2.new GDestination("Shanghai");
		System.out.println(gd.readLabel());
	}
}