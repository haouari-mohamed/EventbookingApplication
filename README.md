# Event Booking Application

## Introduction
This project is an Event Booking Web Application developed for managing event reservations. The application has features for both clients and administrators.

## Technologies Used
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- JUnit
- MySQL/PostgreSQL
- Docker

## Features

### For Clients
- **Home Page Data:** Retrieve event information to display on the home page.
- **Registration and Login:**
  - Manage new user registration (account creation).
  - Manage existing user login (authentication).
  - Retrieve and update user profile information.
- **Event Search and Filtering:** Search for events based on various criteria (date, location, category, etc.).
- **Event Booking:** Purchase event tickets.
- **Team and Values Information:** Retrieve information about the team and values to display on the "About" page.
- **Contact Management:** Receive and store contact requests sent via a contact form.

### For Administrators
- **Dashboard:** Retrieve data on client activities and events (registrations, purchases, etc.).
- **Account and Event Management:**
  - Manage client accounts (display, delete).
  - Manage events (create, update, delete, view details).
- **Contact Request Processing:** Receive, view, and respond to contact requests sent via the form.

## Setup and Installation

### Prerequisites
- Java 11 or later
- Maven
- MySQL/PostgreSQL
- Docker

### Clone the Repository
```sh
git clone https://github.com/your-repo/event-booking-app.git
cd event-booking-app
