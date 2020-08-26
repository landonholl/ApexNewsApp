package com.example.android.apexnewsapp;

public class Article {

    private String mDate;

    private String mAuthor;

    private String mTitle;

    private String mSectionName;

    private String mUrl;

    private String mThumbnailUrl;

    public Article(String date, String webTitle, String sectionName, String url, String author, String thumbnailUrl) {
        mDate = date;
        mTitle = webTitle;
        mSectionName = sectionName;
        mUrl = url;
        mAuthor = author;
        mThumbnailUrl = thumbnailUrl;

    }

    public String getAuthor() { return mAuthor; }

    public String getDate() { return mDate; }

    public String getTitle() { return mTitle; }

    public String getSectionName() { return mSectionName; }

    public String getUrl() { return mUrl; }

    public String getThumbnailUrl() { return mThumbnailUrl; }
}