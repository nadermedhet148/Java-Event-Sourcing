package com.payment.Domain.Services;

import com.payment.Domain.Event.IEventPublisher;
import com.payment.Domain.Event.IEventRepository;
import com.payment.Domain.Transaction.CreateTransactionCommand;
import com.payment.Domain.Transaction.ITransactionRepository;
import com.payment.Domain.Transaction.Transaction;
import com.payment.Domain.Transaction.TransactionCreatedEvent;

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

    public Transaction createTransaction(
    CreateTransactionCommand cm
    ) throws IOException, TimeoutException {
        Transaction transaction = new Transaction();
        TransactionCreatedEvent event = transaction.process(cm);
        this.transactionRepository.save(transaction);
        event.setTransactionId(transaction.getTransactionId());
        this.publisher.publish(event);
        return transaction;
    }





}
