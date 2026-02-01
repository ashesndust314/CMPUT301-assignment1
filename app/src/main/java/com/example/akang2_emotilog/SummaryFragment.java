package com.example.akang2_emotilog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class SummaryFragment extends Fragment {
    private EmoteSharedData vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        LinearLayout sum_container = view.findViewById(R.id.summary_container);

        vm = new ViewModelProvider(requireActivity()).get(EmoteSharedData.class);

        vm.getCounts().observe(getViewLifecycleOwner(), counts -> {
            sum_container.removeAllViews();

            for (Map.Entry<String, Integer> entry : counts.entrySet()){
                TextView txt = new TextView(requireContext());
                txt.setText(entry.getKey() + " logged " + entry.getValue() + " time(s)");
                txt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                txt.setTextSize(30);
                txt.setPadding(0, 16, 0, 16);
                sum_container.addView(txt);
            }
        });

        return view;
    }
}