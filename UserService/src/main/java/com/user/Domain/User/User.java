package com.user.Domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private String username;

    private String userId;

    private Float balance;

    public UserCreatedEvent process(CreateUserCommand cm){
        UUID userId =  UUID.randomUUID();
        UserCreatedEvent event = new UserCreatedEvent(
                cm.getUsername() ,
                userId.toString(),
                0f
                );
        return  event;
    }

    public void apply(UserCreatedEvent ev) {
        this.userId = ev.getUserId();
        this.username = ev.getUsername();
        this.balance = ev.getBalance();
    }

}
