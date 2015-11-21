/**
 * 
 */
package io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化控制
 * <p>
 * 提供了Externalizable(它并不够自动化)的替代解决方案 。
 * <p>
 * 如果不是特别想要实现Externalizable接口，那么还有另一种方法可以实现Serializable接口，
 * 并添加(注意是"添加"，而非"重载"或者"实现")名为writeObject()和 readObject()的方法。
 * 这样一旦对象被序列化或者被反序列化，就会自动地分别调用这两个方法。
 * 也就是说，只要提供了这两个方法，就会使用它们而不是缺省的序列化机制 。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-26
 */
public class SerializeControl {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ObjectX ox = new ObjectX("Test1", "Test2");
		System.out.println("Serialize:\n" + ox);
		
		/** 序列化对象到内存 */
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(buffer);
		/*
		 * 当ObjectOutputStream调用writeObject()时必须检查参数对象，判断它是否拥有自己的writeObject()方法
		 * (不是检查接口，这里根本就没有接口，也不是检查类的类型，而是利用反射来真正地搜索方法)。
		 * 如果有，那么就会使用它。对readObject()也采用了类似的方法。
		 * 或许这是解决这个问题唯一切实可行的方法，但它确实有点古怪。
		 */
		oos.writeObject(ox);
		
		/** 反序列化内存中的对象 */
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
				buffer.toByteArray()));
		ox = (ObjectX) ois.readObject();
		System.out.println("\nDeserialize:\n" + ox);
	}
}

/**
 * 在本例中，有一个String字段是普通字段，而另一个是transient字段，用来证明：
 * 非transient字段由defaultWriteObject()方法保存，而transient字段必须在程序中明确保存和恢复。
 * 字段是在构造器内部而不是在定义处进行初始化的，以此可以证实它们在反序列化还原期间没有被一些自动机制初始化
 */
class ObjectX implements Serializable {

	private static final long serialVersionUID = -7469587839431573217L;

	private String a;
	private transient String b;

	public ObjectX(String a, String b) {
		this.a = "Not Transient: " + a;
		this.b = "Transient: " + b;
	}

	public String toString() {
		return this.a + "\n" + this.b;
	}

	/***
	 * 方法必须具有准确的方法签名： 
	 * private void writeObject(ObjectOutputStream stream) 
	 * throws IOException 
	 * 
	 * private void readObject(ObjectInputStream stream) 
	 * throws IOException, ClassNotFoundException 
	 * 
	 * 该机制的执行细节：
	 * 在调用ObjectOutputStream.writeObject()时，会检查所传递的Serializable对象，看看是否实现了它自己的writeObject()。
	 * 如果是这样，就跳过正常的序列化过程并调用它的writeObject()。readObject()的情形与此相同。
	 * 
	 * 这里有个技巧：
	 * 在writeObject()内部，可以调用ObjectOutputStream.defaultWriteObject()来选择执行缺省的writeObject()。
	 * 类似地，在readObject()内部，也可以调用 ObjectOutputStream.defaultReadObject()。
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		/*
		 * 如果打算使用缺省机制写入对象的非transient部分，那么必须调用defaultWriteObject()
		 * 作为writeObject()中的第一个操作，并让defaultReadObject()作为readObject()中的第一个操作。
		 */
		stream.defaultWriteObject();
		stream.writeObject(this.b);
	}

	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject();
		this.b = (String) stream.readObject();
	}
}
