package com.example.kmoon.my_history.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.kmoon.my_history.utils.Dialog;
import com.example.kmoon.my_history.utils.OnBackPressedHandler;
import com.example.kmoon.my_history.utils.SharedDB;

import java.util.HashMap;

public class DefaultActivity extends AppCompatActivity {

    protected SharedDB myInfoSp;
    protected HashMap<String, String> infoMap = new HashMap<String, String>();

    protected Dialog dl;

    private OnBackPressedHandler obp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.myInfoSp = new SharedDB(this, "myInfo");

        this.dl = new Dialog(this);

        this.obp = new OnBackPressedHandler(this);

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        this.obp.onBackPressed();
    }

    public void startActivityIntent(Class<?> cls){
        startActivity(new Intent(this, cls));
        this.finish();
    }
}
