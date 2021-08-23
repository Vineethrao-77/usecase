package com.learn.training.FundTransfer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.training.FundTransfer.Exceptions.AdharNotFoundException;
import com.learn.training.FundTransfer.Exceptions.IdNotFoundException;
import com.learn.training.FundTransfer.Model.CustomerRegistrationInfo;
import com.learn.training.FundTransfer.Service.CustomerRegistrationService;


@RestController
public class CustomRegistrationController {
	@Autowired
	CustomerRegistrationService service;

	@RequestMapping(value="/GetCustomerBy{userId}", method=RequestMethod.GET)
	public ResponseEntity<CustomerRegistrationInfo> GetByUserId(@PathVariable Integer userId) throws IdNotFoundException{
		CustomerRegistrationInfo customerinfo=service.getByuserId(userId);
		if(customerinfo==null)
			throw new IdNotFoundException("Customer Id Not Found with " +userId);
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
			
		
	}
	@RequestMapping(value="/GetCustomerBy/{adharNumber}", method=RequestMethod.GET)
	public ResponseEntity<CustomerRegistrationInfo> GetByAdharNumber(@PathVariable Long adharNumber) throws AdharNotFoundException{
		
		CustomerRegistrationInfo customerinfo=service.getByAdharNumber(adharNumber);
		if(customerinfo==null)
			throw new AdharNotFoundException("Adhar number not found with the " +adharNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
		
		
	}
	@RequestMapping(value="/CreateCustomer", method=RequestMethod.POST)
	public ResponseEntity<CustomerRegistrationInfo> CreateCustomerInfo
	(@RequestBody CustomerRegistrationInfo customerregistartioninfo){
		CustomerRegistrationInfo customerinfo=service.CreateCustomerInfo(customerregistartioninfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerinfo);
		
	}
	@RequestMapping(value="/GetAllCustomersInfo", method=RequestMethod.GET)
	public ResponseEntity<List<CustomerRegistrationInfo>> GetAllCutomers(){
		List<CustomerRegistrationInfo> customerinfo=service.GetAllCustomers();
				return ResponseEntity.status(HttpStatus.OK).body(customerinfo);
			
		
	}
	
	
}
