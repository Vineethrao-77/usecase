package com.learn.training.FundTransfer.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.training.FundTransfer.Exceptions.UnableTOTransferFundException;
import com.learn.training.FundTransfer.Model.BankAccountInfo;
import com.learn.training.FundTransfer.Model.Response;
import com.learn.training.FundTransfer.Model.TransferBalanceRequest;
@Service
public interface FundTransferringService{
//public ResponseEntity<Response>  fundTransfer(Integer SourceAccount,Float amount,Integer DestinationAccount) throws UnableTOTransferFundException;


public ResponseEntity<Response> TransferBalanceRequest (TransferBalanceRequest transferBalanceRequest) 
		throws UnableTOTransferFundException;

public BankAccountInfo save(BankAccountInfo accountinfo);

public List<BankAccountInfo> getAllAccounts();


}