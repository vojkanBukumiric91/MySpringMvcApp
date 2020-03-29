package rs.engineering.javacourse.myspringmvcapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.domain.Company;
import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;
import rs.engineering.javacourse.myspringmvcapp.repository.CompanyRepository;
import rs.engineering.javacourse.myspringmvcapp.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository<CompanyEntity> companyRepository;
	
	@Autowired
	public CompanyServiceImpl(CompanyRepository<CompanyEntity> companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public void save(CompanyDto companyDto) {
		CityEntity cityEntity = new CityEntity(companyDto.getCityDto().getNumber(), companyDto.getCityDto().getName());
		CompanyEntity company = new CompanyEntity(companyDto.getId(), companyDto.getName(), companyDto.getAddress(),
				companyDto.getNumber(), cityEntity);
		companyRepository.save(company);

	}

	@Override
	public List<CompanyDto> findAll() {
		List<CompanyDto> companies = new ArrayList<CompanyDto>();
		List<CompanyEntity> companiesEntity = companyRepository.findAll();
		for (CompanyEntity companyEntity : companiesEntity) {
			CityDto cityDto = new CityDto(companyEntity.getCityEntity().getNumber(), companyEntity.getCityEntity().getName());
			 companies.add(new
			 CompanyDto(companyEntity.getId(),companyEntity.getName(),
			 companyEntity.getAddress(), companyEntity.getNumber(), cityDto));
		}
		return companies;
	}

	@Override
	public CompanyDto findById(Long id) {
		CompanyEntity companyEntity = companyRepository.findById(id);

		CityDto cityDto = new CityDto(companyEntity.getCityEntity().getNumber(), companyEntity.getCityEntity().getName());
		return new CompanyDto(companyEntity.getId(), companyEntity.getName(), companyEntity.getAddress(),
				companyEntity.getNumber(), cityDto);
	}

}
