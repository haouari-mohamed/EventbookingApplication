import { Component, OnInit } from '@angular/core';
import { ContactService } from '../../services/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contacts: any[] = [];

  constructor(private contactService: ContactService) { }

  ngOnInit() {
    this.contactService.getAllContacts().subscribe(contacts => {
      this.contacts = contacts;
    }, error => {
      console.error('Error fetching contacts', error);
    });
  }

  createContact(contact: any) {
    this.contactService.createContact(contact).subscribe(newContact => {
      this.contacts.push(newContact);
    }, error => {
      console.error('Error creating contact', error);
    });
  }
}
