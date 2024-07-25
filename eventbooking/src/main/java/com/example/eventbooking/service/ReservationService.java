package com.example.eventbooking.service;

import com.example.eventbooking.exception.ResourceNotFoundException;
import com.example.eventbooking.model.Event;
import com.example.eventbooking.model.Reservation;
import com.example.eventbooking.repository.EventRepository;
import com.example.eventbooking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private EventRepository eventRepository;

    public Reservation createReservation(Reservation reservation) {
        Event event = eventRepository.findById(reservation.getEvent().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        if (event.getCapacity() > 0) {
            event.setCapacity(event.getCapacity() - 1);
            eventRepository.save(event);
            return reservationRepository.save(reservation);
        } else {
            throw new IllegalStateException("Event is fully booked");
        }
    }

    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public List<Reservation> getReservationsByEventId(Long eventId) {
        return reservationRepository.findByEventId(eventId);
    }
}
