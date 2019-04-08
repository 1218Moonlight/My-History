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
    protected String selectDate;
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
                    Toast.makeText(this, getString(R.string.user_name_info), Toast.LENGTH_SHORT).show();
                    break;
                } else if (this.selectDate.equals(getString(R.string.default_empty))) {
                    Toast.makeText(this, getString(R.string.user_birthday_info), Toast.LENGTH_SHORT).show();
                    break;
                }
                this.myinfoJson.put(getString(R.string.user_name), this.enterName.getText().toString());
                this.myinfoJson.put(getString(R.string.user_birthday), selectDate);
                if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainMan) {
                    this.myinfoJson.put(getString(R.string.user_gender), getString(R.string.user_man));
                } else if (this.radioGroup.getCheckedRadioButtonId() == R.id.mainWoman) {
                    this.myinfoJson.put(getString(R.string.user_gender), getString(R.string.user_woman));
                } else {
                    this.myinfoJson.put(getString(R.string.user_gender), getString(R.string.default_empty));
                }
                this.myInfoSp.savePrefer(this.myinfoJson.toString());
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

        this.selectDate = getString(R.string.default_empty);

        this.datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectDate = "" + year + "-" + (month + 1) + "-" + dayOfMonth;
                Toast.makeText(getApplicationContext(), year + getString(R.string.date_year) +
                        (month + 1) + getString(R.string.date_month) + dayOfMonth +
                        getString(R.string.date_dayOfMonth), Toast.LENGTH_SHORT).show();
            }
        }, 1988, 0, 1);
    }
}
