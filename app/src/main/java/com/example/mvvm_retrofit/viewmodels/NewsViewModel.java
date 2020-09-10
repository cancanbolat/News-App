package com.example.mvvm_retrofit.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_retrofit.models.Articles;
import com.example.mvvm_retrofit.Repo.NewsRepo;

import java.util.List;

public class NewsViewModel extends ViewModel {

    NewsRepo newsRepo = new NewsRepo();

    // news list
    public LiveData<List<Articles>> getNews() {
        return newsRepo.getNews();
    }

    //click start
    MutableLiveData<Articles> mutableArticles = new MutableLiveData<>();

    public void setNewsDetail(Articles articles) {
        mutableArticles.setValue(articles);
    }

    public LiveData<Articles> getNewDetail() {
        return mutableArticles;
    }
    // end click


}
