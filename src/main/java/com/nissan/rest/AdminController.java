package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Bank;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtil;


@RestController // Controller+@Configuration
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private IAdminService adminService;

	@Autowired
	JwtUtil jwtUtil;

	// list
	@GetMapping("/customers")
	public List<Bank> getCustomer()//(@RequestHeader(value = "authorisation", defaultValue = "") String auth)
			//throws AccessDeniedException 
	{
		//jwtUtil.verify(auth);
		return adminService.getCustomer();
}

	// search by accoutNumber
	@GetMapping("/customers/{accountNumber}")
	public Bank getCustomer(@PathVariable int accountNumber)
			//@RequestHeader(value = "authorisation", defaultValue = "") String auth) throws AccessDeniedException
	{
		//jwtUtil.verify(auth);
		return adminService.getCustomer(accountNumber);
	}

	// add
	@PostMapping("/customers")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Bank customers){
			/*@RequestHeader(value = "authorisation", defaultValue = "") String auth) throws AccessDeniedException
			 {jwtUtil.verify(auth);*/
		if(adminService.saveCustomer(customers) == null) 
		{
			apiResponse.setData("Name can have only alphabets!");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID NAME");

			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
	
		apiResponse.setData("Customer added successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// update Employee
	@PutMapping("/customers/update/")
	public ResponseEntity<APIResponse> updateCustomer(@RequestBody Bank customers)
			//@RequestHeader(value = "authorisation", defaultValue = "") String auth) throws AccessDeniedException 
	{
		//jwtUtil.verify(auth);
	 adminService.saveCustomer(customers);
	 apiResponse.setData("Customer updated successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// disable or delete Employee
	@DeleteMapping("/customers/{accountNumber}")
	public ResponseEntity<APIResponse> deleteCustomer(@PathVariable int accountNumber)
			//@RequestHeader(value = "authorisation", defaultValue = "") String auth) throws AccessDeniedException
	{
		//jwtUtil.verify(auth);
		adminService.deleteCustomer(accountNumber);
		apiResponse.setData("Customer deleted successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}


	
	}

