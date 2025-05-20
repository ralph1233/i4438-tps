package com.example.ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HeightActivity extends AppCompatActivity {

    TextView helloTextView, weightTextView;
    EditText heightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);

        helloTextView = findViewById(R.id.textViewHello);
        weightTextView = findViewById(R.id.textViewWeight);
        heightEditText = findViewById(R.id.heightEditText);
        Button showBMIButton = findViewById(R.id.showBMIButton);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String weight = intent.getStringExtra("weight");

        helloTextView.setText("Hello " + name);
        weightTextView.setText("Your weight is: " + weight + " Kg");

        showBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = heightEditText.getText().toString();
                if(height.isEmpty()){
                  Toast.makeText(HeightActivity.this, "Please enter your height", Toast.LENGTH_SHORT).show();
                  return;
                }
                double heightMeters = Double.parseDouble(height);
                double weightKg = Double.parseDouble(weight);
                double bmi = weightKg / (heightMeters * heightMeters);


                Intent intent = new Intent(HeightActivity.this, MainActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("bmi", bmi);
                startActivity(intent);
            }
        });
    }
}
