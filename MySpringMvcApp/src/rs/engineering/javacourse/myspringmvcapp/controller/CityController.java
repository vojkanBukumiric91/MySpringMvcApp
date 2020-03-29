package rs.engineering.javacourse.myspringmvcapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

@Controller
@RequestMapping(value = "/city")
public class CityController {
	private final CityService cityService;
	
	@Autowired
	CityController(@Qualifier("cityService")CityService cityService){
		this.cityService = cityService;
	}
	
	@GetMapping
	public String home() {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: home()    ===================");
		System.out.println("====================================================================");
		return "city/home";
	}
	/*
	@GetMapping(value = "add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: add()     ===================");
		System.out.println("====================================================================");
		CityDto cityDto = new CityDto(0l, "-");
		request.setAttribute("cityDto", cityDto);
		return "city/add";
	}
	*/
	
	@GetMapping(value = "add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("city/add");
		
		CityDto cityDto = new CityDto(0l, "N/A");
		modelAndView.addObject("cityDto",cityDto);
		
		return modelAndView;
	}
	
	
	/*
	@PostMapping(value = "save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: save()    ===================");
		System.out.println("====================================================================");
		
		Long number = Long.parseLong(request.getParameter("number"));
		String name = request.getParameter("name");
		
		CityDto cityDto = new CityDto(number,name);
		
		System.out.println(cityDto);
		return "redirect:/city/add";
	}
	*/
	
	/*
	@PostMapping(value = "save")
	public String save(@RequestParam(name="number") Long number,@RequestParam(name="name") String name) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: save()    ===================");
		System.out.println("====================================================================");
		
		CityDto cityDto = new CityDto(number,name);
		
		System.out.println(cityDto);
		return "redirect:/city/add";
		
	}
	*/
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute(name="cityDto") @Valid CityDto cityDto, BindingResult result) {
	//public String save (CityDto cityDto) {
		System.out.println("===================================================================================");
		System.out.println("====================   CityController: save(@ModelAttribute)    ===================");
		System.out.println("===================================================================================");
		
		if (result.hasErrors()) {
			ModelAndView modelAndView=new ModelAndView("city/add");
			System.out.println("====================   NOT OK    ===================");
			modelAndView.addObject("cityDto",cityDto);
			return modelAndView;
		}else {
			ModelAndView modelAndView=new ModelAndView("city/home");
			System.out.println(cityDto);
			System.out.println("====================   OK        ===================");
			cityService.save(cityDto);
			return modelAndView;
		}
	}
	
}
