package com.example.kmoon.my_history.utils;

import java.util.Calendar;

public class age {

    private int year, month, date;

    public age(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public int ageDiff() {
        Calendar cal = Calendar.getInstance();

        // today[0] == year
        // today[1] == month
        // today[2] == date
        int[] today = this.getToday();

        int dateCount1 = 0, dateCount2 = 0, yearDiff = 0, dayDiff = 0;
        if (this.year > today[0]) {
            for (int i = today[0]; i < this.year; i++) {
                cal.set(i, 12, 0);
                yearDiff += cal.get(Calendar.DAY_OF_YEAR);
            }
            dateCount1 += yearDiff;
        } else if (this.year < today[0]) {
            for (int i = this.year; i < today[0]; i++) {
                cal.set(i, 12, 0);
                yearDiff += cal.get(Calendar.DAY_OF_YEAR);
            }
            dateCount2 += yearDiff;
        }
        cal.set(this.year, this.month - 1, this.date);
        dayDiff = cal.get(Calendar.DAY_OF_YEAR);
        dateCount1 += dayDiff;
        cal.set(today[0], today[1] - 1, today[2]);
        dayDiff = cal.get(Calendar.DAY_OF_YEAR);
        dateCount2 += dayDiff;
        return dateCount1 - dateCount2;
    }

    private int[] getToday() {
        int[] date = new int[3];
        Calendar currentCal = Calendar.getInstance();

        currentCal.add(Calendar.DATE, 0);

        date[0] = currentCal.get(Calendar.YEAR);
        date[1] = currentCal.get(Calendar.MONTH) + 1;
        date[2] = currentCal.get(Calendar.DAY_OF_MONTH);

        return date;
    }
}
