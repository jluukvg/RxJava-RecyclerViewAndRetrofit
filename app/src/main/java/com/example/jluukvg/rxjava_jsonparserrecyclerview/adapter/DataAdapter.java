package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import com.bumptech.glide.Glide;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.GlideApp;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.R;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.holders.ArticleSmallViewHolder;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.holders.ArticleViewHolder;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.holders.FooterViewHolder;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.holders.HeaderViewHolder;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards.ArticleCard;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards.ArticleSmallCard;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards.FooterCard;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards.HeaderCard;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards.SectionCards;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.Android;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.Article;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.SectionParagraphs.GridContent;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.SectionParagraphs.SectionParagraph;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_SECTION_HEADER = 10000;
    private static final int TYPE_ARTICLE = 10001;
    private static final int TYPE_ARTICLE_SMALL = 10002;
    private static final int TYPE_AD_BANNER = 10003;
    private static final int TYPE_FOOTER = 10004;
    private final Context context;

    private ArrayList<SectionCards> cards;

    private ArrayList<SectionParagraph> paragraphs;

    public DataAdapter(Context context, ArrayList<SectionParagraph> paragraphs) {
        this.context = context;
        this.paragraphs = paragraphs;
        loadData();
    }

    @Override
    public int getItemViewType(int position) {
        SectionCards card = cards.get(position);
        switch (card.type) {
            case kHeaderCard:
                return TYPE_SECTION_HEADER;
            case kArticleCard:
                return TYPE_ARTICLE;
            case kArticleSmallCard:
                return TYPE_ARTICLE_SMALL;
            case kAdCard:
                return position;
            case kFooterCard:
                return TYPE_FOOTER;
            default:
                return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_SECTION_HEADER:
                View v0 = inflater.inflate(R.layout.sectionlistfragment_item_header, parent, false);
                viewHolder = new HeaderViewHolder(v0);
                break;
            case TYPE_ARTICLE:
                View v1 = inflater
                        .inflate(R.layout.sectionlistfragment_item_article, parent, false);
                viewHolder = new ArticleViewHolder(v1);
                break;
            case TYPE_ARTICLE_SMALL:
                View v2 = inflater
                        .inflate(R.layout.sectionlistfragment_item_article_small, parent, false);
                v2.setClickable(true);
                viewHolder = new ArticleSmallViewHolder(v2);
                break;
            case TYPE_FOOTER:
                View v4 = inflater.inflate(R.layout.sectionlistfragment_item_footer, parent, false);
                viewHolder = new FooterViewHolder(v4);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_SECTION_HEADER:
                HeaderViewHolder vh0 = (HeaderViewHolder) holder;
                configure_headerViewHolder(vh0, position);
                break;
            case TYPE_ARTICLE:
                ArticleViewHolder vh1 = (ArticleViewHolder) holder;
                configure_articleViewHolder(vh1, position);
                break;
            case TYPE_ARTICLE_SMALL:
                ArticleSmallViewHolder vh2 = (ArticleSmallViewHolder) holder;
                configure_articleSmallViewHolder(vh2, position);
                break;
            case TYPE_FOOTER:
                break;
            default:
                break;
        }
    }

    private void configure_headerViewHolder(HeaderViewHolder vh0, int position) {
        SectionCards card = cards.get(position);
        if (card != null) {
            String section_header = ((HeaderCard) card).header;
            vh0.vHeader.setText(section_header);
        }
    }

    private void configure_articleViewHolder(final ArticleViewHolder vh1, int position) {
        SectionCards card = cards.get(position);
        if (card != null) {
            //vh1.vPlaceHolder.setVisibility(View.VISIBLE);
            final Article ci = ((ArticleCard) card).article;
            String strip_title;
            strip_title = ci.title.replaceAll("\\r\\n", " ");
            vh1.vTitle.setText(strip_title);
            if (ci.teaser != null) {
                vh1.vTeaser.setText(ci.teaser);
            } else {
                vh1.vTeaser.setVisibility(View.GONE);
            }
            String timestamp = Integer.toString(ci.created);
            vh1.vCreated.setText(timestamp);
            // if (ci.thumbnail != null) {


            if (ci.thumbnail != null) {
                GlideApp.with(context).load(ci.thumbnail.cover_phone)
                        .placeholder(new ColorDrawable(Color.LTGRAY))
                        .error(R.drawable.image_default)
                        .into(vh1.vImage);
            } else {
                Glide.with(context).clear(vh1.vImage);
                vh1.vImage.setImageResource(R.drawable.image_default);
            }

                /*Picasso.with(context).load(ci.thumbnail.cover_phone)
                        .placeholder(R.drawable.image_default)
                        .into(vh1.vImage, new Callback() {
                            public void onSuccess() {
                                vh1.vPlaceHolder.setVisibility(View.GONE);
                                vh1.vImage.setVisibility(View.VISIBLE);
                            }

                            public void onError() {
                                //vh1.vThumbnailLayout.setVisibility(View.GONE);
                                vh1.vImage.setVisibility(View.GONE);
                            }
                        });*/
            /*} else {
                //vh1.vThumbnailLayout.setVisibility(View.GONE);
                vh1.vPlaceHolder.setVisibility(View.GONE);
                vh1.vImage.setVisibility(View.GONE);*/
            // }
        }
    }

    private void configure_articleSmallViewHolder(final ArticleSmallViewHolder vh2, int position) {
        SectionCards card = cards.get(position);
        if (card != null) {
            //vh2.vPlaceHolder.setVisibility(View.VISIBLE);
            final Article ci = ((ArticleSmallCard) card).article;
            String strip_title;
            strip_title = ci.title.replaceAll("\\r\\n", " ");
            vh2.vTitle.setText(strip_title);
            String timestamp = Integer.toString(ci.created);
            vh2.vCreated.setText(timestamp);

            if (ci.thumbnail != null) {
                GlideApp.with(context).load(ci.thumbnail.cover_phone)
                        .placeholder(new ColorDrawable(Color.LTGRAY))
                        .error(R.drawable.image_default)
                        .into(vh2.vImage);
            } else {
                Glide.with(context).clear(vh2.vImage);
                vh2.vImage.setImageResource(R.drawable.image_default);
            }

                /*Picasso.with(context).load(ci.thumbnail.thumb)
                        .into(vh2.vImage, new Callback() {
                            public void onSuccess() {
                                vh2.vPlaceHolder.setVisibility(View.GONE);
                                vh2.vImage.setVisibility(View.VISIBLE);
                            }

                            public void onError() {
                                vh2.vPlaceHolder.setVisibility(View.GONE);
                                vh2.vImage.setImageResource(R.drawable.image_default);
                            }
                        });*/
            /*} else {
                //vh2.vPlaceHolder.setVisibility(View.GONE);
                vh2.vImage.setImageResource(R.drawable.image_default);
            }*/
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName, mTvVersion, mTvApi;

        ViewHolder(View view) {
            super(view);
            mTvName = view.findViewById(R.id.tv_name);
            mTvVersion = view.findViewById(R.id.tv_version);
            mTvApi = view.findViewById(R.id.tv_api_level);
        }
    }

    private void loadData() {
        cards = new ArrayList<>();
        if (paragraphs == null) {
            return;
        }
        for (SectionParagraph paragraph : paragraphs) {
            if (paragraph instanceof GridContent) {
                //int adPosition = 2;
                int count = cards.size();
                GridContent grid = (GridContent) paragraph;
                // Check if there is content in the paragraph
                int numOfArticles = grid.nodes.size();
                Article firstArticle;
                if (numOfArticles > 0) {
                    firstArticle = grid.nodes.get(0);
                } else {
                    continue;
                }
                // Add section Title as Header
                if (grid.title != null) {
                    SectionCards header = HeaderCard.convertHeaderToCard(grid.title);
                    cards.add(header);
                    //adPosition = count + 2;
                }
                // Add first Article of section as a Big Card
                cards.add(ArticleCard.convertArticleToCard(firstArticle));
                // Add remaining Articles of section as Small Cards
                for (int i = 1; i < numOfArticles; i++) {
                    cards.add(ArticleSmallCard.convertArticleToCard(grid.nodes.get(i)));
                }
            }
        }
        SectionCards footer = FooterCard.createFooterCard();
        cards.add(footer);
    }
}

