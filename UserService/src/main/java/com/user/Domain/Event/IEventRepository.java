package com.user.Domain.Event;

public interface IEventRepository {
    public DomainEvent save(DomainEvent event);
}
