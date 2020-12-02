package com.eventSource.repository;

import com.eventSource.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEventRepository extends MongoRepository<Event, String> {
    List<Event> findByEventState(String eventType);

}