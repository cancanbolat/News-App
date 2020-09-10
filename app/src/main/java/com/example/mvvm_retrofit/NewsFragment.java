package com.example.mvvm_retrofit;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_retrofit.adapters.MainAdapter;
import com.example.mvvm_retrofit.models.Articles;
import com.example.mvvm_retrofit.databinding.FragmentNewsBinding;
import com.example.mvvm_retrofit.viewmodels.NewsViewModel;

import java.util.List;

public class NewsFragment extends Fragment implements MainAdapter.MainInterface {

    FragmentNewsBinding fragmentNewsBinding;
    private MainAdapter mainAdapter;
    private NewsViewModel newsViewModel;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentNewsBinding = FragmentNewsBinding.inflate(inflater, container, false);
        return fragmentNewsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainAdapter = new MainAdapter(this);
        fragmentNewsBinding.recyclerView.setAdapter(mainAdapter);

        newsViewModel = new ViewModelProvider(requireActivity()).get(NewsViewModel.class);

        newsViewModel.getNews().observe(getViewLifecycleOwner(), new Observer<List<Articles>>() {
            @Override
            public void onChanged(List<Articles> articles) {
                mainAdapter.submitList(articles);
            }
        });

    }

    @Override
    public void itemClick(Articles articles) { // click
        Log.i("Click => ", articles.getUrl());
        newsViewModel.setNewsDetail(articles);
        //paylaşma işlemi
        shareApp(articles.getUrl());
    }

    // share news url
    public void shareApp(String shareURL) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/pain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "News App");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareURL);
        startActivity(Intent.createChooser(shareIntent, "Share News Link"));
    }

}