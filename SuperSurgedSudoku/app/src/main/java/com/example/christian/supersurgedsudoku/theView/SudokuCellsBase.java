package com.example.christian.supersurgedsudoku.theView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


public class SudokuCellsBase extends View {
    private int value;
    private boolean mod = true;

    public SudokuCellsBase(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setMod(){
        mod = false;
    }

    public void setValue(int value){
        if(mod) {
            this.value = value;
        }
        invalidate();
    }

    public void setInitialValue(int value){
        this.value = value;
        invalidate();
    }


    public int getValue(){
        return value;
    }

}
