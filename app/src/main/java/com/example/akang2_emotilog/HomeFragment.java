package com.example.akang2_emotilog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements EditButtonsFragment.EditButtonsDialogListener {
    private Button emotButton1;
    private Button emotButton2;
    private Button emotButton3;
    private Button emotButton4;
    private Button emotButton5;
    private Button emotButton6;
    private Button emotButton7;
    private FloatingActionButton fab;
    @Override
    public void editButtons(ArrayList<String> emotes) {
        if (!emotes.get(0).isEmpty()){ emotButton1.setText(emotes.get(0)); }
        if (!emotes.get(1).isEmpty()){ emotButton2.setText(emotes.get(1)); }
        if (!emotes.get(2).isEmpty()){ emotButton3.setText(emotes.get(2)); }
        if (!emotes.get(3).isEmpty()){ emotButton4.setText(emotes.get(3)); }
        if (!emotes.get(4).isEmpty()){ emotButton5.setText(emotes.get(4)); }
        if (!emotes.get(5).isEmpty()){ emotButton6.setText(emotes.get(5)); }
        if (!emotes.get(6).isEmpty()){ emotButton7.setText(emotes.get(6)); }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        EmoteSharedData vm = new ViewModelProvider(requireActivity()).get(EmoteSharedData.class);

        emotButton1 = view.findViewById(R.id.emotion_button1);
        emotButton2 = view.findViewById(R.id.emotion_button2);
        emotButton3 = view.findViewById(R.id.emotion_button3);
        emotButton4 = view.findViewById(R.id.emotion_button4);
        emotButton5 = view.findViewById(R.id.emotion_button5);
        emotButton6 = view.findViewById(R.id.emotion_button6);
        emotButton7 = view.findViewById(R.id.emotion_button7);

        emotButton1.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton1.getText().toString())));
        emotButton2.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton2.getText().toString())));
        emotButton3.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton3.getText().toString())));
        emotButton4.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton4.getText().toString())));
        emotButton5.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton5.getText().toString())));
        emotButton6.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton6.getText().toString())));
        emotButton7.setOnClickListener(v -> vm.addEmot(new Emotion(emotButton7.getText().toString())));

        fab = view.findViewById(R.id.edit_buttons_fab);
        fab.setOnClickListener(v -> {
            new EditButtonsFragment().show(getChildFragmentManager(), "Edit Buttons");
        });
        return view;
    }
}