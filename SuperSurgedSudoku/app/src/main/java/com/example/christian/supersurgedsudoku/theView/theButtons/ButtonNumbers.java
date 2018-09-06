package com.example.christian.supersurgedsudoku.theView.theButtons;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.christian.supersurgedsudoku.SudokuGameEngine;

public class ButtonNumbers extends Button implements View.OnClickListener {

    private int btnNum;

    public ButtonNumbers(Context context, AttributeSet attrs){
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        SudokuGameEngine.getInstance().setNumber(btnNum);
    }

    public void setNumber(int btnNum){
        this.btnNum = btnNum;
    }
}
