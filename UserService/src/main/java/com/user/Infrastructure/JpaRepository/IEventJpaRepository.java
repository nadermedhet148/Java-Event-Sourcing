package com.user.Infrastructure.JpaRepository;

import com.user.Infrastructure.Entites.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventJpaRepository extends JpaRepository<Event, Integer> {
}
