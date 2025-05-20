// Fragment2.java
package com.example.tp2_ex3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private TextView firstNameTextView, lastNameTextView;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        TextView titleTextView = view.findViewById(R.id.textViewTitle);
        firstNameTextView = view.findViewById(R.id.textViewFirstName);
        lastNameTextView = view.findViewById(R.id.textViewLastName);

        // Get data from bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String firstName = bundle.getString("firstName", "");
            String lastName = bundle.getString("lastName", "");
            
            firstNameTextView.setText("First Name: " + firstName);
            lastNameTextView.setText("Last Name: " + lastName);
        }

        return view;
    }
}