package com.keyin.city;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private List<City> cityList = new ArrayList<>();

    public City createCity(City city) {
        cityList.add(city);
        return city;
    }

    public List<City> getAllCities() {
        return cityList;
    }

    public Optional<City> getCityById(int id) {
        return cityList.stream().filter(c -> c.getId() == id).findFirst();
    }

    public City updateCity(int id, City updatedCity) {
        for (City city : cityList) {
            if (city.getId() == id) {
                city.setName(updatedCity.getName());
                city.setState(updatedCity.getState());
                city.setPopulation(updatedCity.getPopulation());
                return city;
            }
        }
        return null;
    }

    public boolean deleteCity(int id) {
        return cityList.removeIf(city -> city.getId() == id);
    }
}
