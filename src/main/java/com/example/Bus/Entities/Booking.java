package com.example.Bus.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "trip_id", nullable = false)
        private Trip trip;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private LocalDateTime bookingDate;

        @Enumerated(EnumType.STRING)
        private BookingStatus status;

        @OneToMany(mappedBy = "booking")
        private List<BookingSeat> bookingSeat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
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

    public List<BookingSeat> getBookingSeat() {
        return bookingSeat;
    }

    public void setBookingSeat(List<BookingSeat> bookingSeat) {
        this.bookingSeat = bookingSeat;
    }
}
