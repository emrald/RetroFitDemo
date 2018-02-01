package com.trivediinfoway.retrofitdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trivediinfoway.retrofitdemo.Interface.WithPostKeyValueApi;
import com.trivediinfoway.retrofitdemo.dataclass.RewardsClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WithPostKeyValueMethod extends AppCompatActivity {

    ProgressDialog progressDoalog;
    TextView textView13,textView14,textView15,textView16,textView17,textView18,textView19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_post_key_value_method);

        textView13 = (TextView)findViewById(R.id.textView13);
        textView14 = (TextView)findViewById(R.id.textView14);
        textView15 = (TextView)findViewById(R.id.textView15);
        textView16 = (TextView)findViewById(R.id.textView16);
        textView17 = (TextView)findViewById(R.id.textView17);
        textView18 = (TextView)findViewById(R.id.textView18);
        textView19 = (TextView)findViewById(R.id.textView19);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WithPostKeyValueApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        WithPostKeyValueApi api = retrofit.create(WithPostKeyValueApi.class);
        progressDoalog = new ProgressDialog(WithPostKeyValueMethod.this);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.show();

        Call<RewardsClass> call = api.getLoginResponse("login","kk@gmail.com","12345678");
        call.enqueue(new Callback<RewardsClass>() {
            @Override
            public void onResponse(Call<RewardsClass> call, Response<RewardsClass> response) {
                progressDoalog.dismiss();

                Log.e("response", response.body().getFirst_name() + " : response");
                textView13.setText(response.body().getEmail()+"");
                textView14.setText(response.body().getAddress()+"");
                textView15.setText(response.body().getCity()+"");
                textView16.setText(response.body().getLast_name()+"");
                textView17.setText(response.body().getState()+"");
                textView18.setText(response.body().getUser_role()+"");
                textView19.setText(response.body().getZip()+"");
            }

            @Override
            public void onFailure(Call<RewardsClass> call, Throwable t) {
                progressDoalog.dismiss();
                Log.e("response", t.getMessage() + " : response");
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Write a message to the database
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

    }
}
