package rs.engineering.javacourse.myspringmvcapp.service;

import java.util.List;

import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;

public interface CompanyService {
	
	void save(CompanyDto companyDto);
	List<CompanyDto>findAll();
	CompanyDto findById(Long id);

}
