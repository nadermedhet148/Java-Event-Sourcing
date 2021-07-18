package com.transactionReport.Infrastructure.RepositoryImpl;

import com.transactionReport.Domain.Models.Transaction.ITransactionRepository;
import com.transactionReport.Domain.Models.Transaction.Transaction;
import com.transactionReport.Infrastructure.ServicesProxy.Transaction.ITransactionService;
import com.transactionReport.Infrastructure.ServicesProxy.Transaction.TransactionServiceProxy;

public class TransactionRepository implements ITransactionRepository {
    private ITransactionService proxy = new TransactionServiceProxy().getProxy();

    @Override
    public Transaction getTransaction(Integer id){
        Transaction user = proxy.getTransaction(id);
        return user;
    }
}
