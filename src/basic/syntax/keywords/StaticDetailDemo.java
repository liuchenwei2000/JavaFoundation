/**
 * 
 */
package syntax.keywords;

/**
 * static成员和方法的访问控制
 * <p>
 * non-static方法中可以调用static成员和方法，也可以调用non-static成员和方法。
 * static方法中也可以调用static成员和方法，但是不可以调用non-static成员和方法，除非在它的方法体中创建一个对象后通过对象进行调用。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-11
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
	
	private static int counter = 0;// 对象总数计数器
	private int myid;// 对象编号
	
	public Walkman(){
		counter ++;
		myid = counter;
	}
	
	/**
	 * 打印编号信息
	 */
	public static void showID(int id){
		// static方法不可直接调用non-static成员
		// 因为static方法是和对象无关的
//		System.out.println("id = " + myid);
		// 可以创建一个对象后使用对象调用non-static成员
//		System.out.println("id = " + new Walkman().myid);
		System.out.println("id = " + id);
	}
	
	/**
	 * 打印所有对象总数
	 */
	public static void showTotal() {
		// 不可调用non-static方法
//		System.out.println("total = " + getTotal());
		System.out.println("total = " + counter);
	}
	
	/**
	 * 返回对象总数
	 * <p>
	 * non-static方法可以调用static成员
	 */
	public int getTotal() {
		return counter;
	}
	
	/**
	 * 返回对象编号
	 * <p>
	 * non-static方法可以调用non-static成员
	 */
	public int getID(){
		return myid;
	}
}