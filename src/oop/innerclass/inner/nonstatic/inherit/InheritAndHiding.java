/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * 内部类继承和隐藏演示
 * <p>
 * 当内部类的成员和外部类的成员标识符一样时，在内部类中使用时内部类的成员会隐藏外部类成员。
 * <p>
 * <strong>内部类隐藏外部类成员会导致程序不易读，应避免这种设计</strong>
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-12
 */
public class InheritAndHiding {
	
	String name = "InheritAndHiding";
	int age = 0;

	class Son extends Father {
		// 内部类的成员包括自己的成员和继承来的成员
		int age = 10;

		int getInnerAge() {
			return age;// Son自己的age(this.age)
		}

		String getInnerName() {
			return name;// Son继承来的name(this.name)
		}
		
		int getOuterAge() {
			return InheritAndHiding.this.age;// 外部类对象的age
		}

		String getOuterName() {
			return InheritAndHiding.this.name;// 外部类对象的name
		}
		
		void output() {
			System.out.println("Inner age:" + age + "Inner name:" + name);
		}
		
		void show() {
			/*
			 * 如果内部类的某个方法和外部类的方法名重复
			 * 则这个方法将会隐藏外部类所有的该方法以及重载它的方法
			 * 除非用外部类类名.this.method()方式调用才可以
			 */
			output();
			InheritAndHiding.this.output();
			// output(""); // 这种调用是不对的
		}
	}

	public Son createSon() {
		return new Son();
	}

	public void output() {
		System.out.println("Outer age:" + age + "Outer name:" + name);
	}

	public void output(String s) {
		System.out.println(s);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritAndHiding iah = new InheritAndHiding();
		System.out.println("Inner age:" + iah.createSon().getInnerAge());
		System.out.println("Inner name:" + iah.createSon().getInnerName());
		System.out.println("Outer age:" + iah.createSon().getOuterAge());
		System.out.println("Outer name:" + iah.createSon().getOuterName());
	}
}

class Father {
	
	String name = "Father";
}