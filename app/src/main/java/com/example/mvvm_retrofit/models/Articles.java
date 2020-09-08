package com.example.mvvm_retrofit.models;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Articles {

    public Articles() {
    }

    private Sources source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public Sources getSource() {
        return source;
    }


    public String getAuthor() {
        return author;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public String getUrl() {
        return url;
    }


    public String getUrlToImage() {
        return urlToImage;
    }


    public String getPublishedAt() {
        return publishedAt;
    }


    public String getContent() {
        return content;
    }

    public Articles(Sources source, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "source=" + source +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articles articles = (Articles) o;
        return getSource().equals(articles.getSource()) &&
                getAuthor().equals(articles.getAuthor()) &&
                getTitle().equals(articles.getTitle()) &&
                getDescription().equals(articles.getDescription()) &&
                getUrl().equals(articles.getUrl()) &&
                getUrlToImage().equals(articles.getUrlToImage()) &&
                getPublishedAt().equals(articles.getPublishedAt()) &&
                getContent().equals(articles.getContent());
    }

    public static DiffUtil.ItemCallback<Articles> itemCallback = new DiffUtil.ItemCallback<Articles>() {
        @Override
        public boolean areItemsTheSame(@NonNull Articles oldItem, @NonNull Articles newItem) {
            return oldItem.getTitle().equals(newItem.getUrl());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Articles oldItem, @NonNull Articles newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:newsImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(imageUrl)
                .fitCenter()
                .into(imageView);
    }

    // time Format
    public String timeTo(String publishedAt) {
        PrettyTime prettyTime = new PrettyTime(new Locale(getCountry()));
        String isTime = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
            Date date = dateFormat.parse(publishedAt);
            isTime = prettyTime.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isTime;
    }


    // date Format
    public String dateTo(String publishedAt) {
        String newDate;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy", new Locale(getCountry()));
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(publishedAt);
            newDate = simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            newDate = publishedAt;
        }
        return newDate;
    }

    // country
    public static String getCountry() {
        Locale locale = Locale.getDefault();
        String country = String.valueOf(locale.getCountry());
        return country.toLowerCase();
    }

}
