/**
 * 
 */
package inner;

/**
 * �ڲ�����ʾ2
 * <p>
 * ��;2��</br>
 * ������һ���ڲ������ʱ���ö����봴��������Χ�����Ƕ�Ӧ�ġ�
 * ���ܹ�������Χ��������г�Ա��������Ҫ�κ�����������Ҳ�����ڲ���ӵ�����ⲿ�������Ԫ�صķ���Ȩ��
 * <p>
 * ʵ��ϸ�ڣ� </br>
 * ��ĳ����Χ��Ķ��󴴽���һ���ڲ������ʱ�����ڲ������ض������ܵصõ�һ��ָ����ⲿ���������ã�
 * Ȼ�󵱷����ⲿ��ĳ�Աʱ���������Ǹ�������ѡ���ⲿ���Ա��
 * �����ڲ���Ķ���ֻ���������ⲿ��Ķ��������������²��ܱ����������ڲ����Ƿ�static�ģ���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-13
 */
public class InnerClass2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer();
		Printable printer = outer.getPrinter();
		System.out.println(printer.getPrintMessage());
	}
}

interface Printable {
	
	public String getPrintMessage();
}

class Outer {
	
	private String message;

	public Outer() {
		message = "Outer";
	}

	public Printable getPrinter() {
		return new Inner();
	}

	class Inner implements Printable {

		public String getPrintMessage() {
			return "Inner.getPrintMessage() : " + message;
		}
	}
}