package com.transactionReport.Infrastructure.JpaRepository;

import com.transactionReport.Domain.Transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionJpaRepository extends JpaRepository<Transaction, Integer> {
}
