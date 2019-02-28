package com.example.kmoon.my_history;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected SharedDB myInfoSp;
    protected HashMap<String, String> infoMap = new HashMap<String, String>();

    protected Dialog dl;

    protected Button mainOk;
    protected EditText enterName, enterBirthday;
    protected RadioGroup radioGroup;
    protected AppCompatActivity compatActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.compatActivity = this;

//        this.dl = new Dialog(compatActivity);
//        this.dl.show("hello", "hi");

        this.myInfoSp = new SharedDB(this.compatActivity, "myInfo");
        Log.d("test", this.myInfoSp.getPrefer());

        this.bind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainOk:
                if (this.enterName.getText().toString().equals("")) {
                    Log.d("test", "enterName is empty");
                    break;
                } else if (this.enterBirthday.getText().toString().equals("")) {
                    Log.d("test", "enterBirthday is empty");
                    break;
                }
                this.infoMap.put("name", this.enterName.getText().toString());
                this.infoMap.put("birthday", this.enterBirthday.getText().toString());
                if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainMan) {
                    this.infoMap.put("gender", getResources().getString(R.string.user_man));
                } else if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainWoman) {
                    this.infoMap.put("gender", getResources().getString(R.string.user_woman));
                } else {
                    this.infoMap.put("gender", "empty");
                }
                this.myInfoSp.savePrefer(this.infoMap.toString());
                Log.d("test", this.myInfoSp.getPrefer());
                break;
        }
    }

    private void bind() {
        this.mainOk = findViewById(R.id.mainOk);
        this.mainOk.setOnClickListener(MainActivity.this);

        this.enterName = findViewById(R.id.mainEnterName);
        this.enterBirthday = findViewById(R.id.mainEnterBirthday);

        this.radioGroup = findViewById(R.id.mainRadioGroup);
    }
}
