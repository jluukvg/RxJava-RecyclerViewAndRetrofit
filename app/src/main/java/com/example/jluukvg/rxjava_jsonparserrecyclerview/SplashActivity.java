package com.example.jluukvg.rxjava_jsonparserrecyclerview;

/**
 * Created by jluukvg on 7/21/17.
 *
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.DrupalModelSingleton;

public class SplashActivity extends AppCompatActivity {

    // The model that holds all retrieved data from the internet
    private static final DrupalModelSingleton model = DrupalModelSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start home activity
        Intent launchNextActivity;
        launchNextActivity = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(launchNextActivity);
        // close splash activity
        finish();
    }
}
