package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards;

/**
 * Created by jluukvg on 3/13/2017.
 *
 */

public class HeaderCard extends SectionCards {
    public final String header;

    private HeaderCard(String header) {
        super(CardType.kHeaderCard);
        this.header = header;
    }

    public static SectionCards convertHeaderToCard(String header) {

        return new HeaderCard(header);
    }
}
