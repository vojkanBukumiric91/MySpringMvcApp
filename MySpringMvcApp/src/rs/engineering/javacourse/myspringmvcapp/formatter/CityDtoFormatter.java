package rs.engineering.javacourse.myspringmvcapp.formatter;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

public class CityDtoFormatter implements Formatter<CityDto>{
	private final CityService cityService;
	
	@Autowired
	public CityDtoFormatter(CityService cityService) {
		System.out.println("=======CityDtoFormatter: constructor============================================");
		this.cityService = cityService;
	}
	
	@Override
	public String print(CityDto cityDto, Locale locale) {
		System.out.println("=======CityDtoFormatter: print============================================");
		System.out.println(cityDto);
		System.out.println("==========================================================================");
		return cityDto.toString();
	}

	@Override
	public CityDto parse(String city, Locale locale) {
		System.out.println("=======CityDtoFormatter: parse============================================");
		System.out.println(city);
		System.out.println("==========================================================================");
		
		Long number=Long.parseLong(city);
		System.out.println(number);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		CityDto cityDto = cityService.findById(number);
		System.out.println("==========================================================================");
		return cityDto;
		
//		if (city.contentEquals("11000")){
//			return new CityDto(1100l,"Beograd");
//		}
//		if (city.contentEquals("13000")){
//			return new CityDto(1300l,"Pancevo");
//		}
//		if (city.contentEquals("37230")){
//			return new CityDto(37230l,"Aleksandrovac");
//		}
//		return null;
	}

}
