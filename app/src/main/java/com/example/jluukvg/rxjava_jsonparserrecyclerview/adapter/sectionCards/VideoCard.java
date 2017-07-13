package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.sectionCards;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.VideoMedia;

import java.util.ArrayList;

/**
 * Created by jluukvg on 5/11/2017.
 */

public class VideoCard extends SectionCards {

    public final VideoMedia video;

    private VideoCard(VideoMedia video) {
        super(CardType.kVideoCard);
        this.video = video;
    }

    public static ArrayList<SectionCards> convertVideosToCards(ArrayList<VideoMedia> videos) {
        ArrayList<SectionCards> cards = new ArrayList<>(videos.size());
        for (VideoMedia video : videos) {
            VideoCard videoCard = new VideoCard(video);
            cards.add(videoCard);
        }
        return cards;
    }
}
