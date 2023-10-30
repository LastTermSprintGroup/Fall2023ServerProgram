package com.keyin.city;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {

    // Dummy list to mimic a database. In a real application, you would use a service and repository.
    private List<City> cityList = new ArrayList<>();

    // CREATE a new city
    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        cityList.add(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    // READ all cities
    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    // READ a single city by ID
    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable int id) {
        Optional<City> city = cityList.stream().filter(c -> c.getId() == id).findFirst();
        if (city.isPresent()) {
            return new ResponseEntity<>(city.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE a city by ID
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable int id, @RequestBody City updatedCity) {
        for (City city : cityList) {
            if (city.getId() == id) {
                city.setName(updatedCity.getName());
                city.setState(updatedCity.getState());
                city.setPopulation(updatedCity.getPopulation());
                return new ResponseEntity<>(city, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE a city by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable int id) {
        if (cityList.removeIf(city -> city.getId() == id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Use NO_CONTENT for successful deletes with no response body
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}