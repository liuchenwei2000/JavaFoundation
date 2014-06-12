/**
 * 
 */
package generic;

/**
 * 内部类的泛型
 * <p>
 * 一个静态内部类可以用它自己的类型变量声明为泛型 。</br>
 * 虽然静态成员不能涉及它所在类的类型变量(泛型)，但是静态内部类的类型变量
 * 和它的外围类的类型变量是不同的，即使这两个类型变量的名称是一样的。
 * 
 * <strong>
 * 这种设计会使得程序结构变得复杂并且不易懂，尽量不使用。
 * </strong>
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-9-15
 */
public class NestedGenericType<E> {
	
	// private static Cell<E> invalid;// static变量不能和泛型同时使用
	protected Cell<E> head;// 这里的E是外部类的泛型
	protected Cell<E> tail;

	/* ... rest of NestedGenericType ... */
	
	/**
	 * 静态内部类和外部类的泛型名字一样，这虽然会导致可读性下降 ，
	 * 但是这在语义上表示它们所代表的类型应该是一样的。
	 * 内部类的泛型会隐藏外部类的任何泛型，所以隐藏应该被避免。
	 */
	static class Cell<E> {
		
		private Cell<E> next;
		private E element;// 变量或者字段可以这样声明为泛型

		public Cell(E element) {// 形式参数也可以声明为泛型
			this.element = element;
		}

		public Cell(E element, Cell<E> next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {// 返回类型也可以声明为泛型
			return element;
		}

		public Cell<E> getNext() {
			return next;
		}
	}

	/**
	 * 非静态内部类可以直接使用外部类的泛型
	 */
	class Cell2 {
		
		private Cell2 next;
		private E element;

		public Cell2(E element) {
			this.element = element;
		}

		public Cell2(E element, Cell2 next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {
			return element;
		}

		public Cell2 getNext() {
			return next;
		}
	}
}