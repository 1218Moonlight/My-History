package com.example.kmoon.my_history.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Json {
    private JSONObject jsonObject = new JSONObject();

    public void put(String key, String value) {
        try {
            this.jsonObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return this.jsonObject.toString();
    }
}
