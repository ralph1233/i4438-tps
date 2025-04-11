package com.example.tp4_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements MatchFragment.OnMatchResultListener, WinnerFragment.OnDateSubmittedListener {

    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = findViewById(R.id.fragment_container);

        // Load the initial match fragment
        loadFragment(new MatchFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onMatchResult(String winnerName) {
        // Called when a player wins both sets
        loadFragment(WinnerFragment.newInstance(winnerName));
    }

    @Override
    public void onDateSubmitted(String winnerName, String date) {
        // Called when date is submitted
        loadFragment(FinalGameFragment.newInstance(winnerName, date));
    }
}