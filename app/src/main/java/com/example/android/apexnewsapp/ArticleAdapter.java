package com.example.android.apexnewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {
    private static final String LOG_TAG = ArticleAdapter.class.getName();

    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

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

