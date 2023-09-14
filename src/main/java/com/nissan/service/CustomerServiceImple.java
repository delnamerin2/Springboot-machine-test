package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.common.Validation;
import com.nissan.model.Bank;
import com.nissan.repository.ICustomerRepository;

@Service

public class CustomerServiceImple implements ICustomerService {
	

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private Validation validation;

	@Autowired 
	private APIResponse apiResponse;

	@Override
	public APIResponse deposit(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		Bank bank1=null;
		List<Bank> bank=(List<Bank>) customerRepo.findAll();
		for(Bank b:bank) {
		if(b.getAccountNumber()==accountNumber) {
			bank1=b;
		}
		}
		if(amount>50000) {
			apiResponse.setData("Enter pan card number");
			
		}
		bank1.setBalance(bank1.getBalance()+amount);
		apiResponse.setData("Amount added successfully,balance="+bank1.getBalance());
		apiResponse.setStatus(200);
		return apiResponse;
	}

	public APIResponse withdraw(int accountNumber, int amount) {
		
		List<Bank> bank=(List<Bank>) customerRepo.findAll();
		for(Bank b:bank) {
		if(b.getAccountNumber()==accountNumber) {
			double availableBalance=b.getBalance()-b.getMinimumBalance();
			if(amount>availableBalance) {
				apiResponse.setData("Insufficient Balance");
				apiResponse.setStatus(500);
				apiResponse.setError("insufficient balance");
				return apiResponse;
			}
			b.setBalance(b.getBalance()-amount);
			apiResponse.setData("Amount withdrawn successfully,balance="+b.getBalance());
			apiResponse.setStatus(200);
			break;
		}
	}
		return apiResponse;
	}

	@Override
	public APIResponse showBalance(int accountNumber) {
		List<Bank> bank=(List<Bank>) customerRepo.findAll();
		Bank bank1=null;
		for(Bank b:bank) {
		if(b.getAccountNumber()==accountNumber) {
			bank1=b;
		}
		apiResponse.setData("balance="+bank1.getBalance());
		apiResponse.setStatus(200);
		}
		
		return apiResponse;
	}

	@Override
	public APIResponse transfer(int accountNumber1, int accountNumber2, int amount) {
		// TODO Auto-generated method stub
		List<Bank> bank=(List<Bank>) customerRepo.findAll();
		Bank bank1=null;
		Bank bank2=null;
		for(Bank b:bank) {
			if(b.getAccountNumber()==accountNumber1) {
				bank1=b;
			}
		}
			for(Bank b:bank) {
				if(b.getAccountNumber()==accountNumber2) {
					bank2=b;
				  }
			}
		bank2.setBalance(bank2.getBalance()+amount);
		bank1.setBalance(bank2.getBalance()-amount);
		apiResponse.setData("amount transfeered successfuly");
		apiResponse.setData("bank2 balance"+bank2.getBalance());
		apiResponse.setData("bank1 balance"+bank1.getBalance());
		apiResponse.setStatus(200);
		return apiResponse;
		
	}
		
}
