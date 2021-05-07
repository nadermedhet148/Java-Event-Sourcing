package com.payment.Domain.Services;

import com.payment.Domain.Event.IEventPublisher;
import com.payment.Domain.Event.IEventRepository;
import com.payment.Domain.Transaction.ITransactionRepository;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TransactionService {

    private  IEventPublisher publisher;
    private ITransactionRepository transactionRepository;


    public TransactionService(IEventPublisher publisher,
                              ITransactionRepository transactionRepository){
        this.publisher = publisher;
        this.transactionRepository= transactionRepository;
    }



}
