package com.example.eventbooking.repository;

import com.example.eventbooking.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCategory(String category);
    List<Event> findByDateBetween(Date start, Date end);

    List<Event> findByDateBetweenAndCategory(Date start, Date end, String category);
}
