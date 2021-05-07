package com.user.Infrastructure.RepositoryImpl;

import com.user.Domain.Event.DomainEvent;
import com.user.Domain.Event.IEventRepository;
import com.user.Infrastructure.Entites.Event;
import com.user.Infrastructure.JpaRepository.IEventJpaRepository;
import com.user.Infrastructure.Mappers.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventRepositoryImpl implements IEventRepository {
    @Autowired
    IEventJpaRepository eventJpaRepository;

    @Override
    public DomainEvent save(DomainEvent event) {
        Event ev =  EventMapper.INSTANCE.domainEventToEvent(event);
        this.eventJpaRepository.save(ev);
        return event;
    }
}
