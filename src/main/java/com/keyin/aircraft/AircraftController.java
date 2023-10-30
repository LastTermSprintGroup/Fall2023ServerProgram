package com.keyin.aircraft;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    // Dummy list to mimic a database. In a real application, you would use a service and repository.
    private List<Aircraft> aircraftList = new ArrayList<>();

    // CREATE a new aircraft
    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        aircraftList.add(aircraft);
        return new ResponseEntity<>(aircraft, HttpStatus.CREATED);
    }

    // READ all aircrafts
    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircrafts() {
        return new ResponseEntity<>(aircraftList, HttpStatus.OK);
    }

    // READ a single aircraft by ID
    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftList.stream().filter(a -> a.getID().equals(id)).findFirst();
        if (aircraft.isPresent()) {
            return new ResponseEntity<>(aircraft.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE an aircraft by ID
    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft updatedAircraft) {
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getID().equals(id)) {
                aircraft.setModel(updatedAircraft.getModel());
                aircraft.setCapacity(updatedAircraft.getCapacity());
                return new ResponseEntity<>(aircraft, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE an aircraft by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        if (aircraftList.removeIf(aircraft -> aircraft.getID().equals(id))) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Use NO_CONTENT for successful deletes with no response body
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}