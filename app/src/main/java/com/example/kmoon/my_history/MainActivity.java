package com.example.kmoon.my_history;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.kmoon.my_history.base.DefaultActivity;

public class MainActivity extends DefaultActivity {

    protected TextView name, birthday, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if (this.myInfoSp.getPrefer().equals(getString(R.string.default_empty))) {
            startActivityIntent(MyInfoActivity.class);
        } else {
            this.bind();
            try {
                JSONObject myInfoJson = new JSONObject(this.myInfoSp.getPrefer());
                this.name.setText(myInfoJson.getString(getString(R.string.user_name)));
                this.birthday.setText(myInfoJson.getString(getString(R.string.user_birthday)));
                this.gender.setText(myInfoJson.getString(getString(R.string.user_gender)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void bind() {
        this.name = findViewById(R.id.main_user_name);
        this.birthday = findViewById(R.id.main_user_birthday);
        this.gender = findViewById(R.id.main_user_gender);
    }
}
