package com.payment.Infrastructure.RepositoryImpl;

import com.payment.Domain.Event.DomainEvent;
import com.payment.Domain.Event.IEventRepository;
import com.payment.Domain.Transaction.ITransactionRepository;
import com.payment.Domain.Transaction.Transaction;
import com.payment.Infrastructure.JpaRepository.ITransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryImpl implements ITransactionRepository {
    @Autowired
    ITransactionJpaRepository transactionJpaRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return null;
    }
}
