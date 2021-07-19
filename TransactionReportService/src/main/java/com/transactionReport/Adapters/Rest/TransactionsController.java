package com.transactionReport.Adapters.Rest;

import com.transactionReport.Adapters.Rest.requests.CreatePaymentRequest;
import com.transactionReport.Domain.Models.TransactionSummary.ITransactionSummaryRepository;
import com.transactionReport.Domain.Models.TransactionSummary.TransactionSummary;
import com.transactionReport.Domain.Services.TransactionSummaryService;
import com.transactionReport.Infrastructure.RepositoryImpl.TransactionRepository;
import com.transactionReport.Infrastructure.RepositoryImpl.TransactionSummaryRepositoryImpl;
import com.transactionReport.Infrastructure.RepositoryImpl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value = "/transaction-summaries")

public class TransactionsController {

    @Autowired
    ITransactionSummaryRepository transactionRepository;



    @Autowired
    TransactionSummaryRepositoryImpl transactionSummaryRepository;

    @GetMapping(value = "")
    public List<TransactionSummary> listTransactionSummaries() throws IOException, TimeoutException {

        TransactionSummaryService service = new TransactionSummaryService(transactionRepository , new UserRepository(), new TransactionRepository());
        return service.list();
    }

}
