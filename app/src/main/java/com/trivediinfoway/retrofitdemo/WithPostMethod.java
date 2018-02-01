package com.trivediinfoway.retrofitdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.trivediinfoway.retrofitdemo.Interface.WithPostMethodApi;
import com.trivediinfoway.retrofitdemo.dataclass.LoginClass;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WithPostMethod extends AppCompatActivity {//implements Callback<LoginClass>{
    Call<LoginClass> call;
    ProgressDialog progressDoalog;
    TextView textView7, textView8, textView9, textView10, textView11, textView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_post_method_main);

        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView)findViewById(R.id.textView12);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic("", ""));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WithPostMethodApi.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        WithPostMethodApi api = retrofit.create(WithPostMethodApi.class);

        progressDoalog = new ProgressDialog(WithPostMethod.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.show();

        call = api.getLoginResponse("test@gmail.com","12345678");

        call.enqueue(new Callback<LoginClass>() {
            @Override
            public void onResponse(Call<LoginClass> call, Response<LoginClass> response) {
                progressDoalog.dismiss();

                Log.e("response", response.body().getData().getUser_first_name() + " : response");
                textView7.setText(response.body().getData().getState_id()+"");
                textView8.setText(response.body().getData().getUser_addr1()+"");
                textView9.setText(response.body().getData().getUser_city()+"");
                textView10.setText(response.body().getData().getUser_email()+"");
                textView11.setText(response.body().getData().getUser_first_name()+"");
                textView12.setText(response.body().getData().getUser_phone()+"");
            }

            @Override
            public void onFailure(Call<LoginClass> call, Throwable t) {
                progressDoalog.dismiss();
                Log.e("response", t.getMessage() + " : response");
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
