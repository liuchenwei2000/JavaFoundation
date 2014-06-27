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
 * JAXB APIʾ��
 * <p>
 * JAXB��Java Architecture for XML Binding����һ����������л�/�����л����ߡ�
 * ������ʹXML������Java Objects����ʽֱ��Ӧ����Java����֮�У�ʹJava Objects��XML����֮���ת����Ϊ���ܡ�
 * ��JAXB�н�Java Objects��XML���ݵ�ת����Ϊmarshal��XML���ݵ�Java Objects��ת����Ϊunmarshal��
 * <p>
 * ԭ��JAXB��JavaEE��һ���֣���JDK6�У�SUN����ŵ���JavaSE�У���Ҳ��SUN��һ��������
 * JDK6���Դ������JAXB�汾��2.0, JAXB2(JSR 222)��JDK5��������Annotation����ʶҪ���󶨵�������Եȣ�������˿����Ĺ�������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-27
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
	 * ��JavaBeanд��XML�ļ�
	 */
	private static void write2XML(String filePath) {
		try {
			/*
			 * JAXBContext ���ṩ�� JAXB API �Ŀͻ�����ڵ㡣
			 * ���ṩ�˹���ʵ�� JAXB �󶨿�ܲ�������� XML/Java ����Ϣ�ĳ�����Щ�������������顢�������֤�� 
			 */
			// JAXBContext ʵ����ʹ����Ϊ�������ݵ����Լ��ɴ���Щ�ྲ̬��õ�����ʵ�ֳ�ʼ����
			JAXBContext context = JAXBContext.newInstance(Person.class);
			// Marshaller ��ʹ�ͻ���Ӧ�ó����ܹ��� Java ������ת���� XML ���ݡ�
			Marshaller marshaller = context.createMarshaller();
			// ���� jaxbElement Ϊ�������������鵽 File ��
			marshaller.marshal(createPerson(), new File(filePath));
			System.out.println("write to XML complete.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��XML�ļ��ж�ȡJavaBean
	 */
	private static void readFromXML(String filePath) {
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			// Unmarshaller ����� XML ���ݷ����л�Ϊ�´����� Java �������Ĺ��̣������ڽ���ʱ��ѡ�����֤ XML ���ݡ� 
			Unmarshaller unmarshaller = context.createUnmarshaller();
			// ��ָ�����ļ����� XML ���ݲ����صõ�����������
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
