package com.keyin.passenger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    private List<PassengerEntity> passengers = new ArrayList<>();

    // GET /passengers: List all passengers
    @GetMapping
    public List<PassengerEntity> getAllPassengers() {
        return passengers;
    }

    // GET /passengers/{passengerId}: Get a specific passenger
    @GetMapping("/{passengerId}")
    public PassengerEntity getPassenger(@PathVariable int passengerId) {
        for (PassengerEntity passenger : passengers) {
            if (passenger.getPassengerID() == passengerId) {
                return passenger;
            }
        }
        throw new PassengerNotFoundException("Passenger not found with ID: " + passengerId);
    }

    // POST /passengers: Create a new passenger
    @PostMapping
    public PassengerEntity createPassenger(@RequestBody PassengerEntity passenger) {
        // Generate a new passenger ID (you may need to handle this differently)
        int newPassengerId = passengers.size() + 1;
        passenger.setPassengerID(newPassengerId);
        passengers.add(passenger);
        return passenger;
    }

    // PUT /passengers/{passengerId}: Update a specific passenger
    @PutMapping("/{passengerId}")
    public PassengerEntity updatePassenger(@PathVariable int passengerId, @RequestBody PassengerEntity updatedPassenger) {
        for (int i = 0; i < passengers.size(); i++) {
            PassengerEntity passenger = passengers.get(i);
            if (passenger.getPassengerID() == passengerId) {
                updatedPassenger.setPassengerID(passengerId);
                passengers.set(i, updatedPassenger);
                return updatedPassenger;
            }
        }
        throw new PassengerNotFoundException("Passenger not found with ID: " + passengerId);
    }

    // DELETE /passengers/{passengerId}: Delete a specific passenger
    @DeleteMapping("/{passengerId}")
    public String deletePassenger(@PathVariable int passengerId) {
        passengers.removeIf(passenger -> passenger.getPassengerID() == passengerId);
        return "Passenger with ID " + passengerId + " has been deleted";
    }
}

// Custom exception class for handling passenger not found
@ResponseStatus(HttpStatus.NOT_FOUND)
class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException(String message) {
        super(message);
    }
}

