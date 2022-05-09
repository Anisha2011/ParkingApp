package com.example.searchfuntionality.dto;

public class Walletdto {
    private int id;
    private int userId;
    private int balance;

    public Walletdto(int id, int userId, int balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
