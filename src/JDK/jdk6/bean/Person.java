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
 * �ˣ�JavaBean
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-27
 */
/*
 * @XmlRootElement 
 * 
 * ���ڱ�ע���ö�����ͣ�������ע������ӳ���� schema �л���һ��ȫ��Ԫ�ص���ʽ���֡�
 * ����ͨ�� @XmlRootElement ע��� name ����������ӳ��� schema ȫ��Ԫ�ص����ƣ�
 * һ����˵�� @XmlRootElement ��ע��������Ӧ�� XML �ĵ��л�����������ڵ���ʽ���֡�
 */
@XmlRootElement // ��ʾPerson��һ����Ԫ��
@XmlAccessorType(XmlAccessType.FIELD) // ����Ĭ��������Ƿ�ֻ�ֶν���ϵ�л� 
public class Person {

	/*
	 * @XmlAttribute 
	 * 
	 * ���ڱ�ע Javabean ���ԣ�������ע��������ӳ���� schema ����Ԫ��������ʽ(<person name="tom" />)���֡�
	 * ����ͨ�� @XmlAttribute ע��� name ����������ӳ�������ƣ��� required ������ָ���Ƿ�ӳ��������Ϊ������ֵġ�
	 */
	@XmlAttribute // name����ΪPerson�ĵ�һ������
	private String name;
	
	/*
	 * @XmlElement 
	 * 
	 * ���ڱ�ע Javabean �����ԣ�������ע��������ӳ���� schema ����Ԫ����ʽ(<person><sex>MALE</sex></person>)���֡�
	 * ����ͨ�� @XmlElement ע��� name ���Զ���ӳ���� XML Ԫ�ص����ƣ��� required ������ָ����Ԫ���Ƿ������֣�
	 * �� nullable ������ָ����Ԫ���Ƿ������ֵ��
	 */
	@XmlElement // sex����ΪPerson�ĵ�һ��Ԫ��
	private Sex sex;
	
	@XmlAttribute // age����ΪPerson�ĵ�һ������
	private int age;
	
	@XmlElement // address����ΪPerson�ĵ�һ��Ԫ��
	private Address address;
	
	/*
	 * ��Ԫ����Ҫ��������һ����װ���ϵİ�װ�� XML Ԫ�أ������Ա�����һ���������ԡ�
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
