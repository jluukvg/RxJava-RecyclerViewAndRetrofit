package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.holders;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by jluukvg on 14-Jun-17.
 *
 */

public class ArticleSmallViewHolder extends RecyclerView.ViewHolder {
    public final LinearLayout vSmallLayout;
    public final View vTopSeparator;
    private final RelativeLayout vThumbnailLayoutSmall;
    public final View vPlaceHolder;
    public final ImageView vImage;
    public final TextView vTitle;
    public final TextView vCreated;
    public final ImageView vBookmark;

    public ArticleSmallViewHolder(View v) {
        super(v);
        vSmallLayout = v.findViewById(R.id.article_small_layout);
        vTopSeparator = v.findViewById(R.id.top_separator_section_list);
        vThumbnailLayoutSmall = v.findViewById(R.id.thumbnail_layout_small);
        vPlaceHolder = v.findViewById(R.id.sections_image_loading_small);
        vImage = v.findViewById(R.id.thumbnail_small);
        vTitle = v.findViewById(R.id.title_small);
        vCreated = v.findViewById(R.id.created_small);
        vBookmark = v.findViewById(R.id.home_bookmark_small);
    }
}
