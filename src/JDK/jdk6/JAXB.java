/**
 * 
 */
package jdk6;

import java.io.File;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jdk6.bean.Address;
import jdk6.bean.Person;
import jdk6.bean.Sex;

/**
 * 2，JAXB API示例
 * <p>
 * JAXB（Java Architecture for XML Binding）是一种特殊的序列化/反序列化工具。
 * 它可以使XML数据以Java Objects的形式直接应用于Java程序之中，使Java Objects与XML数据之间的转换成为可能。
 * 在JAXB中将Java Objects到XML数据的转换称为marshal；XML数据到Java Objects的转换称为unmarshal。
 * <p>
 * 原来JAXB是JavaEE的一部分，在JDK6中，SUN将其放到了JavaSE中，这也是SUN的一贯做法。
 * JDK6中自带的这个JAXB版本是2.0, JAXB2(JSR 222)用JDK5的新特性Annotation来标识要作绑定的类和属性等，极大简化了开发的工作量。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-27
 */
public class JAXB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "files/jdk6/person.xml";
		write2XML(filePath);
		readFromXML(filePath);
	}
	
	/**
	 * 将JavaBean写到XML文件
	 */
	private static void write2XML(String filePath) {
		try {
			/*
			 * JAXBContext 类提供到 JAXB API 的客户端入口点。
			 * 它提供了管理实现 JAXB 绑定框架操作所需的 XML/Java 绑定信息的抽象，这些操作包括：解组、编组和验证。 
			 */
			// JAXBContext 实例是使用作为参数传递的类以及可从这些类静态获得的类来实现初始化的
			JAXBContext context = JAXBContext.newInstance(Person.class);
			// Marshaller 类使客户端应用程序能够将 Java 内容树转换回 XML 数据。
			Marshaller marshaller = context.createMarshaller();
			// 将以 jaxbElement 为根的内容树编组到 File 中
			marshaller.marshal(createPerson(), new File(filePath));
			System.out.println("write to XML complete.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从XML文件中读取JavaBean
	 */
	private static void readFromXML(String filePath) {
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			// Unmarshaller 类管理将 XML 数据反序列化为新创建的 Java 内容树的过程，并可在解组时有选择地验证 XML 数据。 
			Unmarshaller unmarshaller = context.createUnmarshaller();
			// 从指定的文件解组 XML 数据并返回得到的内容树。
			Person person = (Person) unmarshaller.unmarshal(new File(filePath));
			System.out.println(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Person createPerson() {
		Person person = new Person();
		person.setName("Tom");
		person.setAge(20);
		person.setSex(Sex.MALE);
		person.setAddress(new Address("U.S.A", "California", "L.A", "90015 "));
		person.setBooks(Arrays.asList("Java Cookbook", "Thinking in Java", "Java Tutorial"));
		return person;
	}
}
