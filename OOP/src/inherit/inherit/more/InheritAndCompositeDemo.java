/**
 * 
 */
package inherit.more;

/**
 * 使用继承和组合进行设计的演示
 * <p>
 * 组合不会强制程序设计进入继承的层次结构，而且组合更加灵活，因为它可以动态选择类型（也就选择了行为）；
 * 相反，继承在编译时就需要知道确切类型。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-10
 */
public class InheritAndCompositeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
}

class Actor {
	public void act() {
	}
}

class HappyActor extends Actor {
	public void act() {
		System.out.println("HappyActor");
	}
}

class SadActor extends Actor {
	public void act() {
		System.out.println("SadActor");
	}
}

/**
 * 组合中初始化对象引用的位置有三个：</br>
 * <li>1，在定义对象的地方，这意味着他们总是能够在构造器被调用之前被初始化。
 * <li>2，在类的构造器中。
 * <li>3，就在正要使用这些对象之前(懒加载)。
 */
class Stage {
	
	// 第一种初始化方式
	private Actor actor1 = new HappyActor();
	
	@SuppressWarnings("unused")
	private Actor actor2;
	private Actor actor3;

	public Stage(){
		// 第二种初始化方式
		actor2 = new HappyActor();
	}
	
	/**
	 * 第三种初始化方式
	 */
	public Actor getActor3() {
		if (actor3 == null) {
			actor3 = new HappyActor();
		}
		return actor3;
	}
	
	public void change() {
		actor1 = new SadActor();
	}

	public void performPlay() {
		actor1.act();
	}
}
