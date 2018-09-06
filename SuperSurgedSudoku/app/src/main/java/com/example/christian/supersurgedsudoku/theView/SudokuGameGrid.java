package com.example.christian.supersurgedsudoku.theView;

import android.content.Context;
import android.widget.Toast;

import com.example.christian.supersurgedsudoku.GameView;
import com.example.christian.supersurgedsudoku.SudokuCompletionCheck;

public class SudokuGameGrid {
    public GameView gameView = new GameView();
    private SudokuCells [][] Sudoku = new SudokuCells [9][9];
    private Context context;

    public SudokuGameGrid(Context context){
        this.context = context;
        for(int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                Sudoku[x][y] = new SudokuCells(context);
            }
        }
    }

    public void setGrid(int [][] grid){
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++){
                Sudoku[x][y].setInitialValue(grid[x][y]);
                if(grid[x][y] != 0){
                    Sudoku[x][y].setMod();
                }
            }
        }
    }

    public SudokuCells [][] getGrid(){
        return Sudoku;
    }

    public SudokuCells getItem(int x, int y){
        return Sudoku[x][y];
    }

    public SudokuCells getItem(int position){
        int x = position % 9;
        int y = position / 9;

        return Sudoku[x][y];
    }

    public void setItem(int x, int y, int num){
        Sudoku[x][y].setValue(num);
    }

    public void checkGame(){
        int [][] SudokuGrid = new int[9][9];
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                SudokuGrid[x][y] = getItem(x,y).getValue();
            }
        }

        if(SudokuCompletionCheck.getInstance().checkSudoku(SudokuGrid)){
            Toast.makeText(context, "Congratulations! You solved the puzzle!", Toast.LENGTH_LONG).show();
        }
    }

}
