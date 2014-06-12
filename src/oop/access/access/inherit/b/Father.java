/**
 * 
 */
package access.inherit.b;

import access.inherit.a.GrandFather;
import access.inherit.c.Son;

/**
 * 父类
 * <p>
 * 演示protected真正的访问控制含义：</br>
 * 当祖父类、父类、子类和子孙类不同包时，
 * <li>若在父类中有祖父类的对象，则该对象不可访问它的protected成员
 * <li>若在父类中有子孙类的对象，则该对象可以访问它的protected成员
 * <li>如果是protected static成员则都可以访问
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-9
 */
public class Father extends GrandFather {

	public Father() {
	}

	/**
	 * 返回自己的age
	 */
	public int getAge() {
		return this.age;
	}

//	/**
//	 * 返回祖父的age
//	 */
//	public int getGrandFatherAge(GrandFather gf) {
//		return gf.age;
//	}

	/**
	 * 返回儿子的age
	 */
	public int getSonAge(Son son) {
		return son.age;
	}

	/**
	 * 返回子孙的age
	 */
	public <T extends Father> int getChildAge(T t) {
		return t.age;
	}
	
	/**
	 * 返回自己的name
	 */
	public String getName() {
		return Father.name;
	}
	
	/**
	 * 返回祖父的name
	 */
	public String getGrandFatherName() {
		return GrandFather.name;
	}
	
	/**
	 * 返回儿子的name
	 */
	public String getSonName() {
		return Son.name;
	}
	
	/**
	 * 返回子孙的name
	 */
	public <T extends Father> String getChildName() {
		return T.name;
	}
}