package com.example.eventbooking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date date;
    private String location;
    private String category;
    private int capacity;
    private Double price;

    @OneToMany(mappedBy = "event")
    private List<Reservation> reservations;

}