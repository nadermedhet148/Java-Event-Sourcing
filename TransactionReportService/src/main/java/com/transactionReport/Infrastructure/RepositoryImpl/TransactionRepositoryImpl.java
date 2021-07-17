package com.transactionReport.Infrastructure.RepositoryImpl;

import com.transactionReport.Domain.Transaction.ITransactionRepository;
import com.transactionReport.Domain.Transaction.Transaction;
import com.transactionReport.Infrastructure.JpaRepository.ITransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionRepositoryImpl implements ITransactionRepository {
    @Autowired
    ITransactionJpaRepository transactionJpaRepository;

    @Override
    public Transaction save(Transaction transaction) {
        this.transactionJpaRepository.save(transaction);
        return transaction;
    }


}
