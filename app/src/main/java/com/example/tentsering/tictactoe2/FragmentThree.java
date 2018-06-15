package com.example.tentsering.tictactoe2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentThree extends Fragment {
String thatScore;
int score;
TextView showScore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment3, container, false);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        showScore = (TextView) view.findViewById(R.id.player_Score);

        showScore.setText("The Score data " + "[ "+ score+ " ]"+" is not passed");


    }

    /**
     *
     * @param playerRes contains whether player A chose X or O.
     * @return
     */
    protected int getScore(int playerRes){
        score = playerRes;
        return score;
    }
}

