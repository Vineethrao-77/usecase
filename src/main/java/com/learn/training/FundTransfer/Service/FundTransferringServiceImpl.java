package com.learn.training.FundTransfer.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.training.FundTransfer.Exceptions.UnableTOTransferFundException;
import com.learn.training.FundTransfer.Model.BankAccountInfo;
import com.learn.training.FundTransfer.Model.Response;
import com.learn.training.FundTransfer.Model.TransferBalanceRequest;
//import com.learn.training.FundTransfer.Repository.BankRepository;
import com.learn.training.FundTransfer.Repository.BankRepository;

@Service
public class FundTransferringServiceImpl implements FundTransferringService {
	@Autowired
	BankRepository repo;
	

	public BankAccountInfo save(BankAccountInfo accountinfo) {

		return repo.save(accountinfo);
	}

	public ResponseEntity<Response> TransferBalanceRequest(TransferBalanceRequest transferBalanceRequest)
			throws UnableTOTransferFundException {

		Response response = null;

		Integer fromaccountnumber = transferBalanceRequest.getFromAccountNumber();
		Integer toAccountnumber = transferBalanceRequest.getToAcccountNumber();
		BigDecimal amount = transferBalanceRequest.getAmount();
		BankAccountInfo fromAccount = repo.findByaccountNumber(fromaccountnumber);
		BankAccountInfo toAccount = repo.findByaccountNumber(toAccountnumber);
		if (fromAccount.getAvailableBalance().compareTo(BigDecimal.ONE) == 1
				&& fromAccount.getAvailableBalance().compareTo(amount) == 1) {
			fromAccount.setAvailableBalance(fromAccount.getAvailableBalance().subtract(amount));
			repo.save(fromAccount);
			toAccount.setAvailableBalance(toAccount.getAvailableBalance().add(amount));
			repo.save(toAccount);
			// Transaction transaction = transactionRepository.save(new
			// Transaction(0L,fromaccountnumber,amount,new
			// Timestamp(System.currentTimeMillis())));
			if (fromAccount != null && toAccount != null) {
				response = new Response();
				response.setSuccMsg("Successfully Transfer the money");
				response.setAccountNumber(toAccountnumber);
				response.setStatusCode(200);
				
			}
			else {
			throw new UnableTOTransferFundException("failed");

		}}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


		// Float SourceAccount1 = null;
//		Float DestinationAccount1 = null;
//		BankAccountInfo bankinfo1 = null;
//		BankAccountInfo bankinfo2 = null;
//		Response response = null;
////			try {
//		// Transferring the amount
//		bankinfo1 = repo.getByaccountNumber(SourceAccount);
//		bankinfo2 = repo.getByaccountNumber(DestinationAccount);
//		if (bankinfo1 != null && bankinfo2 != null) {
//			SourceAccount1 = bankinfo1.getAvailableBalance();
//			Float currentSourceAmount = SourceAccount1 - amount;
//			repo.save(currentSourceAmount);
//			DestinationAccount1 = bankinfo2.getAvailableBalance();
//			Float CurrentDestinationAmmount=DestinationAccount1+amount;
//			repo.save(CurrentDestinationAmmount);
//
//			if (currentSourceAmount != null && CurrentDestinationAmmount != null) {
//				response = new Response();
//				response.setSuccMsg("Succes ");
//			}
//			throw new UnableTOTransferFundException("unable to transfer" +currentSourceAmount +CurrentDestinationAmmount);
//
//		}
//		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	@Override
	public List<BankAccountInfo> getAllAccounts() {
		return repo.findAll();
	}

	

}