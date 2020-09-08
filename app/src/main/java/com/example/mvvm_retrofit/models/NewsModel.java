package com.example.mvvm_retrofit.models;

import java.util.ArrayList;

public class NewsModel {


    private String status;
    private String totalResults;
    private ArrayList<Articles> articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}
