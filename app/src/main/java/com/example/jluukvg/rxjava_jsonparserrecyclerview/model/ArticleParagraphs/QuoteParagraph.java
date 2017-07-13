package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.ArticleParagraphs;

/**
 * Created by jluukvg on 4/4/2017.
 *
 */

public class QuoteParagraph extends ArticleParagraph {

    public String autor;    // This is a typo from the json
    public String text;

    public QuoteParagraph() {

        super("quote_paragraph");
    }
}
