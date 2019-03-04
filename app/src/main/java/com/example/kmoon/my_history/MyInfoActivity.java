package com.example.kmoon.my_history;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.kmoon.my_history.base.DefaultActivity;

public class MyInfoActivity extends DefaultActivity implements View.OnClickListener {
    protected Button mainOk, birthBtn;
    protected EditText enterName;
    protected RadioGroup radioGroup;
    protected String selectDate = "empty";
    protected DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_myinfo);

        this.bind();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainOk:
                if (this.enterName.getText().toString().equals("")) {
                    Toast.makeText(this, getString(R.string.user_name), Toast.LENGTH_SHORT).show();
                    break;
                } else if (this.selectDate.equals("empty")) {
                    Toast.makeText(this, getString(R.string.user_birthday), Toast.LENGTH_SHORT).show();
                    break;
                }
                this.infoMap.put("name", this.enterName.getText().toString());
                this.infoMap.put("birthday", selectDate);
                if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainMan) {
                    this.infoMap.put("gender", getString(R.string.user_man));
                } else if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainWoman) {
                    this.infoMap.put("gender", getString(R.string.user_woman));
                } else {
                    this.infoMap.put("gender", "empty");
                }
                this.myInfoSp.savePrefer(this.infoMap.toString());
                Toast.makeText(this, getString(R.string.user_complete), Toast.LENGTH_SHORT).show();
                this.startActivityIntent(MainActivity.class);
                break;

            case R.id.mainBirthdayBtn:
                datePickerDialog.show();
                break;
        }
    }

    private void bind() {
        this.mainOk = findViewById(R.id.mainOk);
        this.mainOk.setOnClickListener(this);

        this.birthBtn = findViewById(R.id.mainBirthdayBtn);
        this.birthBtn.setOnClickListener(this);

        this.enterName = findViewById(R.id.mainEnterName);

        this.radioGroup = findViewById(R.id.mainRadioGroup);

        this.datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectDate = "" + year + "-" + month + "-" + dayOfMonth;
                Toast.makeText(getApplicationContext(), year + "년" + month + "월" + dayOfMonth + "일", Toast.LENGTH_SHORT).show();
            }
        }, 1988, 1, 1);
    }
}
