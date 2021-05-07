package com.payment.Domain.Event;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Date;

@Getter
@Setter
public abstract class DomainEvent {
    private String entityName ;

    private String entityId ;

    private Date createdAt = new Date();

    private String data;

    public abstract JSONObject toJson();

}
