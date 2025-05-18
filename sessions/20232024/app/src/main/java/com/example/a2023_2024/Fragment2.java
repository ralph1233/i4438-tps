package com.example.a2023_2024;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Fragment2 extends ListFragment {
    private static final String ARG_NAME = "name";
    private static final String ARG_APP_TYPE = "appType";
    private static final String ARG_AGREEMENT = "agreement";

    public static Fragment2 newInstance(String name, String appType, String agreement) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_APP_TYPE, appType);
        args.putString(ARG_AGREEMENT, agreement);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        String name = args.getString(ARG_NAME);
        String appType = args.getString(ARG_APP_TYPE);
        String agreement = args.getString(ARG_AGREEMENT);

        ArrayList<String> items = new ArrayList<>();
        items.add(name);
        items.add(appType);
        items.add(agreement);

        setListAdapter(new ArrayAdapter<>(getActivity(), 
                android.R.layout.simple_list_item_1, items));
    }
}