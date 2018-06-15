package com.example.tentsering.tictactoe2;

import android.widget.ImageView;

//This class helps to establish th logic behind tic-tac-toe, as when user got same mark three in a row or column or diagonal
//This class is to used exclusively in FragmentTwo
public class GameLogic {

    public static ImageView[] mCells;
    public static String mWinner;
    public static int mSet; // this used to determine which line out of 8 to use when user got three shape matched, xxx or ooo, horizontally, vertically or diagonally.
    public static final int CROSS = 2;
    public static final int CIRCLE = 1;

    /**
     * This method will be used in isCompleted() method, to check for win.
     * @param first  user input out of three inputs that will be analyzed among nine inputs int total, whether it'll be O or X.
     * @param second user input out of three inputs that will be analyzed.
     * @param third  user input out of three inputs that will be analyzed.
     * @param set    out of eight different possibilities for the game to be over: for e.g.
     *               set-1, row-1 all clear(xxx)|(ooo), either all X or O, set-2, row-2 all clear(xxx)|(ooo), all X or O and so on...
     * @return
     */
    private static boolean areInSameSet(int first, int second, int third, int set) {
        //here mCellss[first -1] means that in Array the first value begins with 0, therefore having ImageView array of length nine,
        //the first being mCellss[0] and last being mCellss[8], not mCellss[9], you get the idea!

        boolean value = mCells[first - 1].getId() == mCells[second - 1].getId() && mCells[second - 1].getId() == mCells[third - 1].getId();
        //Now if same value matches consecutively 3 times, then we found a match.
        if (value) {
            if (mCells[first - 1].getId() == CIRCLE) {
                mWinner = "CIRCLE";
            } else {
                mWinner = "CROSS";
                mSet = set;
            }
        }
        return value;
    }


//    /**
//     * @param scenario, when user clicks on cell-1, there are 3 sets which will result in game over, for instance, first row, first column, and one diagonal
//     *                  when user clicks cell-5, there are 2 sets which will results in game over, for instance, first column, and second row.
//     * @param cells     which cell the user is at when clicked on the image
//     * @return a boolean type called foundMatch, meaning game over now, either player A or B has won!
//     */
//    public static boolean isCompleted(int scenario, ImageView[] cells) {
//        GameLogic.mCells = cells;
//        boolean foundMatch = false;
//
//        switch (scenario) {
//            case 1:
//                foundMatch = areInSameSet(1, 2, 3, 1) ||
//                        areInSameSet(1, 4, 7, 4) ||
//                        areInSameSet(1, 5, 9, 7);
//                break;
//            case 2:
//                foundMatch = areInSameSet(1, 2, 3, 1) ||
//                        areInSameSet(2, 5, 8, 5);
//                break;
//            case 3:
//                foundMatch = areInSameSet(1, 2, 3, 1) ||
//                        areInSameSet(3, 6, 9, 6) ||
//                        areInSameSet(3, 5, 7, 8);
//                break;
//            case 4:
//                foundMatch = areInSameSet(4, 5, 6, 2) ||
//                        areInSameSet(3, 4, 9, 6);
//                break;
//            case 5:
//                foundMatch = areInSameSet(4, 5, 6, 2) ||
//                        areInSameSet(2, 5, 8, 5) ||
//                        areInSameSet(1, 5, 9, 7) ||
//                        areInSameSet(3, 5, 7, 8);
//                break;
//            case 6:
//                foundMatch = areInSameSet(4, 5, 6, 2) ||
//                        areInSameSet(1, 6, 7, 4);
//                break;
//            case 7:
//                foundMatch = areInSameSet(7, 8, 9, 3) ||
//                        areInSameSet(1, 4, 7, 4) ||
//                        areInSameSet(3, 5, 7, 8);
//                break;
//            case 8:
//                foundMatch = areInSameSet(7, 8, 9, 3) ||
//                        areInSameSet(2, 5, 8, 5);
//                break;
//            case 9:
//                foundMatch = areInSameSet(7, 8, 9, 3) ||
//                        areInSameSet(3, 6, 9, 6) ||
//                        areInSameSet(1, 5, 9, 7);
//                break;
//
//        }
//        return foundMatch;
//    }
}
