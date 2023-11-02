package com.keyin.airport;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AirportService {

    private List<Airport> airportList = new ArrayList<>();

    public Airport createAirport(Airport airport) {
        airportList.add(airport);
        return airport;
    }

    public List<Airport> getAllAirports() {
        return airportList;
    }

    public Airport getAirportById(int id) {
        for (Airport airport : airportList) {
            if (airport.getId() == id) {
                return airport;
            }
        }
        return null;
    }

    public Airport updateAirport(int id, Airport updatedAirport) {
        for (Airport airport : airportList) {
            if (airport.getId() == id) {
                airport.setName(updatedAirport.getName());
                airport.setCode(updatedAirport.getCode());
                return airport;
            }
        }
        return null;
    }

    public boolean deleteAirport(int id) {
        return airportList.removeIf(airport -> airport.getId() == id);
    }

    public List<Airport> getAirportsByCity(int cityId) {
        // Filter the list of airports by the cityId
        return airportList.stream()
                .filter(airport -> airport.getCityId() == cityId)
                .collect(Collectors.toList());
    }
}