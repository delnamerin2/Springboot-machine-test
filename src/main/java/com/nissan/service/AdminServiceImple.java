package com.nissan.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.model.Bank;
import com.nissan.repository.IAdminRepository;

@Service
public class AdminServiceImple implements IAdminService {

	@Autowired
	private IAdminRepository adminRepo;

	@Autowired
	private Validation validation;

	@Override
	public Bank saveCustomer(Bank customers) {
		if (validation.isNameValid(customers.getCustomerName())) {

			return adminRepo.save(customers);
		}
		return null;
	}
	

	@Override
	public List<Bank> getCustomer() {
		// TODO Auto-generated method stub
		return (List<Bank>) adminRepo.findAll();
}

	@Override
	public Bank getCustomer(int accountNumber) {
	
			return adminRepo.findById(accountNumber).orElseThrow(() -> new RuntimeException("customer not found for  account number" + accountNumber));
		}

	@Override
	public void deleteCustomer(int accountNumber) {
		// TODO Auto-generated method stub
		adminRepo.deleteById(accountNumber);
	}




	
	}
	
	  
	 
	 


