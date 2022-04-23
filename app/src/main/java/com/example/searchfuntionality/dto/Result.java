package com.example.searchfuntionality.dto;

/*
[{"user_id":1,"user_name":"pranil","user_contact":7709199499,
"user_email":"pranildhanave@gmail.com","user_password":"pranil1996",
"updated_at":"2022-04-20T12:58:44.902+00:00","created_at":"2022-04-20T12:58:44.902+00:00"}]
 */

public class Result {
    private int id;
    private String name;
    private String password;
    private String email;
    private long contact;

    public Result(int id, String name, String password, String email, long contact) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

    public Result() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}

