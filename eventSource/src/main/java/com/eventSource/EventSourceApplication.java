package com.eventSource;

import com.eventSource.events.consumers.EventConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class EventSourceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EventSourceApplication.class, args);
		EventConsumer userCreatedConsumer = (EventConsumer) context.getBean("createdEvent");
		List<EventConsumer> consumers = Arrays.asList(userCreatedConsumer);
		consumers.forEach(c->{
			try {
				c.eventConsume();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}

		});
	}

}
