package com.example.eventbooking.controller;

import com.example.eventbooking.model.Dashboard;
import com.example.eventbooking.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<Dashboard> getDashboardData() {
        return ResponseEntity.ok(dashboardService.getDashboardData());
    }
}
