package com.keyin.airport;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void createAirport(@RequestBody Airport newAirport) {
        airportService.createAirport(newAirport);
    }

    @PutMapping("/{airportId}")
    public void updateAirport(@PathVariable int airportId, @RequestBody Airport updatedAirport) {
        airportService.updateAirport(airportId, updatedAirport);
    }

    @DeleteMapping("/{airportId}")
    public void deleteAirport(@PathVariable int airportId) {
        airportService.deleteAirport(airportId);
    }
}