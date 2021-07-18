package com.transactionReport.Infrastructure.ServicesProxy.Transaction;

import com.transactionReport.Domain.Models.Transaction.Transaction;
import com.transactionReport.Domain.Models.User.User;
import feign.Param;
import feign.RequestLine;

public interface ITransactionService {
    @RequestLine("GET /{id}")
    Transaction getTransaction(@Param("id") Integer id);


}
