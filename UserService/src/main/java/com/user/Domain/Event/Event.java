package com.user.Domain.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Event {
    private String entityName ;

    private Date createdAt;

    private String data;

    public abstract JSONObject toJson();

}
