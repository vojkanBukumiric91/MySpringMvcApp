package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;
import rs.engineering.javacourse.myspringmvcapp.repository.CompanyRepository;

@Repository
public class CompanyJpaRepository implements CompanyRepository<CompanyEntity> {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(CompanyEntity company) {
		
		entityManager.persist(company);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyEntity> findAll() {
		// TODO Auto-generated method stub
		System.out.println("===================");
		return entityManager.createQuery("SELECT c FROM CompanyEntity c ").getResultList();
		
	}

	@Override
	public CompanyEntity findById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(CompanyEntity.class, id);
	}

	

}
