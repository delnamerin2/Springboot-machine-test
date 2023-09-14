package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtil;

@RestController // Controller+@Configuration
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	JwtUtil jwtUtil;
	
	@PutMapping("/users/deposit/{accountNumber}&{amount}")
	public ResponseEntity<APIResponse> deposit(@PathVariable int accountNumber,@PathVariable int amount){
		 apiResponse = customerService.deposit(accountNumber,amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}


	@PutMapping("/users/withdraw/{accountNumber}&{amount}")
	public ResponseEntity<APIResponse> withdraw(@PathVariable int accountNumber,@PathVariable int amount){
		 apiResponse = customerService.withdraw(accountNumber,amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	
	@GetMapping("/users/showBalance/{accountNumber}")
	public ResponseEntity<APIResponse> showBalance(@PathVariable int accountNumber){
		 apiResponse = customerService.showBalance(accountNumber);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@PutMapping("/users/transfer/{accountNumber1}&{accountNumber2}&{amount}")
	public ResponseEntity<APIResponse> transfer(@PathVariable int accountNumber1,@PathVariable int accountNumber2,@PathVariable int amount){
		 apiResponse = customerService.transfer(accountNumber1,accountNumber2,amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	}
	
	
