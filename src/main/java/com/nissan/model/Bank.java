package com.nissan.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
	
	@Id
	private Integer accountNumber;
	@Column(name="customerName",nullable=false,length=60)
	private String customerName;
	@Column(name="accountType",nullable=false,length=60)
	private String accountType;
	@Column(name="balance")
	private  double balance;
	@Column(name="minimumBalance")
	private double minimumBalance;
	
	@Column(name="mobileNumber")
	private long mobileNumber;
	@Column(name="emailId")
	private String emailId;
	@Column(name="atmPin")
	private Integer atmPin;
	private Boolean is_active=true;
	
	public Bank() {
		super();
		this.accountNumber=(int)(Math.random()*900000000+100000000);
		this.atmPin=(int)(Math.random()*9000+1000);
	}

	
	public long getMobileNumber() {
		return mobileNumber;
	}


	public long setMobileNumber(long mobileNumber) {
		return this.mobileNumber = mobileNumber;
	}


	public Boolean getIs_active() {
		return is_active;
	}


	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}

	public int setAccountNumber(Integer accountNumber) {
		Random random=new Random();
        return this.accountNumber=1000000000+random.nextInt(900000000);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	


	
	
}
