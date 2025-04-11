package com.example.tp3_ex2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment1.OnNameSendListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    // This is triggered from Fragment1
    @Override
    public void onNameSend(String name) {
        textView.setText("Your name is " + name);
    }
}
