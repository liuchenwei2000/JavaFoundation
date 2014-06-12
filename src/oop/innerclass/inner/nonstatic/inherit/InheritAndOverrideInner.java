/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * �ڲ���̳��븲����ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-18
 */
public class InheritAndOverrideInner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Egg2 egg2 = new BigEgg2();
		egg2.g();
	}
}

class Egg2 {

	private Yolk yolk = new Yolk();

	protected class Yolk {
		
		public Yolk() {
			System.out.println("Egg2.Yolk()");
		}

		public void f() {
			System.out.println("Egg2.Yolk.f()");
		}
	}

	public Egg2() {
		System.out.println("New Egg2()");
	}

	public void setYolk(Yolk yolk) {
		this.yolk = yolk;
	}

	public void g() {
		yolk.f();
	}
}

class BigEgg2 extends Egg2 {
	
	/**
	 * ���̳��ⲿ���ʱ���������ڲ�����ȷ�ļ̳и����ⲿ����ڲ����ʱ���ǿ��Ը��Ǹ����ڲ���ġ�
	 */
	protected class Yolk extends Egg2.Yolk {
		
		public Yolk() {
			System.out.println("BigEgg2.Yolk()");
		}

		public void f() {
			System.out.println("BigEgg2.Yolk.f()");
		}
	}

	public BigEgg2() {
		setYolk(new Yolk());
	}
}