package com.example.mvvm_retrofit.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_retrofit.models.Articles;
import com.example.mvvm_retrofit.Repo.NewsRepo;

import java.util.List;

public class NewsViewModel extends ViewModel {

    NewsRepo newsRepo = new NewsRepo();

    public LiveData<List<Articles>> getNews() {
        return newsRepo.getNews();
    }


}
