package com.example.Bus.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "trip_id", nullable = false)
        private TripSchedule tripSchedule;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private LocalDateTime bookingDate;

        @Enumerated(EnumType.STRING)
        private BookingStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TripSchedule getTripSchedule() {
        return tripSchedule;
    }

    public void setTripSchedule(TripSchedule trip) {
        this.tripSchedule = tripSchedule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

}
