package com.eventSource.repository;

import com.eventSource.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEventRepository extends MongoRepository<Event, String> {
}