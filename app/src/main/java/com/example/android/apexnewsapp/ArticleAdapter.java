package com.example.android.apexnewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link ArticleAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link Article} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */


public class ArticleAdapter extends ArrayAdapter<Article> {
    private static final String LOG_TAG = ArticleAdapter.class.getName();


    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context of the app
     * @param articles is the list of articles, which is the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        // Find the article at the given position in the list of articles
        Article currentArticle = getItem(position);

        String articleTitle = currentArticle.getTitle();

        String date = currentArticle.getDate();

        String author = currentArticle.getAuthor();

        String sectionName = currentArticle.getSectionName();

        TextView titleView = (TextView) listItemView.findViewById(R.id.title_text_view);

        titleView.setText(articleTitle);

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_name);

        sectionView.setText(sectionName);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);

        dateView.setText(date);

        TextView authorView = (TextView) listItemView.findViewById(R.id.author_text_view);

        authorView.setText(author);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.thumbnail);

        Picasso.with(getContext()).load(currentArticle.getThumbnailUrl()).resize(256, 256).centerCrop().into(imageView);

        return listItemView;
    }
}

