package com.nissan.service;


import java.util.List;


import com.nissan.model.Bank;

public interface IAdminService {
	
	//insert
	public Bank saveCustomer(Bank customers);

	
	//list
	public List<Bank> getCustomer();
	
	public Bank getCustomer(int accountNumber);
	
	//delete 
	public void deleteCustomer(int accountNumber);
	
	
	
	
	
}
