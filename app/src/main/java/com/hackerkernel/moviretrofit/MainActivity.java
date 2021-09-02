package com.hackerkernel.moviretrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackerkernel.moviretrofit.Adapter.PersonAdapter;
import com.hackerkernel.moviretrofit.Adapter.PopularMovieAdapter;
import com.hackerkernel.moviretrofit.Adapter.TrendingMovieAdapter;

import Model.PersonModel;
import Model.PopularMovieModel;
import Model.TrendingMovieModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recycle,recycle1,recycle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle=findViewById(R.id.recycle);
        recycle1=findViewById(R.id.recycle1);
        recycle2=findViewById(R.id.recycle2);

        Trendingmovie();
        Popularmovie();


        RetrofitClint.getRetrofit().create(MyInterface.class)
                .getdata("c4824776bf6f08433a4c4e7cd75a6acc")
                .enqueue(new Callback<PersonModel>() {
                    @Override
                    public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {

                        Log.d(TAG, "onResponse: "+response);
                        Log.d(TAG, "kjhgfdfghj "+response.body());

                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
                        recycle.setLayoutManager(linearLayoutManager);

                        PersonAdapter adapter=new PersonAdapter(MainActivity.this,response.body());
                        recycle.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<PersonModel> call, Throwable t) {

                        Log.d(TAG, "onFailure: "+t.getMessage());

                        Toast.makeText(MainActivity.this, "Ankit", Toast.LENGTH_SHORT).show();

                    }
                });
    }

   public void Trendingmovie() {

       RetrofitClint.getRetrofit().create(MyInterface.class)
               .getdatamovie("c4824776bf6f08433a4c4e7cd75a6acc")
               .enqueue(new Callback<TrendingMovieModel>() {
                   @Override
                   public void onResponse(Call<TrendingMovieModel> call, Response<TrendingMovieModel> response) {

                       Log.d(TAG, "ghgfghg: " + response);
                       Log.d(TAG, "hgfdfghhgffghgf " + response.body());

                       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
                       recycle1.setLayoutManager(linearLayoutManager);

                       TrendingMovieAdapter trendingMovieAdapter = new TrendingMovieAdapter(MainActivity.this, response.body());
                       recycle1.setAdapter(trendingMovieAdapter);
                   }

                   @Override
                   public void onFailure(Call<TrendingMovieModel> call, Throwable t) {

                       Log.d(TAG, "onFailure: " + t.getMessage());

                       Toast.makeText(MainActivity.this, "ankit", Toast.LENGTH_SHORT).show();


                   }
               });


    }

    public  void Popularmovie(){

        RetrofitClint.getRetrofit().create(MyInterface.class)
                .getpopularmovie("c4824776bf6f08433a4c4e7cd75a6acc")
                .enqueue(new Callback<PopularMovieModel>() {
            @Override
            public void onResponse(Call<PopularMovieModel> call, Response<PopularMovieModel> response) {

                Log.d(TAG, "rghjhgf: "+response);
                Log.d(TAG, "fgnbvcvbn: "+response.body());

                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
                recycle2.setLayoutManager(linearLayoutManager);

                PopularMovieAdapter popularMovieAdapter=new PopularMovieAdapter(MainActivity.this,response.body());
                recycle2.setAdapter(popularMovieAdapter);

            }

            @Override
            public void onFailure(Call<PopularMovieModel> call, Throwable t) {

                Log.d(TAG, "onFailure: "+t.getMessage());

                Toast.makeText(MainActivity.this, "ankit", Toast.LENGTH_SHORT).show();
            }
        });
    }
}