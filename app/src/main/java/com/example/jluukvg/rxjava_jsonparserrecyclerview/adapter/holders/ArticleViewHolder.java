package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.holders;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jluukvg on 3/13/2017.
 *
 */

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    public final RelativeLayout vThumbnailLayout;
    //public ProgressBar vProgressBar;
    public final View vPlaceHolder;
    public final ImageView vImage;
    //public TextView vSection;
    public final TextView vTitle;
    public final TextView vTeaser;
    public final TextView vCreated;
    public final ImageView vBookmark;

    public ArticleViewHolder(View v) {
        super(v);
        vThumbnailLayout = v.findViewById(R.id.thumbnail_layout);
        //vProgressBar = (ProgressBar) v.findViewById(R.id.sections_image_loading);
        vPlaceHolder = v.findViewById(R.id.sections_image_loading);
        vImage = v.findViewById(R.id.thumbnail);
        //vSection = (TextView)  v.findViewById(section);
        vTitle = v.findViewById(R.id.title);
        vTeaser = v.findViewById(R.id.teaser);
        vCreated = v.findViewById(R.id.created);
        vBookmark = v.findViewById(R.id.home_bookmark);
    }
}
