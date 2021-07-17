package com.transactionReport.Adapters.Messages.Listeners;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transactionReport.Adapters.Messages.EventConsumer;
import com.transactionReport.Domain.Services.TransactionService;
import com.transactionReport.Domain.Transaction.CreateTransactionCommand;
import com.transactionReport.Domain.Transaction.ITransactionRepository;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class UserEventsConsumer extends EventConsumer {

    @Autowired
    ITransactionRepository transactionRepository;



    @Override
    @Transactional
    public void eventConsume() throws IOException, TimeoutException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String messageBody = new String(delivery.getBody(), "UTF-8");
            JSONObject json = new JSONObject(messageBody);
            TransactionService service = new TransactionService(transactionRepository);
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            switch (json.getString("eventType")){
                case "TransactionSucceed" :
                case "TransactionFailed" :
                    try {
                        service.createTransaction(objectMapper.readValue(messageBody , CreateTransactionCommand.class ));
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
