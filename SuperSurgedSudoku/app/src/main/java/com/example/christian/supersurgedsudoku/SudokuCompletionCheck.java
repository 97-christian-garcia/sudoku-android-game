package com.example.christian.supersurgedsudoku;

public class SudokuCompletionCheck {
    private static SudokuCompletionCheck instance;

    private SudokuCompletionCheck(){}

    public static SudokuCompletionCheck getInstance(){
        if(instance == null){
            instance = new SudokuCompletionCheck();
        }
        return instance;
    }

    public boolean checkSudoku(int [][] SudokuGrid){
        return(checkHorizontal(SudokuGrid) || checkVertical(SudokuGrid) || checkGridRegion(SudokuGrid));
    }

    private boolean checkHorizontal(int [][] SudokuGrid){
        for(int y = 0; y < 9; y++){
            for(int xPos = 0; xPos < 9; xPos++){
                if(SudokuGrid[xPos][y] == 0){
                    return false;
                }
                for(int x = xPos + 1; x < 9; x++){
                    if(SudokuGrid[xPos][y] == SudokuGrid[x][y] || SudokuGrid[x][y] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkVertical(int [][] SudokuGrid){
        for(int x = 0; x < 9; x++){
            for(int yPos = 0; yPos < 9; yPos++){
                if(SudokuGrid[x][yPos] == 0){
                    return false;
                }
                for(int y = yPos + 1; y < 9; y++){
                    if(SudokuGrid[x][yPos] == SudokuGrid[x][y] || SudokuGrid[x][y] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkGridRegion(int [][] SudokuGrid){
        for(int xRegion = 0; xRegion < 3; xRegion++){
            for(int yRegion = 0; yRegion < 3; yRegion++){
                if(!checkGridNumber(SudokuGrid, xRegion, yRegion)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkGridNumber(int [][] SudokuGrid, int xRegion, int yRegion){
        for(int xPosition = xRegion * 3; xPosition < xRegion * 3 + 3; xPosition++){
            for(int yPosition = yRegion * 3; yPosition <yRegion * 3 + 3; yPosition++){
                for(int x = xPosition; x < xRegion * 3 + 3; x++){
                    for(int y = yPosition; y < yRegion * 3 + 3; x++){
                        if(x != xPosition || y != yPosition && SudokuGrid[xPosition][yPosition] == SudokuGrid[x][y] || SudokuGrid[x][y] == 0){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
