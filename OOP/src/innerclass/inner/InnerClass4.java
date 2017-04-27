/**
 * 
 */
package inner;

/**
 * 内部类演示4
 * <p>
 * 用途4：</br>
 * 可以在一个方法里面或者任意的作用域内定义内部类，这样做的理由是：
 * <li>1，实现了某类型的接口，可以创建并返回对其的引用。
 * <li>2，当要解决一个复杂的问题想要创建一个类来辅助解决方案，但是又不希望这个类是公共可用的。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-13
 */
public class InnerClass4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InnerClass4 d = new InnerClass4();
		d.track();
	}

	private void internalTracking(boolean b) {
		/*
		 * 虽然内部类是被嵌入了if语句的作用域内，这并不是说该类的创建是有条件的。
		 * 它其实与别的类一起编译过了，但是在定义该类的作用域外它是不可用的。
		 * 除此之外和别的普通类是一样的。
		 */
		if (b) {
			class TrackingSlip {
				
				private String id;

				TrackingSlip(String s) {
					id = s;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			ts.getSlip();
		}
		// 超出了作用域 TrackingSlip 就不可用了
		// TrackingSlip ts = new TrackingSlip("cannot use");
	}

	public void track() {
		internalTracking(true);
	}
}
