package com.example.tp4_ex1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {
    EditText etFirstName, etLastName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        etFirstName = view.findViewById(R.id.etFirstName);
        etLastName = view.findViewById(R.id.etLastName);
        Button btnNext = view.findViewById(R.id.btnNext1);

        btnNext.setOnClickListener(v -> {
            MainActivity activity = (MainActivity) getActivity();
            if (activity != null) {
                activity.firstName = etFirstName.getText().toString().trim();
                activity.lastName = etLastName.getText().toString().trim();
                if (activity.firstName.isEmpty() || activity.lastName.isEmpty()) {
                    Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }
                activity.showFragmentTwo();
            }
        });

        return view;
    }
}
