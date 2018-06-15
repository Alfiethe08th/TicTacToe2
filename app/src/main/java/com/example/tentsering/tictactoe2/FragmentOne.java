package com.example.tentsering.tictactoe2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class FragmentOne extends Fragment {
    //public int turn;
    public ImageView imageView1, imageView2, playerA_pick, playerB_pick;
    public LinearLayout setMark, showMark;
    private String playerA_choice1 = "x", playerA_choice2 = "o";

    //interface
    SendMessage sendMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        imageView1 = (ImageView) view.findViewById(R.id.cross);
        imageView2 = (ImageView) view.findViewById(R.id.circle);


        playerA_pick = (ImageView) view.findViewById(R.id.playerA_choice);
        playerB_pick = (ImageView) view.findViewById(R.id.playerB_choice);


        setMark = (LinearLayout) view.findViewById(R.id.chose_mark);
        showMark = (LinearLayout) view.findViewById(R.id.show_mark);

        // from picking X or O, player A always picks first.
        // if player A clicks the cross/X then display this result
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerA_pick.setImageResource(R.drawable.ic_cross);
                playerB_pick.setImageResource(R.drawable.ic_circle);
                setMark.setVisibility(View.GONE);
                showMark.setVisibility(View.VISIBLE);

                sendMessage.sendDatatoTwo(playerA_choice1);
                Toast.makeText(getActivity(), "Player A chose: X", Toast.LENGTH_SHORT).show();
                //now i want to pass "X" to Fragment2, indicating that the Player A chose to be X.
            }
        });

        // if player A clicks the circle then display this result
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerA_pick.setImageResource(R.drawable.ic_circle);
                playerB_pick.setImageResource(R.drawable.ic_cross);
                setMark.setVisibility(View.GONE);
                showMark.setVisibility(View.VISIBLE);

                sendMessage.sendDatatoTwo(playerA_choice2);
                Toast.makeText(getActivity(), "Player A chose: O", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Create a interface to allow data transfer between FragmentOne to MainActivity to FragmentTwo.
     */
    interface SendMessage {
        void sendDatatoTwo(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    //to check whether the activity implement the method or not, we use try catch block
        try{
            sendMessage = (SendMessage) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException("Error in retrieving data!");
        }
    }
}
