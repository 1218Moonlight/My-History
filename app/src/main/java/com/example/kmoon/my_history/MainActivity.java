package com.example.kmoon.my_history;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kmoon.my_history.base.DefaultActivity;
import com.example.kmoon.my_history.utils.age;
import com.example.kmoon.my_history.utils.photo;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends DefaultActivity {

    protected ImageView img;
    protected TextView name, birthday, gender;
    protected age myAge;
    protected photo photoUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if (this.myInfoSp.getPrefer().equals(getString(R.string.default_empty))) {
            startActivityIntent(MyInfoActivity.class);
        } else {
            this.bind();
            try {
                // TODO: Bitmap optimization. (size, type etc...) (save and read)
                this.myinfoJson.init(new JSONObject(this.myInfoSp.getPrefer()));
                this.img.setImageBitmap(this.photoUtils.base64ToBitmap(this.myinfoJson.getString(getString(R.string.user_img))));
                this.name.setText(this.myinfoJson.getString(getString(R.string.user_name)));
                initBirthday();
                this.gender.setText(this.myinfoJson.getString(getString(R.string.user_gender)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    private void bind() {
        this.img = findViewById(R.id.main_user_img);
        this.name = findViewById(R.id.main_user_name);
        this.birthday = findViewById(R.id.main_user_birthday);
        this.gender = findViewById(R.id.main_user_gender);
        this.photoUtils = new photo(this);
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
