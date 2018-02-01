package com.trivediinfoway.retrofitdemo.Interface;

import com.trivediinfoway.retrofitdemo.dataclass.ProductResponse;
import com.trivediinfoway.retrofitdemo.dataclass.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TI A1 on 12-10-2017.
 */
public interface WithBasicAuthApi {
    String BASE_URL = "Base API";

    @GET ("hotel_api/listallhotels?start=0&no_of_rows=10&user_id=306&user_lat=0.0&user_lng=0.0")
    Call<List<data>> getProduct();

    @GET("hotel_api/listallhotels?start=0&no_of_rows=10&user_id=306&user_lat=0.0&user_lng=0.0")
    Call<ProductResponse> getTopRatedMovies();
}
