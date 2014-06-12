/**
 * 
 */
package inner.other;

/**
 * ��ʾ��
 * 
 * @author ����ΰ
 *
 * ����ʱ�䣺2007-11-12
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
 * �����һ���ӿ�����Ҫ����һ�����޸ĵ����ݣ������ڽӿ�������һ���ڲ��࣬
 * �ø������������ݣ����Ҹ����ṩ�޸����ݵķ���(��setter/getter����)��
 * Ȼ���ڽӿ����ṩһ��ָ������ڲ����������á�
 * (��ȻҲ��ȫ�����ڽӿ��ⶨ������������ݵ���������������Ϊ�˷�װʵ��ϸ�ڲ��Ҹ��ھ�)
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