package com.example.christian.supersurgedsudoku;

import java.util.ArrayList;
import java.util.Random;

public class GeneratePuzzle{
    private static GeneratePuzzle sudokuPuzzle;
    private ArrayList<ArrayList<Integer>> gridSpace = new ArrayList<ArrayList<Integer>>();
    private Random randomNum = new Random();

    private GeneratePuzzle(){};

    public static GeneratePuzzle getSudokuPuzzle(){
        if(sudokuPuzzle == null){
            sudokuPuzzle = new GeneratePuzzle();
        }
        return sudokuPuzzle;
    }

    public int [][] generatePuzzle(){
        int [][] SudokuGrid = new int[9][9];
        int currentPosition = 0;

        clearPuzzle(SudokuGrid);

        while(currentPosition < 81) {
            if (gridSpace.get(currentPosition).size() != 0) {
                int rand = randomNum.nextInt(gridSpace.get(currentPosition).size());
                int theNumber = gridSpace.get(currentPosition).get(rand);

                if (!conflictCheck(SudokuGrid, currentPosition, theNumber)) {
                    int xPosition = currentPosition % 9;
                    int yPosition = currentPosition / 9;

                    SudokuGrid[xPosition][yPosition] = theNumber;
                    gridSpace.get(currentPosition).remove(rand);
                    currentPosition++;
                } else {
                    gridSpace.get(currentPosition).remove(rand);
                }
            }
            else {
                for(int i = 1; i <= 9; i++) {
                    gridSpace.get(currentPosition).add(i);
                }
                currentPosition--;
            }
        }

        return SudokuGrid;
    }

    private void clearPuzzle(int [][] SudokuGrid){
        gridSpace.clear();

        //set each number in the grid to 0
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                SudokuGrid[x][y] = -1;
            }
        }

        for(int i = 0; i < 81; i++){
            gridSpace.add(new ArrayList<Integer>());
            for(int j = 1; j <= 9; j++){
                gridSpace.get(i).add(j);
            }
        }
    }

    public int [][] removeElements(int [][] SudokuGrid){
        int elementsRemoved = 0;

        while(elementsRemoved < 40){
            int xPosition = randomNum.nextInt(9);
            int yPosition = randomNum.nextInt(9);

            if(SudokuGrid[xPosition][yPosition] != 0){
                SudokuGrid[xPosition][yPosition] = 0;
                elementsRemoved++;
            }
        }
        return SudokuGrid;
    }

    private boolean conflictCheck(int [][] SudokuGrid, int currentPosition, final int number){
        int xPosition = currentPosition % 9;
        int yPosition = currentPosition / 9;

        if(horizontalConflictCheck(SudokuGrid, xPosition, yPosition, number) || verticalConflictCheck(SudokuGrid, xPosition, yPosition, number) || gridCheck(SudokuGrid, xPosition, yPosition, number)){
            return true;
        }

        return false;
    }

    //Returns true if there is a conflict on the row
    private boolean horizontalConflictCheck(final int [][] SudokuGrid, final int xPosition, final int yPosition, final int numCheck){
        for(int x = xPosition - 1; x >= 0; x--){
            if(numCheck == SudokuGrid[x][yPosition]){
                return true;
            }
        }
        return false;
    }
    //Returns true if there is a conflict on the column
    private boolean verticalConflictCheck(final int [][] SudokuGrid, final int xPosition, final int yPosition, final int numCheck){
        for(int y = yPosition - 1; y >= 0; y--){
            if(numCheck == SudokuGrid[xPosition][y]) {
                return true;
            }
        }
        return false;
    }

    //Returns true if there is a conflict in the current 3x3 grid
    private boolean gridCheck(final int [][] SudokuGrid, final int xPosition, final int yPosition, final int numCheck){
        int xGrid = xPosition / 3;
        int yGrid = yPosition / 3;

        for(int x = xGrid * 3; x < xGrid * 3 + 3; x++){
            for(int y = yGrid * 3; y < yGrid * 3 + 3; y++){
                if((x != xPosition || y != yPosition) && numCheck == SudokuGrid[x][y]){
                    return true;
                }
            }
        }
        return false;
    }
}
