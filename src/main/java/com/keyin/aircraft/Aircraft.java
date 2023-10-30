package com.keyin.aircraft;

public class Aircraft {
// Private instance variables
// that represent the ID of an
// aircraft, the model of the aircraft,
// and the amount of passengers as capacity
    private String ID;
    private String model;
    private int capacity;
// Basic aircraft constructor
    public Aircraft() {}
// Aircraft constructor that assigns all values
    public Aircraft(String ID, String model, int capacity) {
        this.ID = ID;
        this.model = model;
        this.capacity = capacity;
    }
// Getter for Aircrafts ID
    public String getID() {
        return ID;
    }
// Setter for the Aircrafts ID
    public void setID(String ID) {
        this.ID = ID;
    }
// Getter for the model of the Aircraft
    public String getModel() {
        return model;
    }
// Setter for the model of the Aircraft
    public void setModel(String model) {
        this.model = model;
    }
// Getter for the capacity of the Aircraft
    public int getCapacity() {
        return capacity;
    }
// Setter for the capacity of the Aircraft
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
