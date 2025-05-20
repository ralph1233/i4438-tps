// MainActivity.java
package com.example.tp1_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioFrench, radioEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioFrench = findViewById(R.id.radioFrench);
        radioEnglish = findViewById(R.id.radioEnglish);
    }

    public void onShowButtonClick(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        
        // Pass language selection to ListActivity
        boolean isFrenchSelected = radioFrench.isChecked();
        boolean isEnglishSelected = radioEnglish.isChecked();

        if(!isFrenchSelected && !isEnglishSelected){
            Toast.makeText(MainActivity.this,"Please select a language",Toast.LENGTH_SHORT).show();
            return;
        }

        intent.putExtra("isFrenchSelected", isFrenchSelected);
        intent.putExtra("isEnglishSelected", isEnglishSelected);
        
        startActivity(intent);
    }
}
