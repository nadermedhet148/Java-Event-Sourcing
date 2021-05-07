package com.user.Domain.User;

import com.user.Domain.Event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreatedEvent extends Event {
    private String username;

    private String userId;

    private Float balance;

    public JSONObject toJson(){
    JSONObject jb = new JSONObject();
    return jb;
    }
}
