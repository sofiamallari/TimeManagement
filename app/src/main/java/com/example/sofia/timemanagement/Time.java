package com.example.sofia.timemanagement;

/**
 * Created by Sofia on 30/11/2018.
 */

public class Time {
    String date;
    String time;
    String id;

    public Time(){}

    public Time(String id, String date, String time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

