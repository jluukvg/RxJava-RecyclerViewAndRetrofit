package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards;

/**
 * Created by jluukvg on 3/13/2017.
 *
 */

public class SectionCards {

    public enum CardType {
        kArticleCard,
        kArticleSmallCard,
        kVideoCard,
        kHeaderCard,
        kAdCard,
        kFooterCard
    }

    public final CardType type;

    protected SectionCards(CardType type) {
        this.type = type;
    }
}
