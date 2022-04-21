package com.example.searchfuntionality;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://murmuring-peak-92245.herokuapp.com";
    @GET("UserParking")
    Call<List<Result>> getusers();
}