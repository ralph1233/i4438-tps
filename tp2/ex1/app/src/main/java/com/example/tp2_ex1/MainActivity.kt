package com.example.tp2_ex1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var buttonFragment1: Button
    private lateinit var buttonFragment2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons using findViewById
        buttonFragment1 = findViewById(R.id.buttonFragment1)
        buttonFragment2 = findViewById(R.id.buttonFragment2)

        // Load default fragment
        replaceFragment(FragmentOne())

        // Button click listeners
        buttonFragment1.setOnClickListener {
            replaceFragment(FragmentOne())
        }

        buttonFragment2.setOnClickListener {
            replaceFragment(FragmentTwo())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
