package com.example.eventbooking.service;

import com.example.eventbooking.exception.ResourceNotFoundException;
import com.example.eventbooking.model.Event;
import com.example.eventbooking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        event.setName(eventDetails.getName());
        event.setDate(eventDetails.getDate());
        event.setLocation(eventDetails.getLocation());
        event.setCategory(eventDetails.getCategory());
        event.setCapacity(eventDetails.getCapacity());
        event.setPrice(eventDetails.getPrice());
        return eventRepository.save(event);
    }
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> searchEvents(String category, Date start, Date end) {
        if (category != null && start != null && end != null) {
            return eventRepository.findByDateBetweenAndCategory(start, end, category);
        } else if (start != null && end != null) {
            return eventRepository.findByDateBetween(start, end);
        } else if (category != null) {
            return eventRepository.findByCategory(category);
        }
        return getAllEvents();
    }
}