package com.user.Infrastructure.JpaRepository;

import com.user.Infrastructure.Entites.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventJpaRepository extends JpaRepository<Events, Integer> {
}
