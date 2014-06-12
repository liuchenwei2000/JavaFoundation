/**
 * 
 */
package generic.erase;

import java.util.ArrayList;

/**
 * 泛型的类型擦除演示
 * <p>
 * Java泛型是使用擦除来实现的，这意味着当使用泛型时任何具体的类型信息都被擦除了，
 * 唯一知道的就是在使用一个对象。
 * <p>
 * 无论是List<String>和List<Integer>在运行时事实上是相同的类型，
 * 这两种形式都被擦除成它们的"原生"类型，即List。
 * <p>
 * 擦除主要的正当理由是从非泛化代码到泛化代码的转变过程，
 * 以及在不破坏现有类库的情况下，将泛型融入Java语言。
 * <p>
 * 擦除使得现有的非泛型客户端代码能够在不改变的情况下继续使用直至客户端准备好用泛型重写这些代码，
 * 它不会突然破坏掉所有现有的代码。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-16
 */
public class TypeErasedDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?> c1 = new ArrayList<Integer>().getClass();
		Class<?> c2 = new ArrayList<String>().getClass();
		if(c1 == c2) {
			System.out.println("ArrayList<Integer> and ArrayList<String> are the same class type.");
		}
	}
}
/**
 * 泛型接口的类型擦除
 * <p>
 * 要支持擦除的转换，需要强行限制一个类或类型变量不能同时成为两个接口类型的子类，
 * 而这两个接口是同一接口的不同参数化。
 */
interface Payable<T> {

}

class Employee implements Payable<Employee> {

}
/**
 * 因为擦除会将Payable<Employee>和Payable<Hourly>简化为相同的类Payable。
 * 这样下面的代码就意味着在重复两次地实现相同的接口。
 * 如果从Payable的两种变体中都移除掉泛型参数就可以编译了。
 */
//class Hourly extends Employee implements Payable<Hourly> {
//
//}