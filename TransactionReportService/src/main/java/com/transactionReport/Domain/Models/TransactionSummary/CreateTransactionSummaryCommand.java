package com.transactionReport.Domain.Models.TransactionSummary;

import com.transactionReport.Domain.Event.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateTransactionSummaryCommand extends DomainEvent {
    private String userId;

    private Integer transactionId;


}
