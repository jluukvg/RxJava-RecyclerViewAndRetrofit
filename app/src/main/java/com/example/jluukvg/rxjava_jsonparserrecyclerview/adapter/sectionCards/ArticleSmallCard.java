package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.Article;

import java.util.ArrayList;

/**
 * Created by jluukvg on 14-Jun-17.
 */

public class ArticleSmallCard extends SectionCards {

    public final Article article;

    private ArticleSmallCard(Article article) {
        super(CardType.kArticleSmallCard);
        this.article = article;
    }

    public static ArrayList<SectionCards> convertArticlesSmallToCards(ArrayList<Article> articles) {
        ArrayList<SectionCards> cards = new ArrayList<>(articles.size());
        for (Article article : articles) {
            ArticleSmallCard articleSmallCard = new ArticleSmallCard(article);
            cards.add(articleSmallCard);
        }
        return cards;
    }

    public static ArticleSmallCard convertArticleToCard(Article article) {
        return new ArticleSmallCard(article);
    }
}
