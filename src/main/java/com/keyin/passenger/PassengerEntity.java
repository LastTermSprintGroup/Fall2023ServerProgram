package com.keyin.passenger;

import java.util.List;
public class PassengerEntity {
    private int passengerID;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private int cityId;
    private List<Integer> aircraftIds;
    //Values to store details

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //Getters and setters for passenger values
}
