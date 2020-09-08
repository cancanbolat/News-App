package com.example.mvvm_retrofit.RestApi;


import com.example.mvvm_retrofit.models.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RestApi {

    @GET("top-headlines")
    Call<NewsModel> getNews(@Query("country") String country, @Query("apiKey") String apiKey);

}
