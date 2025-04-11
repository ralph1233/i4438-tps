package com.example.tp4_ex1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    String firstName = "";
    String lastName = "";
    String level = "";
    boolean showLevel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragmentOne();
    }

    public void showFragmentOne() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame1, new FragmentOne());
        ft.commit();
    }

    public void showFragmentTwo() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame2, new FragmentTwo());
        ft.commit();
    }

    public void showFragmentThree() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame3, new FragmentThree());
        ft.commit();
    }
}
