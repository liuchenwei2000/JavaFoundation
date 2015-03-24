/**
 * 
 */
package object.readonly;

/**
 * 不可变对象演示类2
 * <p>
 * 含有一个可以被修改的伴随类，以便于提高效率。
 * <p>
 * 当下列情况发生时，此方法十分有用：</br>
 * <li>1.需要不可变的对象，而且
 * <li>2.经常需要做大量的修改，或者
 * <li>3.创建新的不可变对象代价昂贵。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-6-8
 */
public class ImmutableObjectDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImmutableObject2 aio = new ImmutableObject2(47);
		ImmutableObject2 aio1 = modify1(aio);
		ImmutableObject2 aio2 = modify2(aio);
		System.out.println("aio = " + aio.read());
		System.out.println("aio1 = " + aio1.read());
		System.out.println("aio2 = " + aio2.read());
	}
	
	/**
	 * 在多次循环中使用ImmutableObject2进行操作，会产生大量的垃圾对象，使得垃圾回收压力过大。
	 */
	public static ImmutableObject2 modify1(ImmutableObject2 o) {
		ImmutableObject2 aio = o.add(12);
		aio = aio.multiply(3);
		aio = aio.add(11);
		aio = aio.multiply(2);
		return aio;
	}

	/**
	 * 在多次循环中使用Mutable进行操作就不会有以上的问题，因为进行操作的始终都是一个对象Mutable。
	 */
	public static ImmutableObject2 modify2(ImmutableObject2 o) {
		Mutable m = o.makeMutable();
		m.add(12).multiply(3).add(11).multiply(2);
		return m.makeAdvancedImmutableObject();
	}
}

/**
 * 不可变对象 
 */
class ImmutableObject2 {
	
	private int value;

	public ImmutableObject2(int value) {
		this.value = value;
	}

	public int read() {
		return value;
	}

	public boolean nonzero() {
		return value != 0;
	}

	public ImmutableObject2 add(int x) {
		return new ImmutableObject2(value + x);
	}

	public ImmutableObject2 multiply(int x) {
		return new ImmutableObject2(value * x);
	}

	public Mutable makeMutable() {
		return new Mutable(value);
	}
}

/**
 * 不可变对象ImmutableObject2的可变伴随类
 * <p>
 * 无论何时当需要一个被修改过的不可变类对象的时候，必须要承受创建新对象的开销，也会更频繁地引发垃圾回收。
 * 对某些类而言，这不成问题，但对另一些类(例如String类)，其代价可能昂贵得让人不得不禁止这么做。
 * 解决之道是创建一个可以被修改的伴随类(companion class)。
 * 当你需要做大量修改动作时，可以转为使用可修改的伴随类，修改操作完毕后，再转回恒常类。
 */
class Mutable {

	private int value;

	public Mutable(int value) {
		this.value = value;
	}

	public Mutable add(int x) {
		value += x;
		return this;
	}

	public Mutable multiply(int x) {
		value *= x;
		return this;
	}

	public ImmutableObject2 makeAdvancedImmutableObject() {
		return new ImmutableObject2(value);
	}
}