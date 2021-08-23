package com.learn.training.FundTransfer.Controller;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.training.FundTransfer.Exceptions.UnableTOTransferFundException;
import com.learn.training.FundTransfer.Model.BankAccountInfo;
import com.learn.training.FundTransfer.Model.Response;
import com.learn.training.FundTransfer.Model.TransferBalanceRequest;
import com.learn.training.FundTransfer.Service.FundTransferringService;


@RestController
public class FundTransferController {
	
	@Autowired
	FundTransferringService service;

@RequestMapping(value="/CreateBankAccountInfo",method=RequestMethod.POST)
public ResponseEntity<BankAccountInfo> create(@RequestBody BankAccountInfo accountinfo) {
   BankAccountInfo BAI= service.save(accountinfo);
    return ResponseEntity.status(HttpStatus.CREATED).body(BAI);
}

@RequestMapping(value="/GetAllBankAccountDetails",method=RequestMethod.GET)

public ResponseEntity<List<BankAccountInfo>> getAllAccountDetails(){
	List<BankAccountInfo> getaccounts=service.getAllAccounts();
	return  ResponseEntity.status(HttpStatus.OK).body(getaccounts);
	}
//@RequestMapping(value="/TransferMoney/{FromAccountNumber}/{ToAcccountNumber}",method=RequestMethod.PUT)
//public ResponseEntity<ResponseEntity<Response>> TransferMoney(@PathVariable Integer FromAccountNumber  ,
//		@PathVariable Integer ToAccountNumber ,@RequestBody
//		TransferBalanceRequest transferblancerequest) throws UnableTOTransferFundException{
//	ResponseEntity<Response> request=service.TransferBalanceRequest(transferblancerequest);
//			return ResponseEntity.status(HttpStatus.OK).body(request);
//}
	
@PutMapping("/sendmoney")
public ResponseEntity<ResponseEntity<Response>> SendMoney(
        @RequestBody TransferBalanceRequest transferBalanceRequest
        ) throws UnableTOTransferFundException {

            ResponseEntity<Response> transfer=service.TransferBalanceRequest(
                    transferBalanceRequest
            );
			return ResponseEntity.status(HttpStatus.OK).body(transfer);
    
}

}

