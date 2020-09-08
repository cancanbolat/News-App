package com.example.mvvm_retrofit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_retrofit.Adapters.MainAdapter;
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
    public void itemClick(Articles articles) {

    }
}