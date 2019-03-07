package com.example.kmoon.my_history.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Json {
    private JSONObject jsonObject;
    private String result;

    public void init(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

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

    public String getString(String key) {
        try {
            this.result = this.jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.result;
    }
}
