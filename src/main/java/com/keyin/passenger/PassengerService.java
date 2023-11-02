package com.keyin.passenger;

import com.keyin.airport.Airport;
import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftService;
import com.keyin.airport.AirportService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

@Service
public class PassengerService {
    private final AirportService airportService;
    private final AircraftService aircraftService;
    private List<Airport> airportList = new ArrayList<>();
    private List<PassengerEntity> passengers = new ArrayList<>();

    // Constructor injection for AirportService and AircraftService
    public PassengerService(AirportService airportService, AircraftService aircraftService) {
        this.airportService = airportService;
        this.aircraftService = aircraftService;
    }


    public PassengerEntity createPassenger(PassengerEntity passenger) {
        passengers.add(passenger);
        return passenger;
    }

    public List<PassengerEntity> getAllPassengers() {
        return passengers;
    }

    public PassengerEntity getPassengerById(int id) {
        for (PassengerEntity passenger : passengers) {
            if (passenger.getPassengerID() == id) {
                return passenger;
            }
        }
        return null;
    }

    public PassengerEntity updatePassenger(int id, PassengerEntity updatedPassenger) {
        for (PassengerEntity passenger : passengers) {
            if (passenger.getPassengerID() == id) {
                passenger.setFirstName(updatedPassenger.getFirstName());
                passenger.setLastName(updatedPassenger.getLastName());
                passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
                return passenger;
            }
        }
        return null;
    }

    public boolean deletePassenger(int id) {
        return passengers.removeIf(passenger -> passenger.getPassengerID() == id);
    }

    public List<Aircraft> getAircraftsByPassenger(int passengerId) {
        // Use the AircraftService to get the list of all aircraft
        List<Aircraft> allAircraft = aircraftService.getAllAircrafts();

        // Filter the list of all aircraft to only include those that have the passengerId in their passengerIds list
        return allAircraft.stream()
                .filter(aircraft -> aircraft.getPassengerIds().contains(passengerId))
                .collect(Collectors.toList());
    }

// In PassengerService.java

    public List<Airport> getAirportsByPassenger(int passengerId) {
        // Assuming PassengerEntity has a list of airport IDs they have used
        PassengerEntity passenger = getPassengerById(passengerId);
        if (passenger != null) {
            return passenger.getAirportIds().stream()
                    .map(airportService::getAirportById) // This method should be defined to find an airport by its ID
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
