package com.example.a2023_2024;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignupActivity extends Activity {
    private EditText etName;
    private RadioButton rbMobile,rbWeb;
    private CheckBox cbAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.etName);
        rbMobile = findViewById(R.id.rbMobile);
        rbWeb = findViewById(R.id.rbWeb);
        cbAgree = findViewById(R.id.cbAgree);
        Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!rbMobile.isChecked() && !rbWeb.isChecked()) {
                    Toast.makeText(SignupActivity.this, "Please select app type", Toast.LENGTH_SHORT).show();
                    return;
                }

                String appType = rbMobile.isChecked() ? "Mobile app" : "Web app";
                String agreement = cbAgree.isChecked() ? "Agree" : "Not agree";

                // Show the ListFragment
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, Fragment2.newInstance(name, appType, agreement))
                        .commit();
            }
        });
    }
}