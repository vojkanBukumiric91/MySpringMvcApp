package rs.engineering.javacourse.myspringmvcapp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;
import rs.engineering.javacourse.myspringmvcapp.service.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	private CityService cityService;
	private CompanyService companyService;

	@Autowired
	public CompanyController(@Qualifier(value = "cityService")CityService cityService, CompanyService companyService) {
		this.cityService = cityService;
		this.companyService = companyService;
	}

	@GetMapping
	public String home() {
		System.out.println("====================================================================");
		System.out.println("====================   CompanyController: home()  ===================");
		System.out.println("====================================================================");
		return "company/home";
	}

	@GetMapping(value = "add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CompanyController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("company/add");

		CompanyDto companyDto = new CompanyDto();
		modelAndView.addObject("companyDto", companyDto);
		// modelAndView.addObject("cities", getAllCities());
		return modelAndView;
	}

	
	@GetMapping(value = "all")
	public ModelAndView all() {
		ModelAndView modelAndView = new ModelAndView("company/all");
		//modelAndView.addObject("CompanyDto", getAllCompanies());
		return modelAndView;
	}

	@ModelAttribute(value = "cities")
	private List<CityDto> getAllCities() {
		return cityService.getAll();
	}

	@ModelAttribute(value = "companies")
	private List<CompanyDto> getAllCompanies() {
		//ModelAndView modelAndView = new ModelAndView("company/all");
		
		return companyService.findAll();
	
		
	}

	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute(name = "companyDto") CompanyDto companyDto, BindingResult result) {
		System.out.println("================================  =================================");
		System.out.println(companyDto);
		System.out.println("================================  =================================");

		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("================================ NOT OK =================================");
			modelAndView.setViewName("company/add");
			modelAndView.addObject("companyDto", companyDto);
		} else {
			System.out.println("================================     OK =================================");
			modelAndView.setViewName("company/home");
			companyService.save(companyDto);
		}
		return modelAndView;
	}

}
