package com.develhope.ApiCustom02.controllers;

import com.develhope.ApiCustom02.entities.Flight;
import com.develhope.ApiCustom02.enums.StatusEnum;
import com.develhope.ApiCustom02.repositories.FlightRepository;
import com.develhope.ApiCustom02.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/generaterandom")
    public ResponseEntity<List<Flight>> generateFlights(@RequestParam Integer number) {
        List<Flight> flights = flightService.generateFlights(number);
        return ResponseEntity.ok(flights);
    }


    @GetMapping("/viewlist")
    public ResponseEntity<List<Flight>> provisionFlights(@RequestParam Integer number) {
        List<Flight> flights = flightService.generateFlights(number);
        return ResponseEntity.ok(flights);
    }


@GetMapping("/p1orp2")
public ResponseEntity<List<Flight>> p1OrP2Flights() {
    List<Flight> flightsOnTime = flightService.findByDoubleStatus(StatusEnum.P1, StatusEnum.P2);
    return ResponseEntity.ok(flightsOnTime);
}


@GetMapping("/ontime")
public ResponseEntity<List<Flight>> ontimeFlights() {
    List<Flight> flightsOnTime = flightService.findBySingleStatus(StatusEnum.ONTIME);
    return ResponseEntity.ok(flightsOnTime);
}


    @GetMapping("/pagination")
    public Page<Flight> getAllFlights(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return flightRepository.findAll(PageRequest.of(page, size, Sort.by("fromAirport").ascending()));
    }
}
