package com.example.eventbooking.service;

import com.example.eventbooking.model.Dashboard;
import com.example.eventbooking.repository.EventRepository;
import com.example.eventbooking.repository.ReservationRepository;
import com.example.eventbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public Dashboard getDashboardData() {
        Dashboard dashboard = new Dashboard();
        dashboard.setData(String.format("Users: %d, Events: %d, Reservations: %d",
                userRepository.count(),
                eventRepository.count(),
                reservationRepository.count()));
        return dashboard;
    }
}
