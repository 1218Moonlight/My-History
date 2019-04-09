package com.example.kmoon.my_history;

import android.os.Bundle;
import android.widget.TextView;

import com.example.kmoon.my_history.base.DefaultActivity;
import com.example.kmoon.my_history.utils.age;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends DefaultActivity {

    protected TextView name, birthday, gender;
    protected age myAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if (this.myInfoSp.getPrefer().equals(getString(R.string.default_empty))) {
            startActivityIntent(MyInfoActivity.class);
        } else {
            this.bind();
            try {
                this.myinfoJson.init(new JSONObject(this.myInfoSp.getPrefer()));
                this.name.setText(this.myinfoJson.getString(getString(R.string.user_name)));
                initBirthday();
                this.gender.setText(this.myinfoJson.getString(getString(R.string.user_gender)));
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

    private void initBirthday(){
        String birth = this.myinfoJson.getString(getString(R.string.user_birthday));
        if (birth != null && !birth.isEmpty()) {
            // birthArray[0] == year
            // birthArray[1] == month
            // birthArray[2] == date
            String[] birthArray = birth.split("-");
            myAge = new age(Integer.parseInt(birthArray[0]), Integer.parseInt(birthArray[1]), Integer.parseInt(birthArray[2]));
            this.birthday.setText(this.myinfoJson.getString(getString(R.string.user_birthday)) + "(" + myAge.ageDiff() + ")");
        } else {
            this.birthday.setText(this.myinfoJson.getString(getString(R.string.user_birthday)));
        }
    }
}
