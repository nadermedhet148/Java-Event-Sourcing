package com.transactionReport.Domain.Models.Transaction;


public interface ITransactionRepository {
    Transaction getTransaction(Integer id);
}
