package com.learn.training.FundTransfer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.training.FundTransfer.Model.CustomerRegistrationInfo;
import com.learn.training.FundTransfer.Repository.CustomerRegistrationRepository;

@Service
public class CustomerRegistrationService {
	@Autowired
	CustomerRegistrationRepository repo;
	
	public CustomerRegistrationInfo getByuserId(Integer userId) {
		return repo.findByuserId(userId);
	}
	
	public CustomerRegistrationInfo getByAdharNumber(Long adharNumber) {
		return repo.findByadharNumber(adharNumber);
	}

	public CustomerRegistrationInfo getByMobileNumber(Long mobileNumber) {
		return repo.findBymobileNumber(mobileNumber);
	}
	
	public CustomerRegistrationInfo CreateCustomerInfo(CustomerRegistrationInfo CustomerRegistrationInfo) {
		return repo.save(CustomerRegistrationInfo);
	}
	
	public List<CustomerRegistrationInfo> GetAllCustomers(){
		return repo.findAll();
		}
}


