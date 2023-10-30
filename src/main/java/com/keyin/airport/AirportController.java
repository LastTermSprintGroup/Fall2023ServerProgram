package com.keyin.airport;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private List<Airport> airportList = new ArrayList<>();

    // List all airports
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportList;
    }

    // Get a specific airport by ID
    @GetMapping("/{airportId}")
    public Airport getAirportById(@PathVariable int airportId) {
        // Find and return the airport with the specified ID
        for (Airport airport : airportList) {
            if (airport.getId() == airportId) {
                return airport;
            }
        }
        // Handle not found
        return null; // You can customize the response for a not found airport
    }

    // Create a new airport
    @PostMapping
    public void createAirport(@RequestBody Airport newAirport) {
        // Add the new airport to the list
        airportList.add(newAirport);
    }

    // Update a specific airport by ID
    @PutMapping("/{airportId}")
    public void updateAirport(@PathVariable int airportId, @RequestBody Airport updatedAirport) {
        for (int i = 0; i < airportList.size(); i++) {
            Airport airport = airportList.get(i);
            if (airport.getId() == airportId) {
                // Update the airport's information
                airport.setId(updatedAirport.getId());
                airport.setName(updatedAirport.getName());
                airport.setCode(updatedAirport.getCode());
                return;
            }
        }

    }

    // Delete a specific airport by ID
    @DeleteMapping("/{airportId}")
    public void deleteAirport(@PathVariable int airportId) {
        airportList.removeIf(airport -> airport.getId() == airportId);
    }
}