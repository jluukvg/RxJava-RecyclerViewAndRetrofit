package com.example.jluukvg.rxjava_jsonparserrecyclerview.network;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.Section;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.VideoMedia;

import java.util.ArrayList;

/**
 * Created by jluukvg on 7/22/17.
 */

public class MenuResponse {
    public ArrayList<Section> noticias;
    public ArrayList<Section> deportes;
    public ArrayList<Section> entretenimiento;
    public ArrayList<Section> television;
    public ArrayList<VideoMedia> live;
}
