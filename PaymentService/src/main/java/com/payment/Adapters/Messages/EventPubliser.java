package com.payment.Adapters.Messages;

import com.rabbitmq.client.Channel;
import com.payment.Adapters.Messages.RMQ.RMQBase;
import com.payment.Domain.Event.DomainEvent;
import com.payment.Domain.Event.IEventPublisher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@Service
public class EventPubliser implements IEventPublisher {
    RMQBase rmqBase = new RMQBase();

    public void publish(DomainEvent ev) throws IOException, TimeoutException {

       String QUEUE_NAME = ev.getClass().getName();
       String message = ev.toJson().toString();
        Channel channel = this.rmqBase.getChannel();
                    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
    }
}
