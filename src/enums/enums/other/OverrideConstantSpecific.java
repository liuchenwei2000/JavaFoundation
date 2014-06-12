/**
 * 
 */
package enums.other;

/**
 * ���ǳ�������
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-7
 */
public enum OverrideConstantSpecific {

	YES {
		/** 
		 * ������enum����ĸ÷���
		 *
		 * @see enums.other.OverrideConstantSpecific#say()
		 */
		void say() {
			System.out.println("YES say()");
		}
	},
	
	NO;

	void say() {
		System.out.println("default say()");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (OverrideConstantSpecific e : OverrideConstantSpecific.values()) {
			System.out.print(e + " : ");
			e.say();
		}
	}
}