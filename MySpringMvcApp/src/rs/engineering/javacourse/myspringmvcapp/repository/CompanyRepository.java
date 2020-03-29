package rs.engineering.javacourse.myspringmvcapp.repository;

import java.util.List;

import rs.engineering.javacourse.myspringmvcapp.domain.Company;
import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;

public interface CompanyRepository<T> {
	void save (T company);
	List<T>findAll();
	T findById(Long id);
}
