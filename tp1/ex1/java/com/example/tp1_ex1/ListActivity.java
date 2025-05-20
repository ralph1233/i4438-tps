// ListActivity.java
package com.example.tp1_ex1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private boolean isFrenchSelected,isEnglishSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Retrieve language selection from MainActivity
        isFrenchSelected = getIntent().getBooleanExtra("isFrenchSelected", true);
        isEnglishSelected = getIntent().getBooleanExtra("isEnglishSelected", true);

        listView = findViewById(R.id.listView);

        // Set appropriate list items based on language selection
        ArrayList<String> items = new ArrayList<>();
        if (isFrenchSelected) {
            items.add("Voiture");
            items.add("Maison");
            items.add("Ecole");
            items.add("Banque");
        } else if(isEnglishSelected) {
            items.add("Car");
            items.add("House");
            items.add("School");
            items.add("Bank");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }
}
