package com.example.kmoon.my_history;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kmoon.my_history.base.DefaultActivity;

public class MainActivity extends DefaultActivity implements View.OnClickListener {

    protected Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.btn = findViewById(R.id.test);
        this.btn.setOnClickListener(this);

        Log.d("testtest", this.myInfoSp.getPrefer());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test:
                Log.d("testtest", "testBtn click");
                startActivity(new Intent(this, MyInfoActivity.class));
                break;
        }
    }
}
