package com.example.akang2_emotilog;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emotion {
    private String emotion;
    private String timestamp;

    private Calendar calendar;
    SimpleDateFormat sdf;

    public Emotion(String emotion){
        this.emotion = emotion;
        calendar = Calendar.getInstance();
        sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.timestamp = sdf.format(calendar.getTime());
    }

    public String getEmotion(){ return emotion; }
    public void setEmotion(String emotion) {this.emotion = emotion;}
    public String getTimestamp(){ return timestamp; }
}
