package com.trivediinfoway.retrofitdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.trivediinfoway.retrofitdemo.Interface.WithBasicAuthApi;
import com.trivediinfoway.retrofitdemo.dataclass.ProductResponse;
import com.trivediinfoway.retrofitdemo.dataclass.data;

import java.io.IOException;
import java.util.List;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WithBasicAuthentication extends AppCompatActivity {

    ListView listView;
    WithBasicAuthApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewHeroes);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic("adminwp", "?mnb098!"));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WithBasicAuthApi.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        api = retrofit.create(WithBasicAuthApi.class);

        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(WithBasicAuthentication.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.show();

        Call<ProductResponse> call = api.getTopRatedMovies();

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                progressDoalog.dismiss();

                List<data> ProductList = response.body().getData();
                String[] heroes = new String[ProductList.size()];
                for (int i = 0; i < ProductList.size(); i++) {
                    heroes[i] = ProductList.get(i).getHotel_name();
                }
                Log.e("size", response.body().getData().get(0).getHotel_name() + " : size");

                Log.e("response", response.body().getTotal() + " : response");
                listView.setAdapter(new ArrayAdapter<String>(WithBasicAuthentication.this, android.R.layout.simple_list_item_1, heroes));
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
