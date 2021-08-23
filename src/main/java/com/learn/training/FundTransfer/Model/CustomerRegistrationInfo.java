package com.learn.training.FundTransfer.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CustomerRegistrationInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
	
	@NotEmpty(message = "Name can not be Blank")
	private String name;
	
	@NotNull(message ="Please Enter Your Mobile Number")
	private Long mobileNumber;
	
	@Email(message = "Enter the valid mailid")
	private String emailId;
	
	@NotEmpty(message = "Please Enter your Adress")
	private String address;
	
	@NotNull(message ="Please Enter Your Adhar Number")
	private Long adharNumber;
	
	@NotEmpty(message = "Please Enter your Company Name")
	private String employerName;
	
	private String password;
	
	@OneToOne(targetEntity = BankAccountInfo.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "Acc_no" ,referencedColumnName = "accountNumber")
	private BankAccountInfo BankAccountInfo;

	public CustomerRegistrationInfo(Integer userId, String userName,
			@NotEmpty(message = "Name can not be Blank") String name,
			@NotNull(message = "Please Enter Your Mobile Number") Long mobileNumber,
			@Email(message = "Enter the valid mailid") String emailId,
			@NotEmpty(message = "Please Enter your Adress") String address,
			@NotNull(message = "Please Enter Your Adhar Number") Long adharNumber,
			@NotEmpty(message = "Please Enter your Company Name") String employerName, String password,
			BankAccountInfo bankAccountinfo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.adharNumber = adharNumber;
		this.employerName = employerName;
		this.password = password;
		this.BankAccountInfo = bankAccountinfo;
	}

	public CustomerRegistrationInfo() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankAccountInfo getBankAccountInfo() {
		return BankAccountInfo;
	}

	public void setBankAccountInfo(BankAccountInfo bankAccountInfo) {
		BankAccountInfo = bankAccountInfo;
	}

	
	
	
}
