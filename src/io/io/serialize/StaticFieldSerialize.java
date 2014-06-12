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
 * static�ֶε����л�
 * <p>
 * ������ĳ������ʱֻ��ִ�� ���л����߷����л�������е�һ����
 * δ��ִ�е�Ҫע�͵�������������е�Ч���������⡣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-27
 */
public class StaticFieldSerialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String fileName = "files/io.serialize/shape.out";
		/*
		 * ���л������
		 * 
		 * ��������
		 * [class io.serialize.Circle(color=3)
		 * , class io.serialize.Square(color=3)
		 * , class io.serialize.Line(color=3)
		 * ]
		 * �ɼ�ÿ�������color�ֶε�ֵ����3
		 */
		// �洢Shape�������Class������ΪClass��ʵ����Serializable
		List<Class<?>> shapeTypes = new ArrayList<Class<?>>();
		// ��ÿ����Class����ķ��ʻᴥ�����ڵ�static�ֶγ�ʼ��
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		// �洢Shape����
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle());
		shapes.add(new Square());
		shapes.add(new Line());
		// ��ÿ������� static �ֶ� color ����Ϊ Shape.GREEN
		for (Shape shape : shapes) {
			shape.setColor(Shape.GREEN);
		}
		System.out.println(shapes);
		// ���л�List
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				fileName));
		oos.writeObject(shapeTypes);
		Line.serializeStatic(oos);
		oos.writeObject(shapes);
		oos.close();
		/*
		 * �����л������
		 * 
		 * ��������
		 * [class io.serialize.Circle(color=1)
		 * , class io.serialize.Square(color=0)
		 * , class io.serialize.Line(color=3)
		 * ]
		 * �ɼ�Circle��Square��color�ֶε�ֵ������3
		 * 
		 * ��static�ֶ���Ϣ�Ķ�ȡ���������⣬Ԥ�����ж��ص���ɫ��Ӧ��3
		 * ������ʵ���ȴ������ˣ�
		 * Circle��ֵΪ 1(����ΪRED)����Square��ֵΪ0(����color�ֶ����ڹ������б���ʼ����)
		 * ����ȥ�ƺ�static�ֶθ���û�б����л���ʵ����ȷʵ���
		 * 
		 * ���Լ��������л�static�ֶ�ֵ���ͱ����ֹ�ȥʵ��
		 * ������Line�е�serializeStatic()��deserializeStatic()����static��������;
		 * ���Կ�������������Ϊ�洢�Ͷ�ȡ���̵�һ���ֱ���ʽ�ص��õ�
		 */
		// �����л�List
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				fileName));
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
	// �౻����ʱ�ͻ��ʼ��color�ֶ�
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
		// ���󱻴���ʱ�Ż�������ʼ��color�ֶΣ�����ΪĬ��ֵ0
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
	 * ���л�static�ֶ�ֵ�ľ��巽��
	 */
	public static void serializeStatic(ObjectOutputStream os)
			throws IOException {
		os.writeInt(color);
	}

	/**
	 * �����л�static�ֶ�ֵ�ľ��巽��
	 */
	public static void deserializeStatic(ObjectInputStream os)
			throws IOException {
		color = os.readInt();
	}
}