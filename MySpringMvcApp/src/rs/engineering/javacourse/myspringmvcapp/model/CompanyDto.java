package rs.engineering.javacourse.myspringmvcapp.model;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

public class CompanyDto  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Unesite ime")
	private String name;
	@NotBlank(message = "Unesite adresu")
	private String address;
	@NotBlank(message = "Unesite broj uluce")
	private String number;
	private CityDto cityDto;
	
	
	
	public CompanyDto(Long id, @NotBlank(message = "Unesite ime") String name,
			@NotBlank(message = "Unesite adresu") String address,
			@NotBlank(message = "Unesite broj uluce") String number, CityDto cityDto) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityDto = cityDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompanyDto() {
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

	public CityDto getCityDto() {
		return cityDto;
	}

	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}

	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + ", address=" + address + ", number=" + number + ", cityDto="
				+ cityDto + "]";
	}

	

	
	
	
}
