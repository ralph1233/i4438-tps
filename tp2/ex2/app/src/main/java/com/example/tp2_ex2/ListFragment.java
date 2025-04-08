package com.example.tp2_ex2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    private ListView listView;
    private String[] names = {"Fadi", "Pierre", "Roza", "Mira", "Jean"};
    private String[] profiles = {"Admin", "User", "Student", "Employee", "Teacher"};

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        
        listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(), 
                android.R.layout.simple_list_item_1, 
                names);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = names[position];
                String selectedProfile = profiles[position];
                
                // Get the DetailFragment instance
                DetailFragment detailFragment = (DetailFragment) getFragmentManager()
                        .findFragmentById(R.id.detailFragment);
                
                // Call the function to update details
                if (detailFragment != null) {
                    detailFragment.updateDetails(selectedName, selectedProfile);
                }
            }
        });
        
        return view;
    }
}