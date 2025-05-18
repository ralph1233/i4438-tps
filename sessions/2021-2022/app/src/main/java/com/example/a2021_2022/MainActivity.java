package com.example.a2021_2022;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Spinner destinationSpinner;
    private TextView airlineTextView;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        destinationSpinner = findViewById(R.id.destinationSpinner);
        airlineTextView = findViewById(R.id.airlineTextView);
        okButton = findViewById(R.id.okButton);

        // Define destinations array directly in Java
        String[] destinations = {"None", "Beirut", "Paris", "Madrid"};

        // Setup spinner with the Java array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                destinations
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(adapter);

        destinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                if (selected.equals("None")) {
                    airlineTextView.setVisibility(View.GONE);
                } else {
                    String airline = "";
                    if (selected.equals("Beirut")) airline = "MEA";
                    else if (selected.equals("Paris")) airline = "Air France";
                    else if (selected.equals("Madrid")) airline = "Pegasus";
                    
                    airlineTextView.setText("Company Airline: " + airline);
                    airlineTextView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                airlineTextView.setVisibility(View.GONE);
            }
        });

        okButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }
    
            String destination = destinationSpinner.getSelectedItem().toString();
            if (destination.equals("None")) {
                Toast.makeText(this, "Please select a destination", Toast.LENGTH_SHORT).show();
                return;
            }
            String airline = "";
            
            if (destination.equals("Beirut")) airline = "MEA";
            else if (destination.equals("Paris")) airline = "Air France";
            else if (destination.equals("Madrid")) airline = "Pegasus";
            
            Fragment fragment1 = Fragment1.newInstance(name, destination, airline);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, fragment1);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    // Add this method to MainActivity
    public void resetAndCloseFragments() {
        // Clear back stack
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            
        // Reset values
        nameEditText.setText("");
        destinationSpinner.setSelection(0);
        airlineTextView.setVisibility(View.GONE);
    }
}