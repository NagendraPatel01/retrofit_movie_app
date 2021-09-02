package com.hackerkernel.moviretrofit;

import Model.PersonModel;
import Model.PopularMovieModel;
import Model.PopularmovietrailorModel;
import Model.TrendingMovieModel;
import Model.TrendingmovietrailorModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyInterface {

    @GET("trending/person/week")
    Call<PersonModel> getdata(@Query("api_key") String key);


    @GET("trending/movie/week")
    Call<TrendingMovieModel> getdatamovie(@Query("api_key") String key);


    @GET("movie/popular")
    Call<PopularMovieModel> getpopularmovie(@Query("api_key") String key);

    @GET("movie/{movie_id}/videos")
    Call<TrendingmovietrailorModel> gettrailortrendingmovie(@Path("movie_id") String movie_id ,@Query("api_key") String key);


    @GET("movie/{movie_id}/videos")
    Call<PopularmovietrailorModel> gettrailorpopularmovie(@Path("movie_id") String movie_id , @Query("api_key") String key);
}
