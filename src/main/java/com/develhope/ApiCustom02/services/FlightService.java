package com.develhope.ApiCustom02.services;

import com.develhope.ApiCustom02.entities.Flight;
import com.develhope.ApiCustom02.enums.StatusEnum;
import com.develhope.ApiCustom02.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    List<Flight> flights = new ArrayList<>();


    /**
 * Generates a list of flights with random properties.
 *
 * @param index the number of flights to generate. If null or 0, 100 flights will be generated.
 * @return a list of flights with random properties
 */
public List<Flight> generateFlights(Integer index) {
    Random random = new Random();
    if (index == null || index == 0) {
        index = 100;
    }
    for (int i = 0; i < index; i++) {
        Flight flight = new Flight();
        flight.setDescription("Flight " + random.nextInt(1000));
        flight.setFromAirport("Airport " + random.nextInt(100));
        flight.setToAirport("Airport " + random.nextInt(100));
        flight.setStatusEnum(StatusEnum.values()[random.nextInt(StatusEnum.values().length)]);
        flights.add(flight);
        flightRepository.saveAndFlush(flight);
    }
    return flights;
}


    /**
 * Returns a list of flights that have the specified status.
 *
 * @param enumToFind the status to search for
 * @return a list of flights with the specified status
 */
public List<Flight> findBySingleStatus(StatusEnum enumToFind) {
    List<Flight> flightsWithStatus = new ArrayList<>();
    for (Flight flights : flights) {
        if (flights.getStatusEnum() == enumToFind) {
            flightsWithStatus.add(flights);
        }
    }
    return flightsWithStatus;
}

    /**
 * Returns a list of flights that have the specified status.
 *
 * @param enumToFind the status to search for (x2)
 * @return a list of flights with the specified status
 */
public List<Flight> findByDoubleStatus(StatusEnum enumToFind, StatusEnum enumToFind2) {
    List<Flight> flightsWithStatus = new ArrayList<>();
    for (Flight flights : flights) {
        if (flights.getStatusEnum() == enumToFind || flights.getStatusEnum() == enumToFind2) {
            flightsWithStatus.add(flights);
        }
    }
    return flightsWithStatus;
}
}
