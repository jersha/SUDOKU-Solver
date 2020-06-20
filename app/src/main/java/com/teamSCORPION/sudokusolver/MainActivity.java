package com.teamSCORPION.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public EditText[][] EditTextValues;
    public int[][] int_values;

    Button btnSOLVE;
    Button btnRESET;

    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {
        // row has the unique (row-clash)
        for (int d = 0; d < board.length; d++) {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++) {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (board[r][col] == num) {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public static boolean solveSudoku(
            int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left
        if (isEmpty) {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    // print(board, n);
                    return true;
                }
                else {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(
            int[][] board, int N)
    {
        // we got the answer, just print it
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSOLVE = findViewById(R.id.btnSolve);
        btnRESET = findViewById(R.id.btnReset);

        EditTextValues = new EditText[9][9];

        EditTextValues[0][0] = findViewById(R.id.ONE1);
        EditTextValues[0][1] = findViewById(R.id.ONE2);
        EditTextValues[0][2] = findViewById(R.id.ONE3);
        EditTextValues[0][3] = findViewById(R.id.ONE4);
        EditTextValues[0][4] = findViewById(R.id.ONE5);
        EditTextValues[0][5] = findViewById(R.id.ONE6);
        EditTextValues[0][6] = findViewById(R.id.ONE7);
        EditTextValues[0][7] = findViewById(R.id.ONE8);
        EditTextValues[0][8] = findViewById(R.id.ONE9);
        EditTextValues[0][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[0][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[1][0] = findViewById(R.id.TWO1);
        EditTextValues[1][1] = findViewById(R.id.TWO2);
        EditTextValues[1][2] = findViewById(R.id.TWO3);
        EditTextValues[1][3] = findViewById(R.id.TWO4);
        EditTextValues[1][4] = findViewById(R.id.TWO5);
        EditTextValues[1][5] = findViewById(R.id.TWO6);
        EditTextValues[1][6] = findViewById(R.id.TWO7);
        EditTextValues[1][7] = findViewById(R.id.TWO8);
        EditTextValues[1][8] = findViewById(R.id.TWO9);
        EditTextValues[1][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[1][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[2][0] = findViewById(R.id.THREE1);
        EditTextValues[2][1] = findViewById(R.id.THREE2);
        EditTextValues[2][2] = findViewById(R.id.THREE3);
        EditTextValues[2][3] = findViewById(R.id.THREE4);
        EditTextValues[2][4] = findViewById(R.id.THREE5);
        EditTextValues[2][5] = findViewById(R.id.THREE6);
        EditTextValues[2][6] = findViewById(R.id.THREE7);
        EditTextValues[2][7] = findViewById(R.id.THREE8);
        EditTextValues[2][8] = findViewById(R.id.THREE9);
        EditTextValues[2][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[2][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[3][0] = findViewById(R.id.FOUR1);
        EditTextValues[3][1] = findViewById(R.id.FOUR2);
        EditTextValues[3][2] = findViewById(R.id.FOUR3);
        EditTextValues[3][3] = findViewById(R.id.FOUR4);
        EditTextValues[3][4] = findViewById(R.id.FOUR5);
        EditTextValues[3][5] = findViewById(R.id.FOUR6);
        EditTextValues[3][6] = findViewById(R.id.FOUR7);
        EditTextValues[3][7] = findViewById(R.id.FOUR8);
        EditTextValues[3][8] = findViewById(R.id.FOUR9);
        EditTextValues[3][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[3][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[4][0] = findViewById(R.id.FIVE1);
        EditTextValues[4][1] = findViewById(R.id.FIVE2);
        EditTextValues[4][2] = findViewById(R.id.FIVE3);
        EditTextValues[4][3] = findViewById(R.id.FIVE4);
        EditTextValues[4][4] = findViewById(R.id.FIVE5);
        EditTextValues[4][5] = findViewById(R.id.FIVE6);
        EditTextValues[4][6] = findViewById(R.id.FIVE7);
        EditTextValues[4][7] = findViewById(R.id.FIVE8);
        EditTextValues[4][8] = findViewById(R.id.FIVE9);
        EditTextValues[4][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[4][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[5][0] = findViewById(R.id.SIX1);
        EditTextValues[5][1] = findViewById(R.id.SIX2);
        EditTextValues[5][2] = findViewById(R.id.SIX3);
        EditTextValues[5][3] = findViewById(R.id.SIX4);
        EditTextValues[5][4] = findViewById(R.id.SIX5);
        EditTextValues[5][5] = findViewById(R.id.SIX6);
        EditTextValues[5][6] = findViewById(R.id.SIX7);
        EditTextValues[5][7] = findViewById(R.id.SIX8);
        EditTextValues[5][8] = findViewById(R.id.SIX9);
        EditTextValues[5][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[5][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[6][0] = findViewById(R.id.SEVEN1);
        EditTextValues[6][1] = findViewById(R.id.SEVEN2);
        EditTextValues[6][2] = findViewById(R.id.SEVEN3);
        EditTextValues[6][3] = findViewById(R.id.SEVEN4);
        EditTextValues[6][4] = findViewById(R.id.SEVEN5);
        EditTextValues[6][5] = findViewById(R.id.SEVEN6);
        EditTextValues[6][6] = findViewById(R.id.SEVEN7);
        EditTextValues[6][7] = findViewById(R.id.SEVEN8);
        EditTextValues[6][8] = findViewById(R.id.SEVEN9);
        EditTextValues[6][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[6][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[7][0] = findViewById(R.id.EIGHT1);
        EditTextValues[7][1] = findViewById(R.id.EIGHT2);
        EditTextValues[7][2] = findViewById(R.id.EIGHT3);
        EditTextValues[7][3] = findViewById(R.id.EIGHT4);
        EditTextValues[7][4] = findViewById(R.id.EIGHT5);
        EditTextValues[7][5] = findViewById(R.id.EIGHT6);
        EditTextValues[7][6] = findViewById(R.id.EIGHT7);
        EditTextValues[7][7] = findViewById(R.id.EIGHT8);
        EditTextValues[7][8] = findViewById(R.id.EIGHT9);
        EditTextValues[7][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[7][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;

        EditTextValues[8][0] = findViewById(R.id.NINE1);
        EditTextValues[8][1] = findViewById(R.id.NINE2);
        EditTextValues[8][2] = findViewById(R.id.NINE3);
        EditTextValues[8][3] = findViewById(R.id.NINE4);
        EditTextValues[8][4] = findViewById(R.id.NINE5);
        EditTextValues[8][5] = findViewById(R.id.NINE6);
        EditTextValues[8][6] = findViewById(R.id.NINE7);
        EditTextValues[8][7] = findViewById(R.id.NINE8);
        EditTextValues[8][8] = findViewById(R.id.NINE9);
        EditTextValues[8][0].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][1].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][2].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][3].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][4].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][5].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][6].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][7].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;
        EditTextValues[8][8].setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "9" )}) ;


        btnSOLVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_value;
                int_values = new int[9][9];
                for(int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++) {
                        str_value = EditTextValues[row][column].getText().toString();
                        if (str_value.isEmpty()) {
                            int_values[row][column] = 0;
                        } else {
                            int_values[row][column] = Integer.parseInt(str_value);
                        }
                    }
                }
                int N = int_values.length;

                if (solveSudoku(int_values, N)) {
                    for(int row = 0; row < 9; row++) {
                        for (int column = 0; column < 9; column++) {
                            str_value = Integer.toString(int_values[row][column]);
                            EditTextValues[row][column].setText(str_value);
                        }
                    }
                }
            }
        });

        btnRESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int row = 0; row < 9; row++) {
                    for (int column = 0; column < 9; column++) {
                        EditTextValues[row][column].setText("");
                    }
                }
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
