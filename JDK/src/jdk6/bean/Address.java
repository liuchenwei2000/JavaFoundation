/**
 * 
 */
package jdk6.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 地址
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-27
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	@XmlAttribute(name="nation") // country作为Address的一个属性
	private String country;
	@XmlElement(name="privince") // state作为Address的一个元素
	private String state;
	@XmlElement
	private String city;

	@XmlTransient // postcode元素不会出现在输出的xml中
	private String postcode;

	public Address() {
		super();
	}

	public Address(String country, String state, String city, String postcode) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return country + " " + state + " " + city + ". postcode=" + postcode;
	}
}
