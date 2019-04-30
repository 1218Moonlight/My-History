package com.example.kmoon.my_history.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

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

    public String bitmapToBase64String(ImageView iv) {
        Bitmap bm = ((BitmapDrawable) iv.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imgBytes = stream.toByteArray();
        return Base64.encodeToString(imgBytes, Base64.NO_WRAP);
    }

    public Bitmap base64ToBitmap(String bitmapString){
        byte[] decodeByteArray = Base64.decode(bitmapString, Base64.NO_WRAP);
        return BitmapFactory.decodeByteArray(decodeByteArray, 0, decodeByteArray.length);
    }

}
