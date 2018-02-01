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


    String BASE_URL = "Base API";
    @FormUrlEncoded
    @POST("api.php")
    Call<RewardsClass> getLoginResponse(@Field("action") String action,
                                        @Field("email") String email,
                                        @Field("password") String password);
}
