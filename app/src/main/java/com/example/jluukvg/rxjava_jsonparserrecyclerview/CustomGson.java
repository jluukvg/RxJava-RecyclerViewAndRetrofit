package com.example.jluukvg.rxjava_jsonparserrecyclerview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.ArticleParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.CodeParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.ImageParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.QuoteParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.ReadMoreParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.TextParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.VideoParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.SectionParagraphs.GridContent;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.SectionParagraphs.SectionParagraph;

public class CustomGson {

    public CustomGson() {
    }

    public Gson getCustomGson() {
        // adding all different container classes with their flag
        RuntimeTypeAdapterFactory<SectionParagraph> typeFactory = RuntimeTypeAdapterFactory
                .of(SectionParagraph.class,
                        "type") // Here you specify which is the parent class and what field particularizes the child class.
                .registerSubtype(GridContent.class,
                        "grid_content"); // if the flag equals the class name, you can skip the second parameter. This is only necessary, when the "type" field does not equal the class name.
        RuntimeTypeAdapterFactory<ArticleParagraph> articleTypeFactory = RuntimeTypeAdapterFactory
                .of(ArticleParagraph.class,
                        "type") // Here you specify which is the parent class and what field particularizes the child class.
                .registerSubtype(TextParagraph.class, "text_paragraph")
                .registerSubtype(ImageParagraph.class, "image_paragraph")
                .registerSubtype(VideoParagraph.class, "video_paragraph")
                .registerSubtype(CodeParagraph.class, "code_paragraph")
                .registerSubtype(ReadMoreParagraph.class, "read_more_paragraph")
                .registerSubtype(QuoteParagraph.class, "quote_paragraph");
        // add the polymorphic specialization
        return new GsonBuilder().registerTypeAdapterFactory(typeFactory)
                .registerTypeAdapterFactory(articleTypeFactory).create();
    }
}
