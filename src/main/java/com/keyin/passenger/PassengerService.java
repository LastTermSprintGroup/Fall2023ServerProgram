package com.keyin.passenger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    private List<PassengerEntity> passengers = new ArrayList<>();

    public PassengerEntity createPassenger(PassengerEntity passenger) {
        passengers.add(passenger);
        return passenger;
    }

    public List<PassengerEntity> getAllPassengers() {
        return passengers;
    }

    public PassengerEntity getPassengerById(int id) {
        for (PassengerEntity passenger : passengers) {
            if (passenger.getPassengerID() == id) {
                return passenger;
            }
        }
        return null;
    }

    public PassengerEntity updatePassenger(int id, PassengerEntity updatedPassenger) {
        for (PassengerEntity passenger : passengers) {
            if (passenger.getPassengerID() == id) {
                passenger.setFirstName(updatedPassenger.getFirstName());
                passenger.setLastName(updatedPassenger.getLastName());
                passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
                return passenger;
            }
        }
        return null;
    }

    public boolean deletePassenger(int id) {
        return passengers.removeIf(passenger -> passenger.getPassengerID() == id);
    }
}
