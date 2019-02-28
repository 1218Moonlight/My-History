package com.example.kmoon.my_history;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class OnBackPressedHandler {
    private AppCompatActivity compatActivity;
    private Toast toast;
    private long backTime = 0;

    public OnBackPressedHandler(AppCompatActivity compatActivity) {
        this.compatActivity = compatActivity;
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() > this.backTime + 2000) {
            backTime = System.currentTimeMillis();
            checkToast();
            return;
        }
        if (System.currentTimeMillis() <= this.backTime + 2000) {
            this.compatActivity.finish();
            this.toast.cancel();
        }
    }

    public void checkToast() {
        this.toast = Toast.makeText(this.compatActivity,
                this.compatActivity.getResources().getString(R.string.default_check_onBackPressed),
                Toast.LENGTH_SHORT);
        this.toast.show();
    }
}
