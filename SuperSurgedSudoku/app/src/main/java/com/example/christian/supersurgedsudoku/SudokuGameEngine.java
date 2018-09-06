package com.example.christian.supersurgedsudoku;


import android.content.Context;

import com.example.christian.supersurgedsudoku.theView.SudokuGameGrid;

public class SudokuGameEngine {
    private static SudokuGameEngine instance;
    private SudokuGameGrid grid = null;
    private int xSelect = -1;
    private int ySelect = -1;

    private SudokuGameEngine(){}

    public static SudokuGameEngine getInstance(){
        if(instance == null){
            instance = new SudokuGameEngine();
        }
        return instance;
    }

    public void createGrid(Context context){
        int [][] SudokuGrid = GeneratePuzzle.getSudokuPuzzle().generatePuzzle();
        SudokuGrid = GeneratePuzzle.getSudokuPuzzle().removeElements(SudokuGrid);
        grid = new SudokuGameGrid(context);
        grid.setGrid(SudokuGrid);
    }

    public SudokuGameGrid getGrid(){
        return grid;
    }

    public void setSelectedPosition(int x, int y){
        xSelect = x;
        ySelect = y;
    }

    public void setNumber(int num){
        if(xSelect != -1 && ySelect != -1){
            grid.setItem(xSelect, ySelect, num);
        }
        grid.checkGame();
    }


}
