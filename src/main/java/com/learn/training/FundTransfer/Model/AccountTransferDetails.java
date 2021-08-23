package com.learn.training.FundTransfer.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountTransferDetails {
	@Id

	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer accountNumber;
	
	private String AccountOwner;
	
	private String IFSCCode;
	
	private String branchName;
	
	private Double currentBalance;

	public AccountTransferDetails(Integer accountNumber, String accountOwner, String iFSCCode, String branchName,
			Double currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.AccountOwner = accountOwner;
		this.IFSCCode = iFSCCode;
		this.branchName = branchName;
		this.currentBalance = currentBalance;
		
	}

	public AccountTransferDetails() {
		super();
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountOwner() {
		return AccountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		AccountOwner = accountOwner;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	
	

}
