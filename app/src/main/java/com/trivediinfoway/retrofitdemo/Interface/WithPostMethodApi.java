package com.trivediinfoway.retrofitdemo.Interface;

import com.trivediinfoway.retrofitdemo.dataclass.LoginClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by TI A1 on 12-10-2017.
 */
public interface WithPostMethodApi {
    String BASE_URL = "http://freehotelcoupons.com/";

    // with post method login
    @FormUrlEncoded
    @POST("hotel_api/login?")//email=test@gmail.com&password=12345678")
    Call<LoginClass> getLoginResponse(@Field("email") String email,
                                      @Field("password") String password);
    //with get method login
    /*@GET("hotel_api/login?")//email=test@gmail.com&password=12345678")
    Call<LoginClass> getLoginResponse(@QueryMap Map<String,String> body);*/
}
