package com.example.jluukvg.rxjava_jsonparserrecyclerview.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DrupalApi {

    @GET("services/luxbox_sections/{tid}.json")
    Observable<SectionResponse> loadSection(@Path("tid") String tid);

    @GET("services/luxbox_sections/menu.json")
    Observable<MenuResponse> loadMenu();
}
