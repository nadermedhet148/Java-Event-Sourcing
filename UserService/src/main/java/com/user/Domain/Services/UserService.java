package com.user.Domain.Services;

import com.user.Domain.Event.IEventPublisher;
import com.user.Domain.Event.IEventRepository;
import com.user.Domain.User.CreateUserCommand;
import com.user.Domain.User.User;
import com.user.Domain.User.UserCreatedEvent;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class UserService {

    private  IEventPublisher publisher;
    private IEventRepository eventRepository;


    public UserService(IEventPublisher publisher,
                       IEventRepository eventRepository){
        this.publisher = publisher;
        this.eventRepository= eventRepository;
    }


    public UserCreatedEvent createUser (CreateUserCommand cm) throws IOException, TimeoutException {
        User user = new User();
        UserCreatedEvent ev =  user.process(cm);
        this.publisher.publish(ev);
        this.eventRepository.save(ev);
        return ev;
    }

}
