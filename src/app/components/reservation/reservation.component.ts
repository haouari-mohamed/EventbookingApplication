import { Component } from '@angular/core';
import { ReservationService } from '../../services/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {
  constructor(private reservationService: ReservationService) { }

  createReservation(reservation: any) {
    this.reservationService.createReservation(reservation).subscribe(newReservation => {
      console.log('Reservation successful', newReservation);
    }, error => {
      console.error('Error creating reservation', error);
    });
  }
}
