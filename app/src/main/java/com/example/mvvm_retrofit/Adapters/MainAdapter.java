package com.example.mvvm_retrofit.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_retrofit.models.Articles;
import com.example.mvvm_retrofit.databinding.RecyclerItemsBinding;

public class MainAdapter extends ListAdapter<Articles, MainAdapter.viewHolder> {

    MainInterface mainInterface;

    public MainAdapter(MainInterface mainInterface) {
        super(Articles.itemCallback);
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerItemsBinding recyclerItemsBinding = RecyclerItemsBinding.inflate(layoutInflater, parent, false);
        return new viewHolder(recyclerItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Articles articles = getItem(position);
        holder.recyclerBinding.setNews(articles);
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        private RecyclerItemsBinding recyclerBinding;

        public viewHolder(RecyclerItemsBinding recyclerItems) {
            super(recyclerItems.getRoot());
            this.recyclerBinding = recyclerItems;
        }
    }

    public interface MainInterface {
        void itemClick(Articles articles);
    }


}
