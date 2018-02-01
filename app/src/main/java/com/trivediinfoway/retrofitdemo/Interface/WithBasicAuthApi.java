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
    String BASE_URL = "http://freehotelcoupons.com/";

    //@POST("http://oldnavy.gap.com/browse/product.do?cid=1018059&pcid=5475&vid=1&pid=120007212")
 /*   @GET ("api/track/check?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEzLCJpc3MiOiJodHRwOi8vdGF5bG9yLW1vc3MuY29tL2FwaS9hdXRoL2xvZ2luIiwiaWF0IjoxNTA1ODAxMTQ4LCJleHAiOjE1MjE1NjkxNDgsIm5iZiI6MTUwNTgwMTE0OCwianRpIjoiVUVlT3pQYUVOem5UNmRqaSJ9.6ls9sSMcsM79xU8Sws-HCpjguNMCGD3ifuLryaDPDTY")
    Call<List<data>> getProduct();*/
   /* @POST("url")
    Call<List<data>> getProduct(
            @QueryMap Map<String, String> params
            // @Field("url") String url
    );*/

    @GET ("hotel_api/listallhotels?start=0&no_of_rows=10&user_id=306&user_lat=0.0&user_lng=0.0")
    Call<List<data>> getProduct();

    @GET("hotel_api/listallhotels?start=0&no_of_rows=10&user_id=306&user_lat=0.0&user_lng=0.0")
    Call<ProductResponse> getTopRatedMovies();
}
