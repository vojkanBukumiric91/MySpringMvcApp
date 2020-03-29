package rs.engineering.javacourse.myspringmvcapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import rs.engineering.javacourse.myspringmvcapp.domain.City;

@Entity
@Table(name = "company")
public class CompanyEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2142244320352058358L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String number;
	@OneToOne
	@JoinColumn(name="cityNumber", referencedColumnName = "number")
	private CityEntity cityEntity;
	
	public CompanyEntity() {
	}

	public CompanyEntity(Long id, String name, String address, String number, CityEntity cityEntity) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityEntity = cityEntity;
	}

	public CompanyEntity(String name, String address, String number, CityEntity cityEntity) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityEntity = cityEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public CityEntity getCityEntity() {
		return cityEntity;
	}

	public void setCityEntity(CityEntity cityEntity) {
		this.cityEntity = cityEntity;
	}

	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", name=" + name + ", address=" + address + ", number=" + number
				+ ", cityEntity=" + cityEntity + "]";
	}
	

	
}
