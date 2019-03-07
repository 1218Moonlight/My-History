package com.example.kmoon.my_history.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public class SharedDB {

    private String key;
    private String defValue;
    private SharedPreferences sp;
    private SharedPreferences.Editor spe;


    public SharedDB(AppCompatActivity compatActivity, String key, String defValue) {
        this.key = key;
        this.defValue = defValue;
        this.sp = compatActivity.getSharedPreferences(this.key, Context.MODE_PRIVATE);
        this.spe = this.sp.edit();

    }

    public String getPrefer() {
        return this.sp.getString(this.key, this.defValue);
    }

    public void savePrefer(String msg) {
        this.spe.putString(this.key, msg);
        this.spe.commit();
    }

    public void removePrefer() {
        this.spe.remove(this.key);
        this.spe.commit();
    }

    public void removeAllPrefer() {
        this.spe.clear();
        this.spe.commit();
    }
}
