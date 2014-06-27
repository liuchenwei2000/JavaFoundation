/**
 * 
 */
package jdk6.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 人，JavaBean
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-27
 */
/*
 * @XmlRootElement 
 * 
 * 用于标注类或枚举类型，用它标注的类在映射后的 schema 中会以一个全局元素的形式出现。
 * 可以通过 @XmlRootElement 注解的 name 属性来定制映射的 schema 全局元素的名称，
 * 一般来说以 @XmlRootElement 标注的类在相应的 XML 文档中会以最外层或根节点形式出现。
 */
@XmlRootElement // 表示Person是一个根元素
@XmlAccessorType(XmlAccessType.FIELD) // 控制默认情况下是否只字段进行系列化 
public class Person {

	/*
	 * @XmlAttribute 
	 * 
	 * 用于标注 Javabean 属性，用它标注的属性在映射后的 schema 中以元素属性形式(<person name="tom" />)表现。
	 * 可以通过 @XmlAttribute 注解的 name 属性来定制映射后的名称，用 required 属性来指定是否映射后的属性为必须出现的。
	 */
	@XmlAttribute // name将作为Person的的一个属性
	private String name;
	
	/*
	 * @XmlElement 
	 * 
	 * 用于标注 Javabean 的属性，用它标注的属性在映射后的 schema 中以元素形式(<person><sex>MALE</sex></person>)出现。
	 * 可以通过 @XmlElement 注解的 name 属性定制映射后的 XML 元素的名称，用 required 属性来指定该元素是否必须出现，
	 * 用 nullable 属性来指明该元素是否允许空值。
	 */
	@XmlElement // sex将作为Person的的一个元素
	private Sex sex;
	
	@XmlAttribute // age将作为Person的的一个属性
	private int age;
	
	@XmlElement // address将作为Person的的一个元素
	private Address address;
	
	/*
	 * 此元素主要用于生成一个包装集合的包装器 XML 元素，该属性必须是一个集合属性。
	 */
	@XmlElementWrapper(name = "books")
	@XmlElement(name = "book")
	private List<String> books;

	public Person() {
		super();
	}

	public Person(String name, Sex sex, int age, Address address) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", sex=" + sex + ", address="
				+ address + ", books=" + books;
	}
}
