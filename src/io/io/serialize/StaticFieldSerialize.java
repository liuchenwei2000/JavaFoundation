/**
 * 
 */
package io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * static字段的序列化
 * <p>
 * 本例在某次运行时只能执行 序列化或者反序列化代码段中的一个，未被执行的要注释掉，否则程序运行的效果会有问题。
 * <p>
 * 结论：static字段不会被自动序列化，除非手动的调用方法将其序列化和反序列化。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-27
 */
public class StaticFieldSerialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize/shape.out";
		/*
		 * 序列化代码段
		 * 
		 * 输出结果：
		 * [class io.serialize.Circle(color=3)
		 * , class io.serialize.Square(color=3)
		 * , class io.serialize.Line(color=3)
		 * ]
		 * 可见每个对象的color字段的值都是3
		 */
		// 存储Shape所属类的Class对象，因为Class类实现了Serializable
		List<Class<?>> shapeTypes = new ArrayList<Class<?>>();
		// 对每个类Class对象的访问会触发类内的static字段初始化
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		
		// 存储Shape对象
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle());
		shapes.add(new Square());
		shapes.add(new Line());
		
		// 将每个对象的 static 字段 color 都设为 Shape.GREEN
		for (Shape shape : shapes) {
			shape.setColor(Shape.GREEN);
		}
		System.out.println(shapes);
		
		// 序列化List
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				fileName));
		oos.writeObject(shapeTypes);
		Line.serializeStatic(oos);
		oos.writeObject(shapes);
		oos.close();
		
		/*
		 * 反序列化代码段
		 * 
		 * 输出结果：
		 * [class io.serialize.Circle(color=1)
		 * , class io.serialize.Square(color=0)
		 * , class io.serialize.Line(color=3)
		 * ]
		 * 可见Circle和Square的color字段的值都不是3
		 * 
		 * 对static字段信息的读取出现了问题，预期所有读回的颜色都应是3，但是真实情况却并非如此：
		 * Circle的值为 1(定义为RED)，而Square的值为0(它的color字段是在构造器中被初始化的)
		 * 看上去似乎static字段根本没有被序列化，实际上确实如此。
		 * 
		 * 所以假如想序列化static字段值，就必须手工去实现。
		 * 这正是Line中的serializeStatic()和deserializeStatic()两个static方法的用途。
		 * 可以看到，它们是作为存储和读取过程的一部分被显式地调用的。
		 */
		
		// 反序列化List
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		ois.readObject();
		Line.deserializeStatic(ois);
		List<?> shapes2 = (List<?>) ois.readObject();
		ois.close();
		System.out.println(shapes2);
	}
}

abstract class Shape implements Serializable {

	private static final long serialVersionUID = -3135316982987558523L;
	
	public static final int RED = 1;
	public static final int BLUE = 2;
	public static final int GREEN = 3;

	public abstract void setColor(int color);

	public abstract int getColor();

	public String toString() {
		return getClass() + "(color=" + getColor() + ")\n";
	}
}

class Circle extends Shape {

	private static final long serialVersionUID = -3866854209268897193L;
	// 类被加载时就会初始化color字段
	private static int color = RED;

	public Circle() {
		// do nothing
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

class Square extends Shape {
	
	private static final long serialVersionUID = -3866854209268897193L;
	
	private static int color;

	public Square() {
		// 对象被创建时才会真正初始化color字段，否则为默认值0
		color = RED;
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

class Line extends Shape {
	
	private static final long serialVersionUID = -3866854209268897193L;
	
	private static int color = RED;

	public Line() {
		// do nothing
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
	
	/**
	 * 序列化static字段值的具体方法
	 */
	public static void serializeStatic(ObjectOutputStream os)
			throws IOException {
		os.writeInt(color);
	}

	/**
	 * 反序列化static字段值的具体方法
	 */
	public static void deserializeStatic(ObjectInputStream os)
			throws IOException {
		color = os.readInt();
	}
}
