package com.example.akang2_emotilog;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emotion {
    private String emotion;
    private String timestamp;

    public Emotion(String emotion){
        this.emotion = emotion;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.timestamp = sdf.format(calendar.getTime());
    }

    public String getEmotion(){ return emotion; }
    public String getTimestamp(){ return timestamp; }
}
