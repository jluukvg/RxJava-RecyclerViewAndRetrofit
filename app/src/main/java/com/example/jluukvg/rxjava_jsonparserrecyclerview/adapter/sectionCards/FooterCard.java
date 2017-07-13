package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards;

/**
 * Created by jluukvg on 3/16/2017.
 *
 */

public class FooterCard extends SectionCards {

    private FooterCard() {
        super(CardType.kFooterCard);
    }

    public static SectionCards createFooterCard() {
        return new FooterCard();
    }
}
