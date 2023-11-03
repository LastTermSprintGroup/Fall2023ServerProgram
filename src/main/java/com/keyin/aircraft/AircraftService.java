package com.keyin.aircraft;

import com.keyin.airport.Airport;
import com.keyin.airport.AirportService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AircraftService {
    private List<Airport> airportList = new ArrayList<>();
    private List<Aircraft> aircraftList = new ArrayList<>();
    private final AirportService airportService;

    public AircraftService(AirportService airportService) {
        this.airportService = airportService;
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
        return aircraft;
    }

    public List<Aircraft> getAllAircrafts() {
        return aircraftList;
    }

    public Optional<Aircraft> getAircraftById(int id) {
        return aircraftList.stream().filter(a -> a.getID() == id).findFirst();
    }

    public Aircraft updateAircraft(int id, Aircraft updatedAircraft) {
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getID() == id) {
                aircraft.setModel(updatedAircraft.getModel());
                aircraft.setCapacity(updatedAircraft.getCapacity());
                return aircraft;
            }
        }
        return null;
    }

    public boolean deleteAircraft(int id) {
        return aircraftList.removeIf(aircraft -> aircraft.getID() == id);
    }

    public List<Airport> getAirportsByAircraft(int aircraftId) {
        // Use the AirportService to get the list of all airports
        List<Airport> allAirports = airportService.getAllAirports();

        // Filter the list of all airports to only include those that have the aircraftId in their aircraftIds list
        return allAirports.stream()
                .filter(airport -> airport.getAircraftIds() != null && airport.getAircraftIds().contains(aircraftId))
                .collect(Collectors.toList());
    }
}