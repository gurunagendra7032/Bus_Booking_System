package com.example.Bus.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class BusCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String BusComapnyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull String getBusComapnyName() {
        return BusComapnyName;
    }

    public void setBusComapnyName(@NotNull String busComapnyName) {
        BusComapnyName = busComapnyName;
    }
}
