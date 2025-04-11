package com.example.tp4_ex1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {
    RadioButton rbBeginner, rbExpert;
    CheckBox cbShowLevel;
    TextView tvDisplayName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        rbBeginner = view.findViewById(R.id.rbBeginner);
        rbExpert = view.findViewById(R.id.rbExpert);
        cbShowLevel = view.findViewById(R.id.cbShowLevel);
        tvDisplayName = view.findViewById(R.id.tvDisplayName);
        Button btnNext = view.findViewById(R.id.btnNext2);

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            tvDisplayName.setText(activity.firstName + " " + activity.lastName);
        }

        btnNext.setOnClickListener(v -> {
            if (activity != null) {
                activity.showLevel = cbShowLevel.isChecked();
                if (rbBeginner.isChecked())
                    activity.level = "Beginner";
                else if (rbExpert.isChecked())
                    activity.level = "Expert";
                activity.showFragmentThree();
            }
        });

        return view;
    }
}
