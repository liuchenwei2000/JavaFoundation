/**
 * 
 */
package inner.other;

/**
 * 演示类
 * 
 * @author 刘晨伟
 *
 * 创建时间：2007-11-12
 */
public class ShareDataDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(IShareData.DATA.getState());
		IShareData.DATA.setState(1);
		System.out.println(IShareData.DATA.getState());
	}
}

/**
 * 如果在一个接口中想要共享一个可修改的数据，可以在接口中声明一个内部类，
 * 让该类来保存数据，并且该类提供修改数据的方法(即setter/getter方法)，然后在接口中提供一个指向这个内部类对象的引用。
 * 当然也完全可以在接口外定义这个保存数据的类这里这样做是为了封装实现细节并且高内聚。
 */
interface IShareData {
	
	class Data {
		
		private int state = 0;

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}
	}
	
	Data DATA = new Data();
}
