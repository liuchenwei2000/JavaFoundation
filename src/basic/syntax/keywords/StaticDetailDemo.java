/**
 * 
 */
package syntax.keywords;

/**
 * static��Ա�ͷ����ķ��ʿ���
 * <p>
 * non-static�����п��Ե���static��Ա�ͷ�����Ҳ���Ե���non-static��Ա�ͷ�����
 * static������Ҳ���Ե���static��Ա�ͷ��������ǲ����Ե���non-static��Ա�ͷ��������������ķ������д���һ�������ͨ��������е��á�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-11
 */
public class StaticDetailDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Walkman w1 = new Walkman();
		Walkman.showID(w1.getID());
		Walkman.showTotal();
		Walkman w2 = new Walkman();
		Walkman.showID(w2.getID());
		Walkman.showTotal();
	}
}
class Walkman{
	
	private static int counter = 0;// ��������������
	private int myid;// ������
	
	public Walkman(){
		counter ++;
		myid = counter;
	}
	
	/**
	 * ��ӡ�����Ϣ
	 */
	public static void showID(int id){
		// static��������ֱ�ӵ���non-static��Ա
		// ��Ϊstatic�����ǺͶ����޹ص�
//		System.out.println("id = " + myid);
		// ���Դ���һ�������ʹ�ö������non-static��Ա
//		System.out.println("id = " + new Walkman().myid);
		System.out.println("id = " + id);
	}
	
	/**
	 * ��ӡ���ж�������
	 */
	public static void showTotal() {
		// ���ɵ���non-static����
//		System.out.println("total = " + getTotal());
		System.out.println("total = " + counter);
	}
	
	/**
	 * ���ض�������
	 * <p>
	 * non-static�������Ե���static��Ա
	 */
	public int getTotal() {
		return counter;
	}
	
	/**
	 * ���ض�����
	 * <p>
	 * non-static�������Ե���non-static��Ա
	 */
	public int getID(){
		return myid;
	}
}