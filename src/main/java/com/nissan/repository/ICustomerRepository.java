package com.nissan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nissan.model.Bank;

public interface ICustomerRepository extends CrudRepository<Bank, Integer> {
	
	

}
