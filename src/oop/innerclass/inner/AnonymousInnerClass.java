/**
 * 
 */
package inner;

/**
 * 匿名内部类演示
 * <p>
 * 匿名内部类与正常的继承相比有些受限：</br>
 * 因为匿名内部类既可以扩展类，也可以实现接口，但是不能两者兼备，如果实现接口只能实现一个。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-14
 */
public class AnonymousInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnonymousInnerClass aicd = new AnonymousInnerClass();
		System.out.println(aicd.getSong().getSongName());
		aicd.getGame("basketball").play();
		getBase(47).f();
	}
	
	public Song getSong(){
		/*
		 * 该类是匿名的，它没有名字，这看起来似乎是正要创建一个Game对象。
		 * 但是在到达语句结束的分号之前却有：等一等，要在这里插入一个类的定义。
		 * 它是指：创建一个继承自Game的匿名类的对象。
		 */
		return new Song(){
			@Override
			public String getSongName() {
				return "国歌";
			}
		};
	}
	
	public Game getGame(final String name) {
		/*
		 * 当继承的父类的构造器需要参数时，必须要传递合适的参数给基类的构造器。
		 * 如果匿名内部类使用了一个在其外部定义的对象，那么编译器要求其参数引用是final的。
		 */
		return new Game(name) {
			public void play() {
				System.out.println("paly " + name + " inside");
			}
		};
	}
	
	public static Base getBase(int i) {
		/*
		 * 因为在匿名内部类中没有命名构造器，如果想做一些类似构造器的行为可以通过 实例初始化：
		 * (不要求i一定是final的，因为i是被传递给匿名类的基类的构造器并不会在匿名类内部被直接使用)
		 */
		return new Base(i) {
			{
				// 实例初始化的效果就是构造器，但是不能重载实例初始化方法。
				System.out.println("Inside instance initializer");
			}

			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}
}

class Song {

	public String getSongName() {
		return "song";
	}
}

class Game {

	private String name;

	public Game(String name) {
		this.name = name;
	}

	public void play() {
		System.out.println("paly " + name + " outside");
	}
}

abstract class Base {
	
	public Base(int i) {
		System.out.println("Base constructor.i = " + i);
	}

	public abstract void f();
}
