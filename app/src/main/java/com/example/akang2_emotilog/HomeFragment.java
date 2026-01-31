package com.example.akang2_emotilog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        SharedViewModel vm = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        Button emotButton1 = view.findViewById(R.id.emotion_button1);
        Button emotButton2 = view.findViewById(R.id.emotion_button2);
        Button emotButton3 = view.findViewById(R.id.emotion_button3);
        Button emotButton4 = view.findViewById(R.id.emotion_button4);
        Button emotButton5 = view.findViewById(R.id.emotion_button5);
        Button emotButton6 = view.findViewById(R.id.emotion_button6);
        Button emotButton7 = view.findViewById(R.id.emotion_button7);

        emotButton1.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton1.getText().toString())));
        emotButton2.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton2.getText().toString())));
        emotButton3.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton3.getText().toString())));
        emotButton4.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton4.getText().toString())));
        emotButton5.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton5.getText().toString())));
        emotButton6.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton6.getText().toString())));
        emotButton7.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton7.getText().toString())));

        return view;
    }
}