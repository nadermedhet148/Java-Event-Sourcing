package com.transactionReport;

import com.transactionReport.Adapters.Messages.EventConsumer;
import com.transactionReport.Adapters.Messages.Listeners.UserEventsConsumer;
import com.transactionReport.Domain.Models.TransactionSummary.ITransactionSummaryRepository;
import com.transactionReport.Domain.Services.TransactionSummaryService;
import com.transactionReport.Infrastructure.EventsStream.EventsStreamer;
import com.transactionReport.Infrastructure.RepositoryImpl.TransactionRepository;
import com.transactionReport.Infrastructure.RepositoryImpl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class TransactionReportApplication {

	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(TransactionReportApplication.class, args);
		EventConsumer userEventsConsumer = (UserEventsConsumer) context.getBean("userEventsConsumer");

		List<EventConsumer> consumers = Arrays.asList(userEventsConsumer);
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

	@Autowired
	ITransactionSummaryRepository transactionRepository;

	@Bean
	public EventsStreamer eventsStreamer() {
		return new EventsStreamer();
	}
	@Bean
	public TransactionSummaryService transactionSummaryService(){
		return new TransactionSummaryService(transactionRepository , new UserRepository(), new TransactionRepository());

	}



}
