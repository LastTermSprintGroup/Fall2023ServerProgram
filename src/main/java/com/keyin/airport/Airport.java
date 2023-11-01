package com.keyin.airport;

public class Airport {
    private int id;
    private String name;
    private String code;
    private int cityId;

//Basic Airport Constructor
    public Airport() {}

// Airport Constructor
    public Airport(int id, String name, String code, int cityId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.cityId = cityId;
    }
// Getter for Airport ID
    public int getId() {
        return id;
    }
// Setter for Airport ID
    public void setId(int id) {
        this.id = id;
    }
// Getter for Airport area code
    public String getCode() {
        return code;
    }
// Setter for Airport area code
    public void setCode(String code) {
        this.code = code;
    }
// Getter for Airport name
    public String getName() {
        return name;
    }
// Setter for Airport name
    public void setName(String name) {
        this.name = name;
    }
    // Getter for City ID
    public int getCityId() {
        return cityId;
    }

    // Setter for City ID
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

}