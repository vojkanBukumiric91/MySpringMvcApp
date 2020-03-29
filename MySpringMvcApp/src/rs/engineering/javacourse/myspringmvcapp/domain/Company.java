package rs.engineering.javacourse.myspringmvcapp.domain;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2142244320352058358L;

	private Long id;
	private String name;
	private String address;
	private String number;
	@OneToOne
	@JoinColumn(name = "cityNumber", referencedColumnName = "number")
	private City city;

	public Company() {
	}

	public Company(Long id, String name, String address, String number, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.city = city;
	}

	public Company(String name, String address, String number, City city) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
