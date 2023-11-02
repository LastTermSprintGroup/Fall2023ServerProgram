package com.keyin.passenger;

import com.keyin.aircraft.Aircraft;
import com.keyin.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<PassengerEntity>> getAllPassengers() {
        List<PassengerEntity> passengers = passengerService.getAllPassengers();
        if (passengers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }
    @GetMapping("/{passengerId}")
    public PassengerEntity getPassenger(@PathVariable int passengerId) {
        return passengerService.getPassengerById(passengerId);
    }

    @PostMapping
    public PassengerEntity createPassenger(@RequestBody PassengerEntity passenger) {
        return passengerService.createPassenger(passenger);
    }

    @PutMapping("/{passengerId}")
    public PassengerEntity updatePassenger(@PathVariable int passengerId, @RequestBody PassengerEntity updatedPassenger) {
        return passengerService.updatePassenger(passengerId, updatedPassenger);
    }

    @DeleteMapping("/{passengerId}")
    public String deletePassenger(@PathVariable int passengerId) {
        boolean isDeleted = passengerService.deletePassenger(passengerId);
        if (isDeleted) {
            return "Passenger with ID " + passengerId + " has been deleted";
        } else {
            throw new PassengerNotFoundException("Passenger not found with ID: " + passengerId);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class PassengerNotFoundException extends RuntimeException {
        public PassengerNotFoundException(String message) {
            super(message);
        }
    }

    @GetMapping("/{passengerId}/aircrafts")
    public List<Aircraft> getAircraftsByPassenger(@PathVariable int passengerId) {
        return passengerService.getAircraftsByPassenger(passengerId);
    }

    @GetMapping("/{passengerId}/airports")
    public List<Airport> getAirportsByPassenger(@PathVariable int passengerId) {
        return passengerService.getAirportsByPassenger(passengerId);
    }

}

