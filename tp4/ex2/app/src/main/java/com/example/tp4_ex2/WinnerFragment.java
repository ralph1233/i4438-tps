package com.example.tp4_ex2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class WinnerFragment extends Fragment {

  private static final String ARG_WINNER_NAME = "winner_name";

  public static WinnerFragment newInstance(String winnerName) {
    WinnerFragment fragment = new WinnerFragment();
    Bundle args = new Bundle();
    args.putString(ARG_WINNER_NAME, winnerName);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_winner, container, false);

    String winnerName = getArguments().getString(ARG_WINNER_NAME);

    TextView tvWinner = view.findViewById(R.id.tv_winner);
    EditText etDate = view.findViewById(R.id.et_date);
    Button btnOk = view.findViewById(R.id.btn_ok);

    tvWinner.setText("The winner is " + winnerName);

    btnOk.setOnClickListener(v -> {
      String date = etDate.getText().toString().trim();
      if (date.isEmpty()) {
        etDate.setError("Please enter a date");
        return;
      }

      if (getActivity() instanceof OnDateSubmittedListener) {
        ((OnDateSubmittedListener) getActivity()).onDateSubmitted(winnerName, date);
      }
    });

    return view;
  }

  public interface OnDateSubmittedListener {
    void onDateSubmitted(String winnerName, String date);
  }
}