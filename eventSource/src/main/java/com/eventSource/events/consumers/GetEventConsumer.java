package com.eventSource.events.consumers;

import com.eventSource.events.EVENTS;
import com.eventSource.models.Event;
import com.eventSource.repository.IEventRepository;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class GetEventConsumer extends EventConsumer  {
    @Autowired
    IEventRepository eventRepository;




    @Override
    public void eventConsume() throws IOException, TimeoutException {
        Channel channel = this.rmqBase.getChannel();

        channel.queueDeclare(EVENTS.EVENT_LIST, false, false, false, null);
        channel.queuePurge(EVENTS.EVENT_LIST);

        channel.basicQos(1);

        System.out.println(" [x] Awaiting RPC requests");

        Object monitor = new Object();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                    .Builder()
                    .correlationId(delivery.getProperties().getCorrelationId())
                    .build();
            String message = new String(delivery.getBody(), "UTF-8");
            String response = this.getEvents(message);

            try {
                System.out.println(" [.] fib(" + message + ")");

            } catch (RuntimeException e) {
                System.out.println(" [.] " + e.toString());
            } finally {
                channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps, response.getBytes("UTF-8"));
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                // RabbitMq consumer worker thread notifies the RPC server owner thread
                synchronized (monitor) {
                    monitor.notify();
                }
            }
        };

        channel.basicConsume(EVENTS.EVENT_LIST, false, deliverCallback, (consumerTag -> { }));
        // Wait and be prepared to consume the message from RPC client.
        while (true) {
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getEvents(String eventType){
        List<Event> events = this.eventRepository.findAll();
        JSONArray jsonArray = new JSONArray();
        events.forEach((event -> {
            jsonArray.put(event.toJson());
        }));
        System.out.println(events.size());
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
}
