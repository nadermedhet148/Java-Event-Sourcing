package com.payment.Infrastructure.RepositoryImpl;

import com.payment.Domain.Event.DomainEvent;
import com.payment.Domain.Event.IEventRepository;
import com.payment.Domain.Transaction.ITransactionRepository;
import com.payment.Domain.Transaction.Transaction;
import com.payment.Infrastructure.JpaRepository.ITransactionJpaRepository;
import com.payment.Infrastructure.Mappers.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryImpl implements ITransactionRepository {
    @Autowired
    ITransactionJpaRepository transactionJpaRepository;

    @Override
    public Transaction save(Transaction transaction) {
        com.payment.Infrastructure.Entites.Transaction dbTransaction = TransactionMapper.INSTANCE.domainTransactionToTransaction(transaction);
        this.transactionJpaRepository.save(dbTransaction);
        transaction.setTransactionId(dbTransaction.getId());
        return transaction;
    }
}
