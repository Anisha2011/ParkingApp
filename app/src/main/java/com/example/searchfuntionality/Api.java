package com.example.searchfuntionality;

import com.example.searchfuntionality.dto.BookingEntity;
import com.example.searchfuntionality.dto.Bookingdto;
import com.example.searchfuntionality.dto.Parkingdto;
import com.example.searchfuntionality.dto.Result;
import com.example.searchfuntionality.dto.Slots;
import com.example.searchfuntionality.dto.Walletdto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "https://murmuring-peak-92245.herokuapp.com";
    @GET("UserParking")
    Call<List<Result>> getusers();

    @GET("Parking")
    Call<List<Parkingdto>> getparking();

    @GET("Login/{email}/{password}")
    Call<Result> getlogin(
            @Path("email") String email,
            @Path("password") String password
    );

    @POST("UserParking/User")
    Call<Result> createPost(@Body Result result);

    @GET("ParkingSlots/{ParkingId}")
    Call<List<Slots>> getparkingslots(
            @Path("ParkingId") int parkingId
    );

    @POST("Booking/ConfirmBooking")
    Call<BookingEntity> confirmBooking(@Body Bookingdto bookingdto);

    @GET("UserWallet/{UserId}")
    Call<Walletdto> getwallet(
            @Path("UserId")int userId
    );

}
