package com.user.Domain.Services;

import com.user.Domain.Event.DomainEvent;
import com.user.Domain.Event.IEventPublisher;
import com.user.Domain.Event.IEventRepository;
import com.user.Domain.User.CreateUserCommand;
import com.user.Domain.User.ProcessTransactionCommand;
import com.user.Domain.User.User;
import com.user.Domain.User.UserCreatedEvent;

import java.io.IOException;
import java.util.List;
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

    public void processTransaction (ProcessTransactionCommand cm) throws IOException, TimeoutException {
        List<DomainEvent> userEvents =  this.eventRepository.getEntityEvents("User" , cm.getUserId());
        User user = new User();
        userEvents.forEach(event->{
            user.apply(event);
        });
        DomainEvent event = user.process(cm);
        this.publisher.publish(event);
        this.eventRepository.save(event);
    }

}
