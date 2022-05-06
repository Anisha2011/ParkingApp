package com.example.searchfuntionality.dto;

public class Bookingdto {
    private int parkingId;
    private int userId;
    private int slotId;

    public Bookingdto(int parkingId, int userId, int slotId) {
        this.parkingId = parkingId;
        this.userId = userId;
        this.slotId = slotId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Bookingdto(int parkingId, int userId) {
        this.parkingId = parkingId;
        this.userId = userId;
    }
}
