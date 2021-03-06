/**
 * 
 */
package rtti.reflect.impl;

import rtti.reflect.demo.ClassicImplDemo;
import rtti.reflect.demo.Product;

/**
 * 传统方式实现了 Product 接口的类
 * <p>
 * interface的一个重要目标就是允许程序员隔离构件，进而降低耦合度。
 * 如果编写了接口那么就可以实现这一目标，但是通过类型信息，
 * 这种耦合度还是会传播出去，接口并非是对解耦的一种无懈可击的保障。
 * 
 * @author 刘晨伟
 * @see ClassicImplDemo
 * 
 * 创建日期：2008-5-14
 */
public class ClassicImpl implements Product {

	public void f() {
	}

	public void g() {
	}
}
