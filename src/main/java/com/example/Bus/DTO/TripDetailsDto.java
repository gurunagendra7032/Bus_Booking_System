package com.example.Bus.DTO;

import com.example.Bus.Entities.Bus;
import com.example.Bus.Entities.BusCompany;

public class TripDetailsDto {

    public Bus busId;
    public BusCompany busCompany;
    public Integer tripId;

    public Bus getBusId() {
        return busId;
    }

    public void setBusId(Bus busId) {
        this.busId = busId;
    }

    public BusCompany getBusCompany() {
        return busCompany;
    }

    public void setBusCompany(BusCompany busCompany) {
        this.busCompany = busCompany;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }
}
