package com.example.searchfuntionality;

/*
[{"user_id":1,"user_name":"pranil","user_contact":7709199499,
"user_email":"pranildhanave@gmail.com","user_password":"pranil1996",
"updated_at":"2022-04-20T12:58:44.902+00:00","created_at":"2022-04-20T12:58:44.902+00:00"}]
 */

public class Result {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private long user_contact;

    public Result(int user_id, String user_name, String user_password, String user_email, long user_contact) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_contact = user_contact;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public long getUser_contact() {
        return user_contact;
    }

    public void setUser_contact(long user_contact) {
        this.user_contact = user_contact;
    }

    public Result() {

    }
}

