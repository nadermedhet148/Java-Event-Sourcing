package com.transactionReport.Infrastructure.ServicesProxy.Transaction;

import feign.Feign;
import feign.gson.GsonDecoder;

public class TransactionServiceProxy {

    private ITransactionService transactionService = Feign.builder()
            .decoder(new GsonDecoder())
            .target(ITransactionService.class, "http://localhost:8100/transactions");

    public ITransactionService getProxy(){
        return transactionService;
    }
}
