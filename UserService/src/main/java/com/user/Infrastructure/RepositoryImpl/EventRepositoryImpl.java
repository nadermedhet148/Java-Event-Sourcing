package com.user.Infrastructure.RepositoryImpl;

import com.user.Domain.Event.Event;
import com.user.Domain.Event.IEventRepository;
import com.user.Infrastructure.JpaRepository.IEventJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventRepositoryImpl implements IEventRepository {
    @Autowired
    IEventJpaRepository eventJpaRepository;

    @Override
    public Event save(Event event) {
        return null;
    }
}
