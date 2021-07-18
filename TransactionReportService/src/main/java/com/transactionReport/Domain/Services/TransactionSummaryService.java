package com.transactionReport.Domain.Services;

import com.transactionReport.Domain.Models.TransactionSummary.*;
import com.transactionReport.Domain.Models.User.IUserRepository;
import com.transactionReport.Domain.Models.User.User;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TransactionSummaryService {

    private ITransactionSummaryRepository transactionRepository;

    private IUserRepository userRepository;


    public TransactionSummaryService(ITransactionSummaryRepository transactionRepository,
                                     IUserRepository userRepository
    ){
        this.transactionRepository= transactionRepository;
        this.userRepository = userRepository;
    }

    public TransactionSummary createTransactionSummary(CreateTransactionSummaryCommand cm) throws IOException, TimeoutException {

        User user = this.userRepository.getUser(cm.getUserId());

        return null;
    }





}
