package com.hackerkernel.moviretrofit;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private  static Retrofit retrofit;

    static  Context context;

public static Retrofit getRetrofit(){

    if (retrofit==null){

        return retrofit=new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create()).build();

    }

    else {

        return retrofit;
    }
}

}
