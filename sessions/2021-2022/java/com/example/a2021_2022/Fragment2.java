package com.example.a2021_2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_DESTINATION = "destination";
    private static final String ARG_AIRLINE = "airline";
    private static final String ARG_CLASS = "class";
    private static final String ARG_CONFIRMED = "confirmed";

    public static Fragment2 newInstance(String name, String destination, String airline, 
                                      String flightClass, boolean confirmed) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_DESTINATION, destination);
        args.putString(ARG_AIRLINE, airline);
        args.putString(ARG_CLASS, flightClass);
        args.putBoolean(ARG_CONFIRMED, confirmed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        TextView welcomeTextView = view.findViewById(R.id.welcomeTextView);
        Button closeButton = view.findViewById(R.id.closeButton);

        Bundle args = getArguments();
        boolean confirmed = args.getBoolean(ARG_CONFIRMED);
        String flightClass = args.getString(ARG_CLASS);

        if (confirmed) {
            welcomeTextView.setText("Welcome, you are in " + flightClass);
        } else {
            welcomeTextView.setText("You have 24 hours to confirm");
        }

      closeButton.setOnClickListener(v -> {
          ((MainActivity)requireActivity()).resetAndCloseFragments();
      });

        return view;
    }
}