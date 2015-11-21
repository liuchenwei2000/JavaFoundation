/**
 * 
 */
package jdk7;

import java.util.ArrayList;
import java.util.List;

/**
 * 3，创建泛型实例时自动类型推断
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月19日
 */
public class TypeInference4GenericInstanceCreation {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 在以前的版本中使用泛型类型，需要在声明并赋值的时候，两侧都加上泛型类型。
		List<String> strList = new ArrayList<String>();
		// 在Java SE 7中，这种方式得以改进，现在可以使用如下语句进行声明并赋值：
		List<String> strList2 = new ArrayList<>(); // 注意后面的"<>"
		/*
		 * 编译器会根据变量声明时的泛型类型自动推断出实例化HashMap时的泛型类型。
		 * 再次提醒一定要注意new HashMap后面的「<>」，只有加上这个「<>」才表示是自动类型推断，
		 * 否则就是非泛型类型的HashMap，并且在使用编译器编译源代码时会给出一个警告提示。
		 */
		
		/*
		 * Java SE 7在创建泛型实例时的类型推断是有限制的，只能在联系上下文可以明确确定参数化类型的时候使用泛型推断。
		 * 例如：下面的例子无法正确编译：
		 */
		List<String> list = new ArrayList<>();
		list.add("A");
		// 由于addAll期望获得Collection<? extends String>类型的参数，因此下面的语句无法通过编译
//		list.addAll(new ArrayList<>());
	}
}
