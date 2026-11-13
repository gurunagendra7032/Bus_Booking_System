package com.example.Bus.DTO;

import com.example.Bus.Entities.Seat;

import java.util.List;

public class BookingDTO {
    public int TripId;
    public List<Seat> seat;

    public int getTripId() {
        return TripId;
    }

    public void setTripId(int tripId) {
        TripId = tripId;
    }

    public List<Seat> getSeat() {
        return seat;
    }

    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }
}
