package com.example.searchfuntionality.dto;

public class Slots {
    private int id;
    private String number;
    private String status;
    private int parkingId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public Slots(int id, String number, String status, int parkingId) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.parkingId = parkingId;
    }
}
