package com.example.tp2_ex2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    private TextView nameTextView, profileTextView;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        
        nameTextView = view.findViewById(R.id.nameTextView);
        profileTextView = view.findViewById(R.id.profileTextView);
        
        return view;
    }
    
    // Function to update details (with 2 parameters as required)
    public void updateDetails(String name, String profile) {
        nameTextView.setText("Name: " + name);
        profileTextView.setText("Profile: " + profile);
    }
}