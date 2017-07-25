package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.SectionParagraphs;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.Article;

import java.util.ArrayList;

/**
 * Created by jluukvg on 3/6/2017.
 *
 */

public class GridContent extends SectionParagraph {
    public String title;
    public ArrayList<Article> nodes;

    public GridContent() {
        super("grid_content");
    }
}
