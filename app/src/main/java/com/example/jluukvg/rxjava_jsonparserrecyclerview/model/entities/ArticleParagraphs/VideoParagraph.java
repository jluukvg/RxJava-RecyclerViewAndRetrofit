package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs;


import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.DrupalImage;

/**
 * Created by jluukvg on 4/4/2017.
 *
 */

public class VideoParagraph extends ArticleParagraph {

    public String title;
    public String video_url;
    public String text;
    public String hls;
    public DrupalImage image;

    public VideoParagraph() {

        super("video_paragraph");
    }
}
