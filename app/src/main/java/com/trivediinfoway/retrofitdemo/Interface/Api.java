package com.trivediinfoway.retrofitdemo.Interface;

import com.trivediinfoway.retrofitdemo.dataclass.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TI A1 on 11-10-2017.
 */
public interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
