package com.customer.events;

import com.customer.events.RMQ.RMQBase;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EventConsumer {
    RMQBase rmqBase = new RMQBase();

    public EventConsumer(){

    }

    public void consume(String QUEUE_NAME , DeliverCallback deliverCallback) throws IOException, TimeoutException {
        Channel channel = this.rmqBase.getChannel();
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }

}
