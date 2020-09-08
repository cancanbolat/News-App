package com.example.mvvm_retrofit.Repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_retrofit.models.Articles;
import com.example.mvvm_retrofit.models.NewsModel;
import com.example.mvvm_retrofit.RestApi.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepo {

    private MutableLiveData<List<Articles>> mutableLiveData;

    public LiveData<List<Articles>> getNews() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            loadNews();
        }
        return mutableLiveData;
    }

    private void loadNews() {
        Call<NewsModel> listCall = ApiService.restApi().getNews("tr", "");
        listCall.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                List<Articles> articlesList = response.body().getArticles();
                mutableLiveData.setValue(articlesList);
                Log.i("DEneme", String.valueOf(response.body().getArticles().size()));
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });
    }


}
