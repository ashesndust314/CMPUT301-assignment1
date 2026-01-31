package com.example.akang2_emotilog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class EditButtonsFragment extends DialogFragment {
    public interface EditButtonsDialogListener {
        void editButtons(ArrayList<String> emotes);
    }
    private EditButtonsDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Fragment parent = getParentFragment();

        if (parent instanceof EditButtonsDialogListener){
            listener = (EditButtonsDialogListener) parent;
        } else {
            throw new RuntimeException(parent + " must implement EditButtonsDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_edit_emotes, null);

        EditText button1 = view.findViewById(R.id.edit_button1);
        EditText button2 = view.findViewById(R.id.edit_button2);
        EditText button3 = view.findViewById(R.id.edit_button3);
        EditText button4 = view.findViewById(R.id.edit_button4);
        EditText button5 = view.findViewById(R.id.edit_button5);
        EditText button6 = view.findViewById(R.id.edit_button6);
        EditText button7 = view.findViewById(R.id.edit_button7);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Customize your buttons!")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", (dialog, which) -> {
                    ArrayList<String> emotes = new ArrayList<>();
                    emotes.add(button1.getText().toString());
                    emotes.add(button2.getText().toString());
                    emotes.add(button3.getText().toString());
                    emotes.add(button4.getText().toString());
                    emotes.add(button5.getText().toString());
                    emotes.add(button6.getText().toString());
                    emotes.add(button7.getText().toString());
                    listener.editButtons(emotes);
                })
                .create();

    }
}
