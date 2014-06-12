/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * �ڲ���̳к�������ʾ
 * <p>
 * ���ڲ���ĳ�Ա���ⲿ��ĳ�Ա��ʶ��һ��ʱ�����ڲ�����ʹ��ʱ�ڲ���ĳ�Ա�������ⲿ���Ա��
 * <p>
 * <strong>�ڲ��������ⲿ���Ա�ᵼ�³����׶���Ӧ�����������</strong>
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-12
 */
public class InheritAndHiding {
	
	String name = "InheritAndHiding";
	int age = 0;

	class Son extends Father {
		// �ڲ���ĳ�Ա�����Լ��ĳ�Ա�ͼ̳����ĳ�Ա
		int age = 10;

		int getInnerAge() {
			return age;// Son�Լ���age(this.age)
		}

		String getInnerName() {
			return name;// Son�̳�����name(this.name)
		}
		
		int getOuterAge() {
			return InheritAndHiding.this.age;// �ⲿ������age
		}

		String getOuterName() {
			return InheritAndHiding.this.name;// �ⲿ������name
		}
		
		void output() {
			System.out.println("Inner age:" + age + "Inner name:" + name);
		}
		
		void show() {
			/*
			 * ����ڲ����ĳ���������ⲿ��ķ������ظ�
			 * ������������������ⲿ�����еĸ÷����Լ��������ķ���
			 * �������ⲿ������.this.method()��ʽ���òſ���
			 */
			output();
			InheritAndHiding.this.output();
			// output(""); // ���ֵ����ǲ��Ե�
		}
	}

	public Son createSon() {
		return new Son();
	}

	public void output() {
		System.out.println("Outer age:" + age + "Outer name:" + name);
	}

	public void output(String s) {
		System.out.println(s);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritAndHiding iah = new InheritAndHiding();
		System.out.println("Inner age:" + iah.createSon().getInnerAge());
		System.out.println("Inner name:" + iah.createSon().getInnerName());
		System.out.println("Outer age:" + iah.createSon().getOuterAge());
		System.out.println("Outer name:" + iah.createSon().getOuterName());
	}
}

class Father {
	
	String name = "Father";
}