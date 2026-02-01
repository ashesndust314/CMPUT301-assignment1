package com.example.akang2_emotilog.logs_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.akang2_emotilog.Emotion;
import com.example.akang2_emotilog.R;

import java.util.ArrayList;

public class EmotionArrayAdapter extends ArrayAdapter<Emotion> {

    public EmotionArrayAdapter(android.content.Context context, ArrayList<Emotion> emotions){
        super(context, 0, emotions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.content, parent, false);
        } else {
            view = convertView;
        }

        Emotion emotion = getItem(position);
        TextView emotionName = view.findViewById(R.id.emote_text);
        TextView timestamp = view.findViewById(R.id.timestamp_text);

        emotionName.setText(emotion.getEmotion());
        timestamp.setText(emotion.getTimestamp());

        return view;
    }
}
