package com.learn.training.FundTransfer.Model;

import java.math.BigDecimal;

public class TransferBalanceRequest {
private Integer FromAccountNumber;
private Integer ToAcccountNumber;
private BigDecimal amount;
public Integer getFromAccountNumber() {
	return FromAccountNumber;
}
public void setFromAccountNumber(Integer fromAccountNumber) {
	FromAccountNumber = fromAccountNumber;
}
public Integer getToAcccountNumber() {
	return ToAcccountNumber;
}
public void setToAcccountNumber(Integer toAcccountNumber) {
	ToAcccountNumber = toAcccountNumber;
}
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public TransferBalanceRequest(Integer fromAccountNumber, Integer toAcccountNumber, BigDecimal amount) {
	super();
	FromAccountNumber = fromAccountNumber;
	ToAcccountNumber = toAcccountNumber;
	this.amount = amount;
}
public TransferBalanceRequest() {
	super();
}


}

