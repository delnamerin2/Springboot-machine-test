package com.nissan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Bank;

@Repository
public interface IAdminRepository extends CrudRepository<Bank, Integer>{
	@Modifying
	@Query("update com.nissan.model.Bank set is_active=0 where accountNumber=?1")
	public void deleteCustomer(Integer accountNumber);

	
	

}
