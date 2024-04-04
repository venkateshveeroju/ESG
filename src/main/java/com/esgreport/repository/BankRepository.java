package com.esgreport.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esgreport.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

 List<Bank> findAll();
		// TODO Auto-generated method stub
 Bank getOne(Long id);
 
	@Query(value ="SELECT bank_name FROM banks where bank_name= :bank_name",nativeQuery = true)
	String findByName(@Param("bank_name") String bank_name);
	
}