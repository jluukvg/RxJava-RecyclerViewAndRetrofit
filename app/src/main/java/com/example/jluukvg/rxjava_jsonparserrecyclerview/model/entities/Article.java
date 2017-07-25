package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.ArticleParagraphs.ArticleParagraph;

import java.util.ArrayList;

/**
 * Created by miguel on 3/6/17.
 *
 */

public class Article {
    public String type;
    public int nid;
    public String alias;
    public String title;
    public int created;
    private int changed;
    public Author author;
    public String teaser;
    public Section section;
    public DrupalImage thumbnail;
    private String style;
    public ArrayList<ArticleParagraph> paragraphs;
    public ArrayList<Article> recommended;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return nid == article.nid &&
                created == article.created &&
                changed == article.changed &&
                (alias != null ? alias.equals(article.alias) : article.alias == null) &&
                (title != null ? title.equals(article.title) : article.title == null) &&
                (author != null ? author.equals(article.author) : article.author == null) &&
                (teaser != null ? teaser.equals(article.teaser) : article.teaser == null) &&
                (section != null ? section.equals(article.section) : article.section == null) &&
                (thumbnail != null ? thumbnail.equals(article.thumbnail) : article.thumbnail == null) &&
                (style != null ? style.equals(article.style) : article.style == null) &&
                (paragraphs != null ? paragraphs.equals(article.paragraphs) : article.paragraphs == null) &&
                (recommended != null ? recommended.equals(article.recommended) : article.recommended == null);
    }

    @Override
    public int hashCode() {
        int result = nid;
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + created;
        result = 31 * result + changed;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (teaser != null ? teaser.hashCode() : 0);
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (paragraphs != null ? paragraphs.hashCode() : 0);
        result = 31 * result + (recommended != null ? recommended.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "nid=" + nid +
                ", alias='" + alias + '\'' +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", changed=" + changed +
                ", author=" + author +
                ", teaser='" + teaser + '\'' +
                ", section=" + section +
                ", thumbnail=" + thumbnail +
                ", style='" + style + '\'' +
                ", paragraphs=" + paragraphs +
                ", recommended=" + recommended +
                '}';
    }
}