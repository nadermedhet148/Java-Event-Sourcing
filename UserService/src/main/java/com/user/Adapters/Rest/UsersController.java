package com.user.Adapters.Rest;

import com.user.Adapters.Messages.EventPubliser;
import com.user.Adapters.Rest.requests.CreateUserRequest;
import com.user.Domain.Event.IEventRepository;
import com.user.Domain.Services.UserService;
import com.user.Domain.User.CreateUserCommand;
import com.user.Domain.User.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value = "/users")

public class UsersController {

    @Autowired
    IEventRepository eventRepository;

    @Autowired
    EventPubliser eventPubliser;


    @PostMapping(value = "")
    public String createUser(@RequestBody CreateUserRequest body) throws  IOException, TimeoutException {
        CreateUserCommand cm = new CreateUserCommand(body.getUsername());
        UserService service = new UserService(eventPubliser , eventRepository);
        UserCreatedEvent event = service.createUser(cm);
        return event.toJson().toString();
    }

}
