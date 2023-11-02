package com.keyin.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{airportId}")
    public Airport getAirportById(@PathVariable int airportId) {
        return airportService.getAirportById(airportId);
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport newAirport) {
        Airport createdAirport = airportService.createAirport(newAirport);
        return new ResponseEntity<>(createdAirport, HttpStatus.CREATED);
    }

    @PutMapping("/{airportId}")
    public void updateAirport(@PathVariable int airportId, @RequestBody Airport updatedAirport) {
        airportService.updateAirport(airportId, updatedAirport);
    }

    @DeleteMapping("/{airportId}")
    public void deleteAirport(@PathVariable int airportId) {
        airportService.deleteAirport(airportId);
    }

    @GetMapping("/city/{cityId}")
    public List<Airport> getAirportsByCity(@PathVariable int cityId) {
        return airportService.getAirportsByCity(cityId);
    }


}