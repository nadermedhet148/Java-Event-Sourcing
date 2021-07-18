package com.transactionReport.Adapters.Messages.Listeners;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transactionReport.Adapters.Messages.EventConsumer;
import com.transactionReport.Domain.Services.TransactionSummaryService;
import com.transactionReport.Domain.Models.TransactionSummary.CreateTransactionSummaryCommand;
import com.transactionReport.Domain.Models.TransactionSummary.ITransactionSummaryRepository;
import com.rabbitmq.client.DeliverCallback;
import com.transactionReport.Infrastructure.RepositoryImpl.TransactionRepository;
import com.transactionReport.Infrastructure.RepositoryImpl.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class UserEventsConsumer extends EventConsumer {

    @Autowired
    ITransactionSummaryRepository transactionRepository;



    @Override
    @Transactional
    public void eventConsume() throws IOException, TimeoutException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String messageBody = new String(delivery.getBody(), "UTF-8");
            JSONObject json = new JSONObject(messageBody);
            TransactionSummaryService service = new TransactionSummaryService(transactionRepository , new UserRepository(), new TransactionRepository());
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            switch (json.getString("eventType")){
                case "TransactionSucceed" :
                case "TransactionFailed" :
                    try {
                        service.createTransactionSummary(objectMapper.readValue(messageBody , CreateTransactionSummaryCommand.class ));
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                    return;
            }

            System.out.println(" [x] Received '" + messageBody + "'");
        };

        this.consume("User",deliverCallback);
    }

}
