/**
 * 
 */
package io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象网细节演示
 * <p>
 * 如果将两个都具有指向第三个对象的引用的对象进行序列化，会发生什么情况？
 * 当从它们的序列化状态恢复这两个对象时，第三个对象会只出现一次吗？
 * 如果将这两个对象序列化成独立的文件，然后在代码的不同部分对它们进行反序列化，又会怎样？ 
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-27
 */
public class ObjectNetDemo {

	/**
	 * 可以通过本例的输出结果查看对象网效果
	 * 
	 * 我们期望这些被反序列化还原后的对象地址与原来的地址不同(否则可能会破坏内存)
	 * 但在 animals1 和 animals2 中却出现了相同的地址，包括二者共享的那个指向house的引用
	 * 另一方面，当恢复 animals3 时，系统无法知道另一个流内的对象是第一个流内对象的别名
	 * 因此它会产生出完全不同的对象网。只要将任何对象序列化到单一流中
	 * 就可以恢复出与写入时一样的对象网，并且没有任何意外重复复制出的对象
	 * 
	 * 如果想保存系统状态，最安全的作法是将其作为"原子"操作进行序列化
	 * 如果序列化了某些东西，再去做其他一些工作，再来序列化更多的东西
	 * 如此等等，那么将无法安全地保存系统状态
	 * 取而代之的是，将构成系统状态的所有对象都置入某个单一容器(如List)内
	 * 并在一个操作中将该容器直接写出；然后同样只需一次方法调用，即可以将其恢复
	 * 即只调用一次 writObject(Collection) 和 readObject()即可
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		// 这三个Animal对象共享了同一个house对象
		animals.add(new Animal("Dog", house));
		animals.add(new Animal("Cat", house));
		animals.add(new Animal("Bird", house));
		System.out.println("animals：\n" + animals);
		// 将这个List序列化到内存块1
		ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(buffer1);
		// List被写入了两次
		oos.writeObject(animals);
		oos.writeObject(animals); 
		oos.close();
		// 将这个List序列化到内存块2
		ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(buffer2);
		oos.writeObject(animals);
		oos.close();
		// 反序列化读回List
		ObjectInputStream ois1 = new ObjectInputStream(
				new ByteArrayInputStream(buffer1.toByteArray()));
		ObjectInputStream ois2 = new ObjectInputStream(
				new ByteArrayInputStream(buffer2.toByteArray()));
		// 读取内存块1的第一个对象
		List<?> animals1 = (List<?>) ois1.readObject();
		// 读取内存块1的第二个对象
		List<?> animals2 = (List<?>) ois1.readObject();
		// 读取内存块2的List对象
		List<?> animals3 = (List<?>) ois2.readObject();
		ois1.close();
		ois2.close();
		System.out.println("animals1：\n" + animals1);
		System.out.println("animals2：\n" + animals2);
		System.out.println("animals3：\n" + animals3);
	}

}

class House implements Serializable {

	private static final long serialVersionUID = 7111825389860589381L;
}

class Animal implements Serializable {

	private static final long serialVersionUID = 1944038041155987297L;

	private String name;
	private House house;

	Animal(String name, House house) {
		this.name = name;
		this.house = house;
	}

	public String toString() {
		return name + "(" + super.toString() + ") in " + house + "\n";
	}
}