package com.transactionReport.Infrastructure.EventsStream;

import com.transactionReport.Domain.Event.DomainEvent;
import com.transactionReport.Domain.Models.TransactionSummary.CreateTransactionSummaryCommand;
import com.transactionReport.Domain.Services.TransactionSummaryService;
import io.reactivex.subjects.UnicastSubject;
import org.springframework.beans.factory.annotation.Autowired;


public class EventsStreamer {
    private UnicastSubject<DomainEvent> subject =  UnicastSubject.create();

    @Autowired
    TransactionSummaryService transactionSummaryService;

    public EventsStreamer(){
        subject.
                filter(ele-> ele != null).
                filter(ele-> ele instanceof CreateTransactionSummaryCommand).
                flatMap(ele  -> transactionSummaryService.createTransactionSummary((CreateTransactionSummaryCommand) ele)).
                forEach(ele-> System.out.println(ele));

    }




    public void publish (DomainEvent event) {
        this.subject.onNext(event);
    }


}
