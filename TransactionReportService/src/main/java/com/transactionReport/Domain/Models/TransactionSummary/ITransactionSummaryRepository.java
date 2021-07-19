package com.transactionReport.Domain.Models.TransactionSummary;

import java.util.List;

public interface ITransactionSummaryRepository {
    public TransactionSummary save(TransactionSummary transaction);

    public List<TransactionSummary> list();

}
