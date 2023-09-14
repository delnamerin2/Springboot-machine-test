package com.nissan.service;

import com.nissan.common.APIResponse;

public interface ICustomerService {

	public APIResponse deposit(int accountNumber,int amount);
	public APIResponse withdraw(int accountNumber,int amount);
	public APIResponse showBalance(int accountNumber);
	public APIResponse transfer(int accountNumber1,int accountNumber2,int amount);
	
	
}
