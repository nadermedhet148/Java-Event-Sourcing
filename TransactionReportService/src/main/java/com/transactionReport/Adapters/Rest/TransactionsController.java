package com.transactionReport.Adapters.Rest;

import com.transactionReport.Adapters.Rest.requests.CreatePaymentRequest;
import com.transactionReport.Infrastructure.RepositoryImpl.TransactionSummaryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value = "/transactions")

public class TransactionsController {




    @Autowired
    TransactionSummaryRepositoryImpl transactionSummaryRepository;

//    @PostMapping(value = "")
//    public Transaction createTransaction(@RequestBody CreatePaymentRequest body) throws IOException, TimeoutException {
//        return nu;
//    }

}
