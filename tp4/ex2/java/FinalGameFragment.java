package com.example.tp4_ex2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FinalGameFragment extends Fragment {

  private static final String ARG_WINNER_NAME = "winner_name";
  private static final String ARG_DATE = "date";

  public static FinalGameFragment newInstance(String winnerName, String date) {
    FinalGameFragment fragment = new FinalGameFragment();
    Bundle args = new Bundle();
    args.putString(ARG_WINNER_NAME, winnerName);
    args.putString(ARG_DATE, date);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_final_game, container, false);

    String winnerName = getArguments().getString(ARG_WINNER_NAME);
    String date = getArguments().getString(ARG_DATE);

    TextView tvFinalGame = view.findViewById(R.id.tv_final_game);
    tvFinalGame.setText(winnerName + " plays the final game on " + date);

    return view;
  }
}