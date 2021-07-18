package com.payment.Adapters.Messages;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.payment.Adapters.Messages.RMQ.RMQBase;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EventConsumer {
    RMQBase rmqBase = new RMQBase();

    public EventConsumer(){

    }

    public void consume(String EXCHANGE_NAME , DeliverCallback deliverCallback) throws IOException, TimeoutException {
        Channel channel = this.rmqBase.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME , BuiltinExchangeType.FANOUT);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }

    public void eventConsume() throws IOException, TimeoutException {
    }

}
