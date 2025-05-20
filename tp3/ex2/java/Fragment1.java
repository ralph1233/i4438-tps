package com.example.tp3_ex2;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    EditText editText;
    Button showButton;
    OnNameSendListener listener;

    public interface OnNameSendListener {
        void onNameSend(String name);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNameSendListener) {
            listener = (OnNameSendListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnNameSendListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        editText = view.findViewById(R.id.editTextName);
        showButton = view.findViewById(R.id.buttonShow);

        showButton.setOnClickListener(v -> {
            String name = editText.getText().toString().trim();

            if(name.isEmpty()){
              Toast.makeText(getActivity(),"Please enter a name",Toast.LENGTH_SHORT).show();
              return;
            }
            
            listener.onNameSend(name);
        });

        return view;
    }
}
