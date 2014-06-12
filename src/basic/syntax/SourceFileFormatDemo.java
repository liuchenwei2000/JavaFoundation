/**
 * 版本信息：
 * Copyright 2007 Beijing LCW Co.Ltd.
 * All right reserved.
 */

package syntax;// 包名

import java.util.ArrayList;// 导入区

// 类注释
/**
 * 源文件格式化示例类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-11-6
 */
// 源代码的文件名必须与公有类(public)的名字相同
public class SourceFileFormatDemo {

	private int field;// 字段
	
	/**
	 * 构造方法
	 */
	public SourceFileFormatDemo() {
		
	}

	/**
	 * clone方法(紧放在构造方法下面)
	 */
	public SourceFileFormatDemo clone() {
		return this;
	}
	
	/**
	 * toString方法(每个类都应尽量重写此方法)
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * 实例方法
	 */
	public void test() {
		System.out.println(field);
	}
	
	/**
	 * main方法(放在最下面)
	 */
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		System.out.println(al);
	}
}