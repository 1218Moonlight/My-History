package com.example.kmoon.my_history;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.kmoon.my_history.base.DefaultActivity;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends DefaultActivity {

    protected TextView name, birthday, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        Log.d("testtest", "" + test(2016, 10, 27, 2019, 3, 15));


//        if (this.myInfoSp.getPrefer().equals(getString(R.string.default_empty))) {
//            startActivityIntent(MyInfoActivity.class);
//        } else {
//            this.bind();
//            try {
//                this.myinfoJson.init(new JSONObject(this.myInfoSp.getPrefer()));
//                this.name.setText(this.myinfoJson.getString(getString(R.string.user_name)));
//                this.birthday.setText(this.myinfoJson.getString(getString(R.string.user_birthday)));
//                this.gender.setText(this.myinfoJson.getString(getString(R.string.user_gender)));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private int test(int year1, int month1, int date1, int year2, int month2, int date2) {
        Calendar cal = Calendar.getInstance();

        int dateCount1 = 0, dateCount2 = 0, yearDiff = 0, dayDiff = 0;
        if (year1 > year2) {
            for (int i = year2; i < year1; i++) {
                cal.set(i, 12, 0);
                yearDiff += cal.get(Calendar.DAY_OF_YEAR);
            }
            dateCount1 += yearDiff;
        } else if (year1 < year2) {
            for (int i = year1; i < year2; i++) {
                cal.set(i, 12, 0);
                yearDiff += cal.get(Calendar.DAY_OF_YEAR);
            }
            dateCount2 += yearDiff;
        }
        cal.set(year1, month1 - 1, date1);
        dayDiff = cal.get(Calendar.DAY_OF_YEAR);
        dateCount1 += dayDiff;
        cal.set(year2, month2 - 1, date2);
        dayDiff = cal.get(Calendar.DAY_OF_YEAR);
        dateCount2 += dayDiff;
        return dateCount1 - dateCount2;
    }



    private void bind() {
        this.name = findViewById(R.id.main_user_name);
        this.birthday = findViewById(R.id.main_user_birthday);
        this.gender = findViewById(R.id.main_user_gender);
    }
}
