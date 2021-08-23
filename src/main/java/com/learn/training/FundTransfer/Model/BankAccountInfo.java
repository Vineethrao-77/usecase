package com.learn.training.FundTransfer.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccountInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "Account Number isMandatory")
	private Integer accountNumber;
	
	@NotEmpty(message = "IFSC is Mandatory")
	private String ifsccode;
	
	@NotEmpty(message = "Please provide Branch Name")
	private String branchName;
	
	@NotNull(message = "Please Enter Balance")
	private BigDecimal availableBalance;

	public BankAccountInfo(@NotNull(message = "Account Number isMandatory") Integer accountNumber,
			@NotEmpty(message = "IFSC is Mandatory") String ifsccode,
			@NotEmpty(message = "Please provide Branch Name") String branchName,
			@NotNull(message = "Please Enter Balance") BigDecimal availableBalance) {
		super();
		this.accountNumber = accountNumber;
		this.ifsccode = ifsccode;
		this.branchName = branchName;
		this.availableBalance = availableBalance;
	}

	public BankAccountInfo() {
		super();
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	
}
