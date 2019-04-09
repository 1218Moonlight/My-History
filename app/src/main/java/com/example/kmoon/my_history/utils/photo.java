package com.example.kmoon.my_history.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class photo extends AppCompatActivity {
    private AppCompatActivity compatActivity;
    private Intent intent;

    public photo(AppCompatActivity appCompatActivity) {
        this.compatActivity = appCompatActivity;
        initIntent();
    }

    private void initIntent() {
        this.intent = new Intent();
        this.intent.setType("image/*");
        this.intent.setAction(Intent.ACTION_GET_CONTENT);
    }

    public void openGallery() {
        this.compatActivity.startActivityForResult(this.intent, 1);
    }

}
