package com.payment.Domain.Transaction;

import com.payment.Domain.Event.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Date;

@Setter
@Getter
public class TransactionCreatedEvent extends DomainEvent {
    private int transactionId;

    private String userId;

    private Float amount;

    private String type;

    public TransactionCreatedEvent(
            int transactionId,
            String userId,
            Float amount,
            String type
    ){
        this.setEntityName("Transaction");
        this.setEntityId(String.valueOf(transactionId));
        this.userId = userId;
        this.amount = amount;
        this.type = type;

    }


}
