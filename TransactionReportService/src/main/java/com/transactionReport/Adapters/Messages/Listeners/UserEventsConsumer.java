package com.transactionReport.Adapters.Messages.Listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transactionReport.Adapters.Messages.EventConsumer;
import com.transactionReport.Domain.Event.DomainEvent;
import com.transactionReport.Domain.Models.TransactionSummary.CreateTransactionSummaryCommand;
import com.transactionReport.Domain.Models.TransactionSummary.ITransactionSummaryRepository;
import com.rabbitmq.client.DeliverCallback;
import com.transactionReport.Domain.Services.TransactionSummaryService;
import com.transactionReport.Infrastructure.EventsStream.EventsStreamer;
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
    @Autowired
    EventsStreamer streamer;
    @Autowired
    TransactionSummaryService service;


    @Override
    @Transactional
    public void eventConsume() throws IOException, TimeoutException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String messageBody = new String(delivery.getBody(), "UTF-8");
                streamer.publish(messageToEvent(messageBody));
                System.out.println(" [x] Received '" + messageBody + "'");
        };
        this.consume("User",deliverCallback);
    }

    public DomainEvent messageToEvent(String messageBody){
        JSONObject json = new JSONObject(messageBody);

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            switch (json.getString("eventType")){
                case "TransactionSucceed" :
                case "TransactionFailed" :
                        return objectMapper.readValue(messageBody , CreateTransactionSummaryCommand.class );

            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
