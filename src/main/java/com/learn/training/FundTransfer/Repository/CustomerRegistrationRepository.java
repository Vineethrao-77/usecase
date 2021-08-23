package com.learn.training.FundTransfer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.training.FundTransfer.Model.CustomerRegistrationInfo;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationInfo, Integer> {
	
	public CustomerRegistrationInfo findByuserId (Integer userId);
	
	public CustomerRegistrationInfo findByadharNumber(Long adharNumber);
	
	public CustomerRegistrationInfo findBymobileNumber(Long mobileNumber);

}
