/**
 * 
 */
package polymorphism;

/**
 * �������еĶ�̬������ʾ
 * <p>
 * �����һ�����������ڲ��������ڹ�������ĳ����̬�󶨷�������Ҫ�õ��Ǹ����������Ǻ�Ķ��塣
 * Ȼ��������õ�Ч�������൱����Ԥ�ϣ���Ϊ�����ǵķ����ڶ�����ȫ����֮ǰ�ͻᱻ���á�
 * <p>
 * ���κι������ڲ��������������ֻ�ǲ����γɣ�ֻ��֪���ö����Ѿ���ʼ���г�ʼ����
 * ���������ֻ���ڹ����������е�һ�����裬���Ҹö����������������������������������࣬
 * ��ô�����ڵ�ǰ���������ڱ����õ�ʱ���Ծ���û�б���ʼ���ģ�Ȼ��һ����̬�󶨵ķ�������ȴ���������뵽�̳в�νṹ�ڲ���
 * �����Ե���������ķ���������ڹ������ڲ�����������ô�ͻ����ĳ����������������������ݵĳ�Ա���ܻ�û�н��г�ʼ����
 * <p>
 * ��ˣ���д��������һ��׼��
 * �þ����ܼ򵥵ķ����Ƕ����������״̬�����������������������
 * �ڹ��������ܹ���ȫ���õķ����ǻ����final����(����private������Ĭ����final��)��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-10
 */
public class PolyConstructor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Circle(5);
	}
}

class Shape {

	Shape() {
		System.out.println("Shape() before draw()");
		draw();
		System.out.println("Shape() after draw()");
	}

	void draw() {
		System.out.println("Shape.draw()");
	}
}

class Circle extends Shape {
	
	private int radius = 1;

	Circle(int r) {
		this.radius = r;
		System.out.println("Circle.Circle().radius = " + radius);
	}

	void draw() {
		System.out.println("Circle.draw().radius = " + radius);
	}
}