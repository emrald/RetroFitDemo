package com.trivediinfoway.retrofitdemo.Interface;

import com.trivediinfoway.retrofitdemo.dataclass.RewardsClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by TI A1 on 13-10-2017.
 */
public interface WithPostKeyValueApi {

    // Trackly api
    /*String BASE_URL = "http://taylor-moss.com/api/";//"http://guestrewardsclub.com/";
    @FormUrlEncoded
    @POST("track/check?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEzLCJpc3MiOiJodHRwOi8vdGF5bG9yLW1vc3MuY29tL2FwaS9hdXRoL2xvZ2luIiwiaWF0IjoxNTA1ODAxMTQ4LCJleHAiOjE1MjE1NjkxNDgsIm5iZiI6MTUwNTgwMTE0OCwianRpIjoiVUVlT3pQYUVOem5UNmRqaSJ9.6ls9sSMcsM79xU8Sws-HCpjguNMCGD3ifuLryaDPDTY")

    Call<TracklyClass> getLoginResponseTrckly(@Field("url") String action);
    */

    String BASE_URL = "http://guestrewardsclub.com/";
    @FormUrlEncoded
    @POST("api.php")
    Call<RewardsClass> getLoginResponse(@Field("action") String action,
                                        @Field("email") String email,
                                        @Field("password") String password);
}
