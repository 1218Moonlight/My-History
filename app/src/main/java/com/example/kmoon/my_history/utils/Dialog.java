package com.example.kmoon.my_history.utils;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class Dialog {
    private AlertDialog.Builder adb;

    public Dialog(AppCompatActivity compatActivity) {
        this.adb = new AlertDialog.Builder(compatActivity);
    }

    protected void show(String title, String msg) {
        this.adb.setTitle(title);
        this.adb.setMessage(msg);
        this.adb.show();
    }
}
