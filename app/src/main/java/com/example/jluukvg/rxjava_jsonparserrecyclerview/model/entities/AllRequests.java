package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.network.MenuResponse;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.network.SectionResponse;

/**
 * Created by jluukvg on 7/22/17.
 *
 */

public class AllRequests {

    public MenuResponse menuResponse;
    public SectionResponse sectionResponse;

    public AllRequests(MenuResponse menuResponse, SectionResponse sectionResponse) {
       this.menuResponse = menuResponse;
       this.sectionResponse = sectionResponse;
    }
}
