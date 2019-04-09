package com.example.kmoon.my_history.utils;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

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

    public Boolean isNull(ImageView iv) {
        BitmapDrawable bd = ((BitmapDrawable) iv.getDrawable());
        return bd == null;
    }

}
