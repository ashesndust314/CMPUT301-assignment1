package com.example.akang2_emotilog;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<List<Emotion>> dataList = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<Map<String, Integer>> emotCount = new MutableLiveData<>(new HashMap<>());
    public LiveData<List<Emotion>> getItems(){ return dataList; }
    public LiveData<Map<String, Integer>> getCounts(){ return emotCount; }
    public void addEmot(Emotion emot){
        List<Emotion> current = new ArrayList<>(dataList.getValue());
        current.add(emot);
        dataList.setValue(current);
        Log.i("Emotion Added", "Added emotion" + emot.getEmotion());

        Map<String, Integer> newCounts = new HashMap<>(emotCount.getValue());
        newCounts.put(emot.getEmotion(), newCounts.getOrDefault(emot.getEmotion(), 0) + 1);
        emotCount.setValue(newCounts);
        Log.i("Emotion Count Update", emot.getEmotion() + newCounts.get(emot.getEmotion()));
    }
}
