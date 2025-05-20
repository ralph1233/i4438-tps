package com.example.ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    Button addWeightButton;
    TextView bmiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        addWeightButton = findViewById(R.id.addWeightButton);
        bmiTextView = findViewById(R.id.bmiTextView);

        addWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                if(name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, WeightActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        // Display BMI if passed from HeightActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("name") && intent.hasExtra("bmi")) {
            String name = intent.getStringExtra("name");
            double bmi = intent.getDoubleExtra("bmi", 0);  // Default value of 0 if bmi not found

            Toast.makeText(MainActivity.this, "Test " + name + " "+bmi, Toast.LENGTH_SHORT).show();
            bmiTextView.setText("Hello " + name + ", your BMI is: " + String.format("%.2f", bmi)); // Format BMI to 2 decimal places
            bmiTextView.setVisibility(View.VISIBLE);  // Change visibility to visible
        }
    }
}
