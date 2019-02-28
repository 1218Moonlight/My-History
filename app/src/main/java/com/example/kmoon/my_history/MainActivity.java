package com.example.kmoon.my_history;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends DefaultActivity implements View.OnClickListener {

    protected Button mainOk;
    protected EditText enterName, enterBirthday;
    protected RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.bind();

        Log.d("testtest", this.myInfoSp.getPrefer());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainOk:
                if (this.enterName.getText().toString().equals("")) {
                    Toast.makeText(this, getResources().getString(R.string.user_name), Toast.LENGTH_SHORT).show();
                    break;
                } else if (this.enterBirthday.getText().toString().equals("")) {
                    Toast.makeText(this, getResources().getString(R.string.user_birthday), Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, getResources().getString(R.string.user_complete), Toast.LENGTH_SHORT).show();
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
