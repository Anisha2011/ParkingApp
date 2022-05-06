package com.example.searchfuntionality.dto;

public class BookingEntity {
    private int id;
    private int duration;
    private String status;
    private int slotId;
    private int userId;

    public BookingEntity(int id, int duration, String status, int slotId, int userId) {
        this.id = id;
        this.duration = duration;
        this.status = status;
        this.slotId = slotId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
