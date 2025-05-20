package com.example.ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WeightActivity extends AppCompatActivity {

    TextView helloTextView;
    EditText weightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        helloTextView = findViewById(R.id.textViewHello);
        weightEditText = findViewById(R.id.weightEditText);
        Button addHeightButton = findViewById(R.id.addHeightButton);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        helloTextView.setText("Hello " + name);

        addHeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = weightEditText.getText().toString().trim();
                if(weight.isEmpty()){
                  Toast.makeText(WeightActivity.this, "Please enter your weight", Toast.LENGTH_SHORT).show();
                  return;
                }
                Intent intent = new Intent(WeightActivity.this, HeightActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("weight", weight);
                startActivity(intent);
            }
        });
    }
}
