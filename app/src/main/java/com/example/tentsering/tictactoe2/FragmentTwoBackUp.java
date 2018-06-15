package com.example.tentsering.tictactoe2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FragmentTwoBackUp extends Fragment {

}
//
//    TextView txtData, countClickonLayout, countClickonImage;
//    ImageView one, two, three, four, five, six, seven, eight, nine;
//    String oneXO, twoXO, threeXO, fourXO, fiveXO, sixXO, sevenXO, eightXO, nineXO;
//    int numOfCellMarked, numOfClickonLayout, cSL; //click on same Layout
//    Button playAgain;
//    int cSI1,cSI2,cSI3,cSI4,cSI5,cSI6,cSI7,cSI8,cSI9; // number of click-on-same-image
//    int playerAscore, playerBscore;
//    String thatMessage;
//
//    static  String[] XO;  //store user input on each cell, whether it's X or O
//    static ImageView[] cell; //change cell image to X or O
//    static int[] cSI; // number of click-on-same-image
//
//    //interface
//   // SendScore sendScore;
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(
//                R.layout.activity_fragment2, container, false);
//
////        one =(ImageView)rootView.findViewById(R.id.cellone);
////        two =(ImageView)rootView.findViewById(R.id.celltwo);
////        three =(ImageView)rootView.findViewById(R.id.cellthree);
////
////        four =(ImageView)rootView.findViewById(R.id.cellfour);
////        five =(ImageView)rootView.findViewById(R.id.cellfive);
////        six =(ImageView)rootView.findViewById(R.id.cellsix);
////
////        seven =(ImageView)rootView.findViewById(R.id.cellseven);
////        eight =(ImageView)rootView.findViewById(R.id.celleight);
////        nine =(ImageView)rootView.findViewById(R.id.cellnine);
//
//        return rootView;
//
//    }
//
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        txtData = (TextView)view.findViewById(R.id.txtData);
//        playAgain = (Button) view.findViewById(R.id.Again);
//
//
//        XO = new String[9];
//        cell = new ImageView[9];
//        cSI = new int[9];
//
//
//        countClickonLayout = (TextView) view.findViewById(R.id.numOfClickOnLayout);
//        countClickonImage = (TextView) view.findViewById(R.id.numOfClickImage);
//
//        one.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numofClickonImage = 0;
//                numofClickonImage += 1;
//                numOfCellMarked += 1;
//
//                cSI1 += 1;  //number of click-on-same-image1
//
//                if(cSI1 < 2){
//                    countClickonImage.setText("NCI-1" + "\n" + cSI1);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            one.setImageResource(R.drawable.circular_ring);
//                            oneXO = "O";
//                        } else {
//                            one.setImageResource(R.drawable.cross);
//                            oneXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            one.setImageResource(R.drawable.cross);
//                            oneXO = "X";
//                        } else {
//                            one.setImageResource(R.drawable.circular_ring);
//                            oneXO = "O";
//                        }
//                    }
//
//                }
//                else{
//                    // don't do anything, except
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-1" + "\n" + cSI1);
//
//                    //Toast.makeText(getActivity(), "Don't click more than once", Toast.LENGTH_SHORT).show();
//                }
//
//                try {
//
////                    if(FragmentTwo.this.declareWinner().equals(null) || FragmentTwo.this.declareWinner().isEmpty()){
////                        Toast.makeText(getActivity(), "No Winner", Toast.LENGTH_SHORT).show();
////                    }else{
////                        Toast.makeText(getActivity(), "Winner: " + FragmentTwo.this.declareWinner(), Toast.LENGTH_SHORT).show();
////                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//        });
//
//        two.setOnClickListener(new View.OnClickListener() {
//                                   @Override
//                                   public void onClick(View view) {
//                                       int numofClickonImage = 0;
//                                       numofClickonImage +=1;
//                                       numOfCellMarked +=1;
//
//                                       cSI2 += 1;  //number of click-on-same-image1
//
//                                       if(cSI2 < 2){
//
//                                           countClickonImage.setText("NCI-2" + "\n" + cSI2);
//                                           countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                                           if (numOfCellMarked % 2 == 0) {
//                                               //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                                               //and if it's player B's turn then
//
//                                               if (thatMessage.equalsIgnoreCase("X")) {
//                                                   //if player A's choice is X, then Player B's choice has to be O, so
//                                                   two.setImageResource(R.drawable.circular_ring);
//                                                   twoXO = "O";
//                                               } else {
//                                                   two.setImageResource(R.drawable.cross);
//                                                   twoXO = "X";
//                                               }
//
//                                           }else {
//                                               if (thatMessage.equalsIgnoreCase("X")) {
//                                                   two.setImageResource(R.drawable.cross);
//                                                   twoXO = "X";
//                                               } else {
//                                                   two.setImageResource(R.drawable.circular_ring);
//                                                   twoXO = "O";
//                                               }
//                                           }
//                                       }
//                                       else{
//                                           // don't do anything
//                                           numOfCellMarked = numOfCellMarked - numofClickonImage;
//                                           countClickonImage.setText("NCI-2" + "\n" + cSI2);
//
//                                           Toast.makeText(getActivity(), "Don't click more than once", Toast.LENGTH_SHORT).show();
//                                       }
//
//                                   }
//                               }
//        );
//
//        three.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numofClickonImage = 0;
//                numofClickonImage +=1;
//                numOfCellMarked +=1;
//
//                cSI3 += 1;  //number of click-on-same-image1
//
//                if(cSI3 < 2){
//
//                    countClickonImage.setText("NCI-3" + "\n" + cSI3);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            three.setImageResource(R.drawable.circular_ring);
//                            threeXO = "O";
//                        } else {
//                            three.setImageResource(R.drawable.cross);
//                            threeXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            three.setImageResource(R.drawable.cross);
//                            threeXO = "X";
//                        } else {
//                            three.setImageResource(R.drawable.circular_ring);
//                            threeXO = "O";
//                        }
//                    }
//                }
//                else{
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-3" + "\n" + cSI3);
//
//                }
//
//            }
//        });
//
//        four.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numofClickonImage = 0;
//                numofClickonImage +=1;
//                numOfCellMarked +=1;
//
//                cSI4 += 1;  //number of click-on-same-image1
//
//                if(cSI4 < 2){
//
//                    countClickonImage.setText("NCI-4" + "\n" + cSI4);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            four.setImageResource(R.drawable.circular_ring);
//                            fourXO = "O";
//                        } else {
//                            four.setImageResource(R.drawable.cross);
//                            fourXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            four.setImageResource(R.drawable.cross);
//                            fourXO = "X";
//                        } else {
//                            four.setImageResource(R.drawable.circular_ring);
//                            fourXO = "O";
//                        }
//                    }
//                }
//                else{
//                    // don't do anything
//
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-4" + "\n" + cSI4);
//
//                    Toast.makeText(getActivity(), "Don't click more than once", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//        five.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numofClickonImage = 0;
//                numofClickonImage +=1;
//                numOfCellMarked +=1;
//
//                cSI5 += 1;  //number of click-on-same-image1
//
//                if(cSI5 < 2){
//
//                    countClickonImage.setText("NCI-5" + "\n" + cSI5);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            five.setImageResource(R.drawable.circular_ring);
//                            fiveXO = "O";
//                        } else {
//                            five.setImageResource(R.drawable.cross);
//                            fiveXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            five.setImageResource(R.drawable.cross);
//                            fiveXO = "X";
//                        } else {
//                            five.setImageResource(R.drawable.circular_ring);
//                            fiveXO = "O";
//                        }
//                    }
//                }
//                else{
//                    // don't do anything
//
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-5" + "\n" + cSI5);
//                }
//
//            }
//        });
//
//        six.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numofClickonImage = 0;
//                numofClickonImage +=1;
//                numOfCellMarked +=1;
//
//                cSI6 += 1;  //number of click-on-same-image1
//
//                if(cSI6 < 2){
//
//                    countClickonImage.setText("NCI-6" + "\n" + cSI7);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            six.setImageResource(R.drawable.circular_ring);
//                            sixXO = "O";
//                        } else {
//                            six.setImageResource(R.drawable.cross);
//                            sixXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            six.setImageResource(R.drawable.cross);
//                            sixXO = "X";
//                        } else {
//                            six.setImageResource(R.drawable.circular_ring);
//                            sixXO = "O";
//                        }
//                    }
//                }
//                else{
//                    // don't do anything
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-6" + "\n" + cSI6);
//
//                }
//
//            }
//        });
//
//
//        seven.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numofClickonImage = 0;
//                numofClickonImage +=1;
//                numOfCellMarked +=1;
//
//                cSI7 += 1;  //number of click-on-same-image1
//
//                if(cSI7 < 2){
//
//                    countClickonImage.setText("NCI-7" + "\n" + cSI7);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            seven.setImageResource(R.drawable.circular_ring);
//                            sevenXO = "O";
//                        } else {
//                            seven.setImageResource(R.drawable.cross);
//                            sevenXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            seven.setImageResource(R.drawable.cross);
//                            sevenXO = "X";
//                        } else {
//                            seven.setImageResource(R.drawable.circular_ring);
//                            sevenXO = "O";
//                        }
//                    }
//                }
//                else{
//                    // don't do anything
//
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-7" + "\n" + cSI7);
//
//                    Toast.makeText(getActivity(), "Don't click more than once", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//
//        eight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int numofClickonImage = 0;
//                numofClickonImage +=1;
//                numOfCellMarked +=1;
//
//                cSI8 += 1;  //number of click-on-same-image1
//
//                if(cSI8 < 2){
//
//                    countClickonImage.setText("NCI-8" + "\n" + cSI8);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            eight.setImageResource(R.drawable.circular_ring);
//                            eightXO = "O";
//                        } else {
//                            eight.setImageResource(R.drawable.cross);
//                            eightXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            eight.setImageResource(R.drawable.cross);
//                            eightXO = "X";
//                        } else {
//                            eight.setImageResource(R.drawable.circular_ring);
//                            eightXO = "O";
//                        }
//                    }
//                }
//                else{
//                    // don't do anything
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-8" + "\n" + cSI8);
//                }
//
//            }
//        });
//
//        nine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // fragmentTwo3 = new FragmentTwo();
//                makeMyJobEasy(8);
//
//            }
//
//            private void makeMyJobEasy(int i) {
//                int numofClickonImage = 0;
//                numofClickonImage +=1;
//                numOfCellMarked +=1;
//                cSI9 += 1;  //number of click-on-same-image1
//
//                if(cSI9 < 2){
//
//                    countClickonImage.setText("NCI-9" + "\n" + cSI9);
//                    countClickonLayout.setText("NCM" + "\n" + numOfCellMarked);
//
//                    if (numOfCellMarked % 2 == 0) {
//                        //1 % 2 != 0, so it's not even, meaning it's player B's turn
//                        //and if it's player B's turn then
//
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            //if player A's choice is X, then Player B's choice has to be O, so
//                            nine.setImageResource(R.drawable.circular_ring);
//                            nineXO = "O";
//                        } else {
//                            nine.setImageResource(R.drawable.cross);
//                            nineXO = "X";
//                        }
//
//                    }else {
//                        if (thatMessage.equalsIgnoreCase("X")) {
//                            nine.setImageResource(R.drawable.cross);
//                            nineXO = "X";
//                        } else {
//                            nine.setImageResource(R.drawable.circular_ring);
//                            nineXO = "O";
//                        }
//                    }
//                }
//                else{
//                    // don't do anything
//                    numOfCellMarked = numOfCellMarked - numofClickonImage;
//                    countClickonImage.setText("NCI-9" + "\n" + cSI9);
//                }
//
//            }
//
//        });
//
//        playAgain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int score = 0;
//                score+=1;
//                //sendScore.sendDatatoThree(score);
//                Toast.makeText(getActivity(), "Data Sent", Toast.LENGTH_SHORT).show();}
//        });
//
//
//
//
//    }
//
//    /**
//     * checkRows0, check all three rows for whether O wins first
//     */
//    public boolean checkRows0() {
//        boolean winnerIs0 = false;
//        //check for O
//        if(oneXO.equals("o") && twoXO.equals("o") && threeXO.equals("o")){
//            winnerIs0 = true;
//        }else if(fourXO.equals("o") && fiveXO.equals("o") && sixXO.equals("o")){
//            winnerIs0 = true;
//
//        }else if(sevenXO.equals("o") && eightXO.equals("o") && nineXO.equals("o")){
//            winnerIs0 = true;
//        }
//        //check for O
//        return  winnerIs0;
//    }
//
//    /**
//     * checkRowsX, check all three rows for whether X wins first
//     */
//    public boolean checkRowsX() {
//        boolean winnerIsX = false;
//        //check for X
//        if(oneXO.equals("x") && twoXO.equals("x") && threeXO.equals("x")){
//            winnerIsX = true;
//        }else if(fourXO.equals("x") && fiveXO.equals("x") && sixXO.equals("x")){
//            winnerIsX = true;
//
//        }else if(sevenXO.equals("x") && eightXO.equals("x") && nineXO.equals("x")){
//            winnerIsX = true;
//        }
//        //check for X
//        return winnerIsX;
//    }
//
//    /**
//     * checkColumnsX, check all three columns for whether X wins first or O
//     */
//    public boolean checkColumnsX(){
//        boolean winnerIsX = false;
//        //check for O
//        if(oneXO.equals("x") && sixXO.equals("x") && sevenXO.equals("x")){
//            winnerIsX = true;
//        }else if(twoXO.equals("x") && fiveXO.equals("x") && eightXO.equals("x")){
//            winnerIsX = true;
//
//        }else if(threeXO.equals("x") && fourXO.equals("x") && nineXO.equals("x")){
//            winnerIsX = true;
//        }
//        //check for X
//        return winnerIsX;
//    }
//
//    /**
//     * checkColumns0, check all three columns for whether X wins first or O
//     */
//    public boolean checkColumns0(){
//        boolean winnerIs0 = false;
//        //check for O
//        if(oneXO.equals("o") && sixXO.equals("o") && sevenXO.equals("o")){
//            winnerIs0 = true;
//        }else if(twoXO.equals("o") && fiveXO.equals("o") && eightXO.equals("o")){
//            winnerIs0 = true;
//
//        }else if(threeXO.equals("o") && fourXO.equals("o") && nineXO.equals("o")){
//            winnerIs0 = true;
//        }
//        //check for O
//        return winnerIs0;
//    }
//
//    /**
//     * checkDiagonalsX, check all 2 columns for whether X wins first or O
//     */
//    public boolean checkDiagonalsX(){
//        boolean winnerIsX = false;
//        //check for X
//        if(oneXO.equals("o") && sixXO.equals("o") && sevenXO.equals("o")){
//            winnerIsX = true;
//        }else if(twoXO.equals("o") && fiveXO.equals("o") && eightXO.equals("o")){
//            winnerIsX = true;
//
//        }else if(threeXO.equals("o") && fourXO.equals("o") && nineXO.equals("o")){
//            winnerIsX = true;
//        }
//        //check for X
//        return winnerIsX;
//    }
//
//
//    /**
//     * checkDiagonals0, check all 2 columns for whether X wins first or O
//     */
//    public boolean checkDiagonals0(){
//        boolean winnerIs0 = false;
//        //check for O
//        if(oneXO.equals("o") && fiveXO.equals("o") && nineXO.equals("o")){
//            winnerIs0 = true;
//        }else if(sevenXO.equals("o") && fiveXO.equals("o") && threeXO.equals("o")){
//            winnerIs0 = true;
//        }
//        //check for X
//        return winnerIs0;
//    }
//
//    public String declareWinner() throws Exception {
//
//        String winner="";
////        if(FragmentTwo.this.checkRows0()==true){
////            winner = "o";
////
////        }else if(FragmentTwo.this.checkRowsX()==true){
////            winner = "x";
////
////        }else if(FragmentTwo.this.checkColumns0()==true){
////            winner = "o";
////
////        }else if(FragmentTwo.this.checkColumnsX()==true){
////            winner = "x";
////
////        }else if(FragmentTwo.this.checkDiagonals0()==true){
////            winner = "o";
////
////        }else if(FragmentTwo.this.checkDiagonalsX()==true){
////            winner = "x";
////        }
//
//        return winner;
//    }
//
//
//    /**
//     *
//     * @param message contains whether player A chose X or O.
//     */
//    protected void displayReceivedData(String message)
//    {
//        txtData.setText("Data received: " + message);
//    }
//
//    /**
//     *
//     * @param message contains whether player A chose X or O.
//     * @return
//     */
//    protected String getReceivedMessage(String message){
//        thatMessage = message;
//        return thatMessage;
//    }
//
//
//
//    public int checkScore(int cellMarked){
//        int sendThis = 34;
//        return sendThis;
//    }
//
//
//    /**
//     * Created an interface to allow data(Player's Score) transfer between FragmentTwo to MainActivity to FragmentThree.
//     */
////    interface SendScore {
////        void sendDatatoThree(int score);
////    }
////
////    @Override
////    public void onAttach(Context context) {
////        super.onAttach(context);
////
////        //to check whether the activity implement the method or not, we use try catch block
////        try{
////            sendScore = (SendScore) getActivity();
////        }catch (ClassCastException e){
////            throw new ClassCastException("Error in retrieving data!");
////        }
////    }
//
//}
