package com.example.a2021_2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_DESTINATION = "destination";
    private static final String ARG_AIRLINE = "airline";

    public static Fragment1 newInstance(String name, String destination, String airline) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_DESTINATION, destination);
        args.putString(ARG_AIRLINE, airline);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        TextView infoTextView = view.findViewById(R.id.infoTextView);
        RadioGroup classRadioGroup = view.findViewById(R.id.classRadioGroup);
        CheckBox confirmCheckBox = view.findViewById(R.id.confirmCheckBox);
        Button validateButton = view.findViewById(R.id.validateButton);

        Bundle args = getArguments();
        String name = args.getString(ARG_NAME);
        String destination = args.getString(ARG_DESTINATION);
        String airline = args.getString(ARG_AIRLINE);

        infoTextView.setText("Hello " + name + " your destination is " + destination + " with the company " + airline);

        validateButton.setOnClickListener(v -> {
            String selectedClass = "";
            boolean isConfirmed = confirmCheckBox.isChecked();
            int selectedId = classRadioGroup.getCheckedRadioButtonId();
    
            if (isConfirmed && selectedId == -1) {
                Toast.makeText(getContext(), "Please select a class", Toast.LENGTH_SHORT).show();
                return;
            }
                    
            if (selectedId == R.id.businessRadioButton) {
                selectedClass = "Business class";
            } else if (selectedId == R.id.economicRadioButton) {
                selectedClass = "Economic class";
            }
            
            Fragment fragment2 = Fragment2.newInstance(name, destination, airline, selectedClass, isConfirmed);
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragment2)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}