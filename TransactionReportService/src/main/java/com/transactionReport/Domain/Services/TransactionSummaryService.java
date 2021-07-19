package com.transactionReport.Domain.Services;

import com.transactionReport.Domain.Models.Transaction.ITransactionRepository;
import com.transactionReport.Domain.Models.Transaction.Transaction;
import com.transactionReport.Domain.Models.TransactionSummary.*;
import com.transactionReport.Domain.Models.User.IUserRepository;
import com.transactionReport.Domain.Models.User.User;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class TransactionSummaryService {

    private ITransactionSummaryRepository transactionSummaryRepository;

    private IUserRepository userRepository;
    private ITransactionRepository transactionRepository;


    public TransactionSummaryService(ITransactionSummaryRepository transactionSummaryRepository,
                                     IUserRepository userRepository,
                                     ITransactionRepository transactionRepository
    ){
        this.transactionSummaryRepository= transactionSummaryRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    public TransactionSummary createTransactionSummary(CreateTransactionSummaryCommand cm) throws IOException, TimeoutException {
        User user = this.userRepository.getUser(cm.getUserId());
        Transaction transaction = this.transactionRepository.getTransaction(cm.getTransactionId());
        TransactionSummary transactionSummary = new TransactionSummary();
        transactionSummary.setAmount(transaction.getAmount());
        transactionSummary.setStatus(transaction.getStatus());
        transactionSummary.setBalanceAfterTransaction(user.getBalance());
        transactionSummary.setUserId(user.getUserId());
        transactionSummary.setUsername(user.getUsername());
        transactionSummary.setStatus(transaction.getStatus());
        transactionSummary.setType(transaction.getType());
        transactionSummary.setTransactionId(transaction.getTransactionId());
        transactionSummary.setCreatedAt(new Date());
        this.transactionSummaryRepository.save(transactionSummary);
        return transactionSummary;
    }

    public List<TransactionSummary> list(){
        return  this.transactionSummaryRepository.list();
    }




}
