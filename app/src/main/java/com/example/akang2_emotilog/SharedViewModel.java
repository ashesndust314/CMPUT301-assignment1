package com.example.akang2_emotilog;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<List<Emotion>> dataList = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Emotion>> getItems(){ return dataList; }
    public void addEmot(Emotion emot){
        List<Emotion> current = new ArrayList<>(dataList.getValue());
        current.add(emot);
        dataList.setValue(current);
        Log.i("Emotion Added", "Added emotion" + emot.getEmotion());
    }
}
