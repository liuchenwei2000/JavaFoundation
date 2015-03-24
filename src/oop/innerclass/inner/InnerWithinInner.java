/**
 * 
 */
package inner;

/**
 * ����ڲ���ĳ�Ա����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-14
 */
public class InnerWithinInner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		A.AA aa = a.new AA();
		A.AA.AAA aaa = aa.new AAA();
		aaa.showAAA();
	}
}

class A {
	
	private void showA() {
		System.out.println("Inside A");
	}

	public class AA {
		
		private void showAA() {
			System.out.println("Inside AA");
		}

		class AAA {
			
			void showAAA() {
				showA();
				showAA();
				System.out.println("Inside AAA");
			}
		}
	}
}