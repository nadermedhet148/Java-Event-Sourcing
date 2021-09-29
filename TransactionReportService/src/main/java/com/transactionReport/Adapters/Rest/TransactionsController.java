package com.transactionReport.Adapters.Rest;

import com.transactionReport.Adapters.Rest.requests.CreatePaymentRequest;
import com.transactionReport.Domain.Models.TransactionSummary.ITransactionSummaryRepository;
import com.transactionReport.Domain.Models.TransactionSummary.TransactionSummary;
import com.transactionReport.Domain.Services.TransactionSummaryService;
import com.transactionReport.Infrastructure.RepositoryImpl.TransactionRepository;
import com.transactionReport.Infrastructure.RepositoryImpl.TransactionSummaryRepositoryImpl;
import com.transactionReport.Infrastructure.RepositoryImpl.UserRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value = "/transaction-summaries")

public class TransactionsController {

    @Autowired
    TransactionSummaryService transactionSummaryService;




    @Autowired
    TransactionSummaryRepositoryImpl transactionSummaryRepository;

    @GetMapping(value = "")
    public Observable<List<TransactionSummary>> listTransactionSummaries() throws IOException, TimeoutException {
        return transactionSummaryService.list();
    }

}
