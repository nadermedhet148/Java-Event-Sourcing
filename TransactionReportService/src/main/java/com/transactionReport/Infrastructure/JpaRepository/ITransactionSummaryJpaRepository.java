package com.transactionReport.Infrastructure.JpaRepository;

import com.transactionReport.Domain.Models.TransactionSummary.TransactionSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionSummaryJpaRepository extends JpaRepository<TransactionSummary, Integer> {
}
