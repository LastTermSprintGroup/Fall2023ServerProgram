package com.keyin.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.keyin.airport.Airport;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        Aircraft createdAircraft = aircraftService.createAircraft(aircraft);
        return new ResponseEntity<>(createdAircraft, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircrafts() {
        List<Aircraft> aircrafts = aircraftService.getAllAircrafts();
        return new ResponseEntity<>(aircrafts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable int id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftById(id);
        return aircraft.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable int id, @RequestBody Aircraft updatedAircraft) {
        Aircraft aircraft = aircraftService.updateAircraft(id, updatedAircraft);
        if (aircraft != null) {
            return new ResponseEntity<>(aircraft, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable int id) {
        boolean isDeleted = aircraftService.deleteAircraft(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{aircraftId}/airports")
    public ResponseEntity<List<Airport>> getAirportsByAircraft(@PathVariable int aircraftId) {
        List<Airport> airports = aircraftService.getAirportsByAircraft(aircraftId);
        if (airports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }
}