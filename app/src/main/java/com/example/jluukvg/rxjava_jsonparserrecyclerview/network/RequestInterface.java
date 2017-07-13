package com.example.jluukvg.rxjava_jsonparserrecyclerview.network;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.Android;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("android/jsonarray/")
    Observable<List<Android>> register();
}
