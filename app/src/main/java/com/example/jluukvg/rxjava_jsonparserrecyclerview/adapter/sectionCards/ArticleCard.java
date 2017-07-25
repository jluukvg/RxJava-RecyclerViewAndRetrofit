package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.Article;

import java.util.ArrayList;

/**
 * Created by jluukvg on 3/13/2017.
 */

public class ArticleCard extends SectionCards {

    public final Article article;

    private ArticleCard(Article article) {
        super(CardType.kArticleCard);
        this.article = article;
    }

    public static ArrayList<SectionCards> convertArticlesToCards(ArrayList<Article> articles) {
        ArrayList<SectionCards> cards = new ArrayList<>(articles.size());
        for (Article article : articles) {
            ArticleCard articleCard = new ArticleCard(article);
            cards.add(articleCard);
        }
        return cards;
    }

    public static ArticleCard convertArticleToCard(Article article) {
        return new ArticleCard(article);
    }
}

