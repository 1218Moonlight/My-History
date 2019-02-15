package com.example.kmoon.my_history;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button mainOk;
    protected EditText enterName, enterBirthday;
    protected RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind();
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
                Log.d("test", this.enterName.getText().toString());
                Log.d("test", this.enterBirthday.getText().toString());
                if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainMan) {
                    Log.d("test", "남자");
                } else if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainWoman){
                    Log.d("test", "여자");
                } else {
                    Log.d("test", "성별 미선택");
                }
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
