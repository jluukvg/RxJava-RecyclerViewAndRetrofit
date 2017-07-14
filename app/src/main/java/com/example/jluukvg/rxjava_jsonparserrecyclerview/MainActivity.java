package com.example.jluukvg.rxjava_jsonparserrecyclerview;

import com.google.gson.Gson;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.DataAdapter;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.SectionParagraphs.SectionParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.network.RequestInterface;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.network.SectionResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://laguna.multimedios.com/";

    private RecyclerView mRecyclerView;
    private int imageHeightInPixels = 0;

    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCompositeDisposable = new CompositeDisposable();
        Log.d("RXjava", "My int: " + imageHeightInPixels);
        calculateImageHeightInDp();
        initRecyclerView();
        loadJSON();
        Log.d("RXjava", "My int: " + imageHeightInPixels);
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(SectionResponse sectionResponse) {
        ArrayList<SectionParagraph> paragraphs = sectionResponse.paragraphs;
        DataAdapter mAdapter = new DataAdapter(this, paragraphs, imageHeightInPixels);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void handleError(Throwable error) {
        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    private void calculateImageHeightInDp() {
        Observable.fromCallable(this::getHeightInPixels)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::mockMethod);
    }

    private void mockMethod(int myInt) {
        Log.d("RXjava", "Mock method result: " + Integer.toString(myInt));
        this.imageHeightInPixels = myInt;
        Log.d("RXjava", "Mock method result: " + Integer.toString(this.imageHeightInPixels));
    }

    private int getHeightInPixels() {
        double viewRatio = 1.85714285714;
        float deviceScreenDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        float devicePixelsPerDensityPixel = deviceScreenDpi / 160;
        float viewWidthInPixels = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
        float viewHeightInPixels = Double.valueOf(viewWidthInPixels / viewRatio).floatValue();

        int roundedViewWidthInPixels = (int) Math.ceil(viewWidthInPixels);
        int roundedViewHeightInPixels = (int) Math.ceil(viewHeightInPixels);
        return roundedViewHeightInPixels;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }


}
