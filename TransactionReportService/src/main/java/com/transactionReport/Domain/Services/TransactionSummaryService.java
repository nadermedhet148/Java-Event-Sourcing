package com.transactionReport.Domain.Services;

import com.transactionReport.Domain.Models.TransactionSummary.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TransactionSummaryService {

    private ITransactionSummaryRepository transactionRepository;


    public TransactionSummaryService(ITransactionSummaryRepository transactionRepository){
        this.transactionRepository= transactionRepository;
    }

    public TransactionSummary createTransactionSummary(CreateTransactionSummaryCommand cm) throws IOException, TimeoutException {

//        Transaction transaction = new Transaction();
//        TransactionCreatedEvent event = transaction.process(cm);
//        this.transactionRepository.save(transaction);
//        event.setTransactionId(transaction.getTransactionId());
//        this.publisher.publish(event);
        return null;
    }





}
