package com.example.eventbooking.controller;

import com.example.eventbooking.model.Event;
import com.example.eventbooking.model.Reservation;
import com.example.eventbooking.service.EventService;
import com.example.eventbooking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private ReservationService reservationService;

//    @PostMapping
//    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
//        return ResponseEntity.ok(eventService.createEvent(event));
//    }
    @PostMapping("/{eventId}/book")
    public ResponseEntity<?> bookEvent(@PathVariable Long eventId, @RequestBody Reservation reservation) {
        Event event = eventService.getEventById(eventId);
        reservation.setEvent(event);
        Reservation savedReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok(savedReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.updateEvent(id, event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam(required = false) String category,
                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        return ResponseEntity.ok(eventService.searchEvents(category, start, end));
    }
}
