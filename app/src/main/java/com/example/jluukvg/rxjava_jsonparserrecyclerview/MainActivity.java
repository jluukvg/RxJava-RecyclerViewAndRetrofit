package com.example.jluukvg.rxjava_jsonparserrecyclerview;

import com.google.gson.Gson;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.DataAdapter;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.SectionParagraphs.SectionParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.network.RequestInterface;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.network.SectionResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://admin.dev.monterrey.getluxbox.com/";

    private RecyclerView mRecyclerView;

    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCompositeDisposable = new CompositeDisposable();
        initRecyclerView();
        loadJSON();
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void loadJSON() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        CustomGson customGson = new CustomGson();
        Gson gson = customGson.getCustomGson();
        RequestInterface requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build().create(RequestInterface.class);
        mCompositeDisposable.add(requestInterface.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(SectionResponse sectionResponse) {
        ArrayList<SectionParagraph> paragraphs = sectionResponse.paragraphs;
        DataAdapter mAdapter = new DataAdapter(this, paragraphs);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void handleError(Throwable error) {
        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
