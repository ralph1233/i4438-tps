package com.example.a2023_2024;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tvStatus;
    private static final int LOGIN_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        Button btnLogin = findViewById(R.id.btnLogin);

        // Add SignUpFragment
        getFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, new Fragment1())
                .commit();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, LOGIN_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOGIN_REQUEST) {
            if (resultCode == RESULT_OK) {
                String username = data.getStringExtra("username");
                tvStatus.setText(username + " you are connected");
            } else if (resultCode == RESULT_CANCELED) {
                tvStatus.setText("You are not connected");
            }
        }
    }
}