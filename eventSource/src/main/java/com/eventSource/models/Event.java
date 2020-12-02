package com.eventSource.models;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Event {
    @Id
    private String eventId;
    private String eventType;
    private String eventState;
    private Date createdDate = new Date();

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("event_status" , this.eventState);
        jsonObject.put("created_date" , this.createdDate);
        return jsonObject;
    }
}
