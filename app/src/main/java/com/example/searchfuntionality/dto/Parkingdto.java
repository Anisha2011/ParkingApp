package com.example.searchfuntionality.dto;

public class Parkingdto
{
    private int parking_id;

    private String name;

    private String area;

    private String locality;

    private int pincode;

    private int charge;

    public Parkingdto(int parking_id, String name, String area, String locality, int pincode, int charge) {
        this.parking_id = parking_id;
        this.name = name;
        this.area = area;
        this.locality = locality;
        this.pincode = pincode;
        this.charge = charge;
    }

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }
}
