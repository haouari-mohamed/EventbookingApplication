import { Component, OnInit } from '@angular/core';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-event-management',
  templateUrl: './event-management.component.html',
  styleUrls: ['./event-management.component.css']
})
export class EventManagementComponent implements OnInit {
  events: any[] = [];

  constructor(private eventService: EventService) { }

  ngOnInit() {
    this.eventService.getAllEvents().subscribe(events => {
      this.events = events;
    }, error => {
      console.error('Error fetching events', error);
    });
  }

  searchEvents(category: string, start: Date, end: Date) {
    this.eventService.searchEvents(category, start, end).subscribe(events => {
      this.events = events;
    }, error => {
      console.error('Error searching events', error);
    });
  }
}
