package com.user.Infrastructure.repository;

import com.user.Infrastructure.Entites.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventsRepo extends JpaRepository<Events, Integer> {
}
