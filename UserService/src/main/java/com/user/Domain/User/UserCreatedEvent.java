package com.user.Domain.User;

import com.user.Domain.Event.DomainEvent;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Date;

@Getter
@Setter
public class UserCreatedEvent extends DomainEvent {

    private String username;

    private Float balance;

    UserCreatedEvent(
            String username,
            String id,
            Float balance
    ){
        this.setEntityName("User");
        this.setEntityId(id);
        this.username = username;
        this.balance = balance;
        this.setData(this.toJson().toString());

    }

    public JSONObject toJson(){
    JSONObject jb = new JSONObject();
    jb.put("username" , username);
    jb.put("balance" , balance);
    return jb;
    }
}
