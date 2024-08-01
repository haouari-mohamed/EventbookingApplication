// admin-dashboard.component.ts
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { EventService } from '../../services/event.service';
import { User } from '../../models/user.model';
import { Event } from '../../models/event.model';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  users: User[] = [];
  events: Event[] = [];

  constructor(private userService: UserService, private eventService: EventService) { }

  ngOnInit() {
    /* this.userService.getAllUsers().subscribe({
      next: (users: User[]) => {
        this.users = users;
      },
      error: (error: any) => {
        console.error('Error fetching users', error);
      }
    }); */

    this.eventService.getAllEvents().subscribe({
      next: (events: Event[]) => {
        this.events = events;
      },
      error: (error: any) => {
        console.error('Error fetching events', error);
      }
    });
  }

  createEvent(event: Event) {
    this.eventService.createEvent(event).subscribe({
      next: (newEvent: Event) => {
        this.events.push(newEvent);
      },
      error: (error: any) => {
        console.error('Error creating event', error);
      }
    });
  }

  deleteEvent(eventId: number) {
    this.eventService.deleteEvent(eventId).subscribe({
      next: () => {
        this.events = this.events.filter(e => e.id !== eventId);
      },
      error: (error: any) => {
        console.error('Error deleting event', error);
      }
    });
  }
}
