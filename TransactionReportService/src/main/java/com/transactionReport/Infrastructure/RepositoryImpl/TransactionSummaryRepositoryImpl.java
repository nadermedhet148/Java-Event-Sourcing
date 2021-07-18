package com.transactionReport.Infrastructure.RepositoryImpl;

import com.transactionReport.Domain.Models.TransactionSummary.ITransactionSummaryRepository;
import com.transactionReport.Domain.Models.TransactionSummary.TransactionSummary;
import com.transactionReport.Infrastructure.JpaRepository.ITransactionSummaryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionSummaryRepositoryImpl implements ITransactionSummaryRepository {
    @Autowired
    ITransactionSummaryJpaRepository transactionSummaryJpaRepository;

    @Override
    public TransactionSummary save(TransactionSummary transaction) {
        this.transactionSummaryJpaRepository.save(transaction);
        return transaction;
    }


}
