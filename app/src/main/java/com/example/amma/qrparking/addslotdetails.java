package com.example.amma.qrparking;

public class addslotdetails {
    private String State;
    private String District;
    private String City;
    private String Landmark;
    private Integer nslots;
    public addslotdetails() {
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }

    public Integer getNslots() {
        return nslots;
    }

    public void setNslots(Integer nslots) {
        this.nslots = nslots;
    }
}
