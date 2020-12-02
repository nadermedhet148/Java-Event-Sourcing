package com.eventSource.events.consumers;


import com.eventSource.events.EVENTS;
import com.eventSource.models.Event;
import com.eventSource.repository.IEventRepository;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class CreatedEvent extends EventConsumer {

    @Autowired
    IEventRepository eventRepository;




    @Override
    public void eventConsume() throws IOException, TimeoutException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String messageBody = new String(delivery.getBody(), "UTF-8");
            Event event = this.createEvent(messageBody);
            System.out.println(" [x] Received '" + messageBody + "'");
        };

        this.consume(EVENTS.EVENT_CREATED,deliverCallback);
    }

    private Event createEvent(String messageBody){
        JSONObject json = new JSONObject(messageBody);
        Event event = new Event();
        event.setEventState(messageBody);
        event.setEventState(json.getString("event_type"));
        this.eventRepository.save(event);
        return event;
    }
}
