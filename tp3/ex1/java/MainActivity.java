package com.example.tp3_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonShow;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonShow = findViewById(R.id.buttonShow);
        frameLayout = findViewById(R.id.frameLayout);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString().trim();

                if(message.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter a message",Toast.LENGTH_SHORT).show();
                    return;
                }

                Fragment1 fragment1 = new Fragment1();
                Bundle bundle = new Bundle();
                bundle.putString("message", message);
                fragment1.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, fragment1);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
