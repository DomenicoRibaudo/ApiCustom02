package com.develhope.ApiCustom02.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String description;

    private String fromAirport;

    private String toAirport;

    private Enum StatusEnum;

    public Flight() {
    }

    public Flight(String description, String fromAirport, String toAirport, Enum RecordStatusEnum) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.StatusEnum = RecordStatusEnum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Enum getStatusEnum() {
        return StatusEnum;
    }

    public void setStatusEnum(Enum statusEnum) {
        StatusEnum = statusEnum;
    }
}
