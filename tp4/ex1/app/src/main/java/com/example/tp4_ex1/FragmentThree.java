package com.example.tp4_ex1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {
    TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        tvResult = view.findViewById(R.id.tvResult);
        MainActivity activity = (MainActivity) getActivity();

        if (activity != null) {
            if (activity.showLevel) {
                tvResult.setText("Your level is: " + activity.level);
            } else {
                tvResult.setText("We can't show your level");
            }
        }

        return view;
    }
}
