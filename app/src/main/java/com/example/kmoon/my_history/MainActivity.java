package com.example.kmoon.my_history;

import android.os.Bundle;
import android.widget.TextView;

import com.example.kmoon.my_history.base.DefaultActivity;

public class MainActivity extends DefaultActivity {

    protected TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.test = findViewById(R.id.testHello);

        if (this.myInfoSp.getPrefer().equals("empty")) {
            startActivityIntent(MyInfoActivity.class);
        } else {
            this.test.setText(this.myInfoSp.getPrefer());
        }
    }
}
