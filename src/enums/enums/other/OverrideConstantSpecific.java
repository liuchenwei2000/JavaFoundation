/**
 * 
 */
package enums.other;

/**
 * 覆盖常量方法
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-7
 */
public enum OverrideConstantSpecific {

	YES {
		/** 
		 * 覆盖了enum本身的该方法
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
