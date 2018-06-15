package com.example.tentsering.tictactoe2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FragmentTwo extends Fragment {

    private ImageView[] mBlock = new ImageView[9];        //Nine cells that when clicked will display either X or O
    String playerAChoice;                                 //Variable to store whether user picked X or O
    TextView txtData;                                     //To display what did user chose, X or O
    ImageView playAgain, terminate;                       //To play again(affects only this fragment) or terminate the game
    private int mStatusCounter;                           //To store number of clicks or how many cells have been marked already
    private View view;                                    //To display out of 8 different lines that will cover three cells when user wins!
    private static final int CROSS = 2;                   //to change image id when user clicks on it, mBlock[int anyNumber].setId(CROSS)
    private static final int CIRCLE = 1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.activity_fragment2, container, false);
        txtData = (TextView) rootView.findViewById(R.id.txtData);

        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Restarts the FragmentTwo
        playAgain = (ImageView) view.findViewById(R.id.replay);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().detach(FragmentTwo.this).attach(FragmentTwo.this).commit();
            }
        });

        //Close the App Entirely
        terminate = (ImageView) view.findViewById(R.id.exit);
        terminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                System.exit(0);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        //Starts the Game
        initiateDisplay();
    }


    /**
     * This method includes, setting up X or O to take turn and play, determines if three cells matches and then display a line over those
     * three cells that are match whether its horizontal, vertical or diagonal. And finally announcing who wins, or whether it's a draw.
     */
    private void initiateDisplay() {

        for (int position = 0; position < 9; position++) {
            int resId = getResources().getIdentifier("block_" + (position + 1), "id", getActivity().getPackageName());
            mBlock[position] = (ImageView) getView().findViewById(resId);


            final int finalPosition = position; // so that the variable can be used inside the onclicklistener method.

            mBlock[position].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mStatusCounter++;
                    switchTurn(finalPosition, mStatusCounter);
                    declareWinner(finalPosition);
                }
            });
        }
    }

    /** This method allows user to be either be X or O and allows playe to take turn instead of X or O always appearing on every click on every cell.
     * @param position, or can say the cell position: cell-1, cell-2, cell-3, you get the idea.
     */
    private void switchTurn(int position, int cellMarked) {

        if (mBlock[position]!=null && playerAChoice.equals("o")) {
            if (mBlock[position]!=null && cellMarked % 2 == 0) {
                mBlock[position].setImageResource(R.drawable.cross);
                mBlock[position].setId(CROSS);
            } else {
                mBlock[position].setImageResource(R.drawable.circular_ring);
                mBlock[position].setId(CIRCLE);
            }
        }
        if(mBlock[position]!=null && playerAChoice.equals("x")){
            if (cellMarked % 2 == 0) {
                mBlock[position].setImageResource(R.drawable.circular_ring);
                mBlock[position].setId(CIRCLE);
            } else {
                mBlock[position].setImageResource(R.drawable.cross);
                mBlock[position].setId(CROSS);
            }
        }

        mBlock[position].setEnabled(false);


    }


    /**
     * this method will display the line across 3 cells, when the player wins
     *
     * @param mSet, out of 8 different ways a player can win
     */
    private void displayStick(int mSet) {

        switch (mSet) {
            case 1:
                view = getView().findViewById(R.id.set1);
                break;
            case 2:
                view = getView().findViewById(R.id.set2);
                break;
            case 3:
                view = getView().findViewById(R.id.set3);
                break;
            case 4:
                view = getView().findViewById(R.id.set4);
                break;
            case 5:
                view = getView().findViewById(R.id.set5);
                break;
            case 6:
                view = getView().findViewById(R.id.set6);
                break;
            case 7:
                view = getView().findViewById(R.id.set7);
                break;
            case 8:
                view = getView().findViewById(R.id.set8);
                break;
            default:
                view = getView().findViewById(R.id.set1);
        }
        view.setVisibility(View.VISIBLE);
    }


    /**
     * allowing only one click on the cell not confusing the app with multiple clicks
     */
    private void disableAll() {
        for (int i = 0; i < 9; i++) {
            mBlock[i].setEnabled(false);
        }
    }


    /**
     * @param message send from FragmentOne, whether the user clicked X or O
     * @return playerAchoice, which will be then use in FragmentTwo for all other purpose
     */
    protected String getReceivedMessage(String message) {
        playerAChoice = message;
        return playerAChoice;
    }



    /**
     * @param message send from FragmentOne, whether the user clicked X or O, which will
     *                be displayed on FragmentTwo layout.
     */
    public void displayReceivedData(String message) {
        txtData.setText("Data received: " + message);
    }


    /**
     *
     * @param position cell number which user had clicked
     */
    private void declareWinner(int position){
        String winner;

        if(whichLineToCross(position)!=0){
            if(mBlock[position].getId()==CROSS){
                winner = "Cross";
            }else{
                winner = "Cricle";
            }
            txtData.setText("Winner is "+ winner);
            displayStick(whichLineToCross(position));
            disableAll();
            mStatusCounter = 0; // incase user wants to replay, mStatusCounter should return to default, that is 0
        }else if(mStatusCounter==9){
            txtData.setText("Draw! Try Again");
            mStatusCounter = 0;
        }

    }

    /**
     *
     * @param position cell_number user has clicked
     * @return which line to draw, horizontally, vertically, or diagonally.
     */
    private int whichLineToCross(int position){
        int lineToCross = 0;
        switch (position){
            case 0:
                if (mBlock[0].getId() == mBlock[1].getId() && mBlock[1].getId() == mBlock[2].getId()) {
                    lineToCross = 1;
                }if(mBlock[0].getId() == mBlock[3].getId() && mBlock[3].getId() == mBlock[6].getId()){
                lineToCross = 4;
            }if(mBlock[0].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[8].getId()){
                lineToCross = 7;
            }
                return lineToCross;
            case 1:
                if (mBlock[0].getId() == mBlock[1].getId() && mBlock[1].getId() == mBlock[2].getId()) {
                    lineToCross = 1;
                }if (mBlock[1].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[7].getId()) {
                lineToCross = 5;
            }
                return lineToCross;
            case 2:
                if (mBlock[0].getId() == mBlock[1].getId() && mBlock[1].getId() == mBlock[2].getId()) {
                    lineToCross = 1;
                }if (mBlock[2].getId() == mBlock[5].getId() && mBlock[5].getId() == mBlock[8].getId()) {
                lineToCross = 6;
            } if (mBlock[2].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[6].getId()) {
                lineToCross = 8;
            }
                return lineToCross;
            case 3:
                if (mBlock[0].getId() == mBlock[3].getId() && mBlock[3].getId() == mBlock[6].getId()) {
                    lineToCross = 4;
                } if (mBlock[5].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[3].getId()) {
                lineToCross = 2;
            }
                return lineToCross;
            case 4:
                if (mBlock[5].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[3].getId()) {
                    lineToCross = 2;
                } if (mBlock[1].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[7].getId()) {
                lineToCross = 5;
            } if (mBlock[0].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[8].getId()) {
                lineToCross = 7;
            } if (mBlock[6].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[2].getId()) {
                lineToCross = 8;
            }
                return lineToCross;
            case 5:
                if (mBlock[2].getId() == mBlock[5].getId() && mBlock[5].getId() == mBlock[8].getId()) {
                    lineToCross = 6;
                } if (mBlock[5].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[3].getId()) {
                lineToCross = 2;
            }
                return lineToCross;
            case 6:
                if (mBlock[0].getId() == mBlock[3].getId() && mBlock[3].getId() == mBlock[6].getId()) {
                    lineToCross = 4;
                } if (mBlock[2].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[6].getId()) {
                lineToCross = 8;
            } if (mBlock[6].getId() == mBlock[7].getId() && mBlock[7].getId() == mBlock[8].getId()) {
                lineToCross = 3;
            }
                return lineToCross;
            case 7:
                if (mBlock[1].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[7].getId()) {
                    lineToCross = 5;
                } if (mBlock[6].getId() == mBlock[7].getId() && mBlock[7].getId() == mBlock[8].getId()) {
                lineToCross = 3;
            }
                return lineToCross;
            case 8:
                if (mBlock[2].getId() == mBlock[5].getId() && mBlock[5].getId() == mBlock[8].getId()) {
                    lineToCross = 6;
                } if (mBlock[6].getId() == mBlock[7].getId() && mBlock[7].getId() == mBlock[8].getId()) {
                lineToCross = 3;
            } if (mBlock[0].getId() == mBlock[4].getId() && mBlock[4].getId() == mBlock[8].getId()) {
                lineToCross = 7;
            }
                return lineToCross;
            default:
                lineToCross = 0;
        }
        return lineToCross;

    }

}

