package com.keyin.aircraft;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private List<Aircraft> aircraftList = new ArrayList<>();

    public Aircraft createAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
        return aircraft;
    }

    public List<Aircraft> getAllAircrafts() {
        return aircraftList;
    }

    public Optional<Aircraft> getAircraftById(int id) {
        return aircraftList.stream().filter(a -> a.getID() == id).findFirst();
    }

    public Aircraft updateAircraft(int id, Aircraft updatedAircraft) {
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getID() == id) {
                aircraft.setModel(updatedAircraft.getModel());
                aircraft.setCapacity(updatedAircraft.getCapacity());
                return aircraft;
            }
        }
        return null;
    }

    public boolean deleteAircraft(int id) {
        return aircraftList.removeIf(aircraft -> aircraft.getID() == id);
    }
}