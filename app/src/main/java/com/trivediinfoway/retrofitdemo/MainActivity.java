package com.trivediinfoway.retrofitdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.trivediinfoway.retrofitdemo.Adapter.CustomAdapter;
import com.trivediinfoway.retrofitdemo.Interface.Api;
import com.trivediinfoway.retrofitdemo.dataclass.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listViewHeroes);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        //creating the api interface
        Api api = retrofit.create(Api.class);

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<List<Hero>> call = api.getHeroes();
       // Call<List<Hero>> call = api.getHeroes();

        //then finallly we are making the call using enqueue()
        //it takes callback interface as an argument
        //and callback is having two methods onRespnose() and onFailure
        //if the request is successfull we will get the correct response and onResponse will be executed
        //if there is some error we will get inside the onFailure() method
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
     //   progressDoalog.setTitle("ProgressDialog bar example");
    //    progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDoalog.show();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                //In this point we got our hero list
                //thats damn easy right ;)
                progressDoalog.dismiss();
                List<Hero> heroList = response.body();

                //Creating an String array for the ListView
               // String[] heroes = new String[heroList.size()];

                //looping through all the heroes and inserting the names inside the string array
               /* for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                }*/

                //displaying the string array into listview
                listView.setAdapter(new CustomAdapter(MainActivity.this, R.layout.row, heroList));
                //now we can do whatever we want with this list
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
