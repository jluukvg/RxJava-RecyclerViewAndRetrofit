package com.example.jluukvg.rxjava_jsonparserrecyclerview.network;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("services/luxbox_sections/2.json")
    Observable<SectionResponse> register();
}
