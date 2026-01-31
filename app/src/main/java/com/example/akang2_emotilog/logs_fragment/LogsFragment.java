package com.example.akang2_emotilog.logs_fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.akang2_emotilog.Emotion;
import com.example.akang2_emotilog.R;
import com.example.akang2_emotilog.SharedViewModel;

import java.util.ArrayList;

public class LogsFragment extends Fragment {
    private EmotionArrayAdapter emotAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logs, container, false);

        ListView emotList = view.findViewById(R.id.emotion_logs);

        emotAdapter = new EmotionArrayAdapter(requireContext(), new ArrayList<>());
        emotList.setAdapter(emotAdapter);

        SharedViewModel vm = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        vm.getItems().observe(getViewLifecycleOwner(), emots -> {
            Log.d("Observer", "List size: " + emots.size());
            emotAdapter.clear();
            emotAdapter.addAll(emots);
            emotAdapter.notifyDataSetChanged();
        });

        return view;
    }
}