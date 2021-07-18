package com.transactionReport.Domain.Services;

import com.transactionReport.Domain.Transaction.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TransactionService {

    private ITransactionRepository transactionRepository;


    public TransactionService(ITransactionRepository transactionRepository){
        this.transactionRepository= transactionRepository;
    }

    public Transaction createTransaction(CreateTransactionCommand cm) throws IOException, TimeoutException {

//        Transaction transaction = new Transaction();
//        TransactionCreatedEvent event = transaction.process(cm);
//        this.transactionRepository.save(transaction);
//        event.setTransactionId(transaction.getTransactionId());
//        this.publisher.publish(event);
        return null;
    }





}
