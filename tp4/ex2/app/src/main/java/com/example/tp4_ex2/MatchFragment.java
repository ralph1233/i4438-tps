package com.example.tp4_ex2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class MatchFragment extends Fragment {

  private EditText etPlayer1Name, etPlayer2Name;
  private EditText etPlayer1Set1, etPlayer1Set2;
  private EditText etPlayer2Set1, etPlayer2Set2;
  private Button btnResult;

  private OnMatchResultListener listener;

  public interface OnMatchResultListener {
    void onMatchResult(String winnerName);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getActivity() instanceof OnMatchResultListener) {
      listener = (OnMatchResultListener) getActivity();
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_match, container, false);

    // Initialize all EditText fields
    etPlayer1Name = view.findViewById(R.id.et_player1_name);
    etPlayer2Name = view.findViewById(R.id.et_player2_name);
    etPlayer1Set1 = view.findViewById(R.id.et_player1_set1);
    etPlayer1Set2 = view.findViewById(R.id.et_player1_set2);
    etPlayer2Set1 = view.findViewById(R.id.et_player2_set1);
    etPlayer2Set2 = view.findViewById(R.id.et_player2_set2);
    btnResult = view.findViewById(R.id.btn_result);

    // Set default player names as shown in the image
    etPlayer1Name.setText("Nadal");
    etPlayer2Name.setText("Federer");

    // Leave all score fields empty as per the image
    etPlayer1Set1.setText("");
    etPlayer1Set2.setText("");
    etPlayer2Set1.setText("");
    etPlayer2Set2.setText("");

    btnResult.setOnClickListener(v -> checkResult());

    return view;
  }

  private void checkResult() {
    String player1Name = etPlayer1Name.getText().toString();
    String player2Name = etPlayer2Name.getText().toString();

    // Validate that all score fields are filled
    if (etPlayer1Set1.getText().toString().isEmpty() ||
        etPlayer1Set2.getText().toString().isEmpty() ||
        etPlayer2Set1.getText().toString().isEmpty() ||
        etPlayer2Set2.getText().toString().isEmpty()) {
      Toast.makeText(getActivity(), "Please fill all score fields", Toast.LENGTH_SHORT).show();
      return;
    }

    int player1Set1 = Integer.parseInt(etPlayer1Set1.getText().toString());
    int player1Set2 = Integer.parseInt(etPlayer1Set2.getText().toString());
    int player2Set1 = Integer.parseInt(etPlayer2Set1.getText().toString());
    int player2Set2 = Integer.parseInt(etPlayer2Set2.getText().toString());

    boolean player1WinsSet1 = player1Set1 > player2Set1;
    boolean player1WinsSet2 = player1Set2 > player2Set2;

    if (player1WinsSet1 && player1WinsSet2) {
      listener.onMatchResult(player1Name);
    } else if (!player1WinsSet1 && !player1WinsSet2) {
      listener.onMatchResult(player2Name);
    } else {
      Toast.makeText(getActivity(), "Only one Player must win", Toast.LENGTH_SHORT).show();
    }
  }
}