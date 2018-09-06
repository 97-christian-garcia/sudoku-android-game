package com.example.christian.supersurgedsudoku.theView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class SudokuCells extends SudokuCellsBase{


    private Paint painter;

    public SudokuCells(Context context){
        super(context);
        painter = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawNumber(canvas);
        drawLines(canvas);
    }

    private void drawLines(Canvas canvas){
        painter.setColor(Color.BLACK);
        painter.setStrokeWidth(3);
        painter.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), painter);
    }

    private void drawNumber(Canvas canvas){
        painter.setColor(Color.BLACK);
        painter.setTextSize(60);
        painter.setStyle(Paint.Style.FILL);

        Rect bounds = new Rect();
        painter.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);

        if(getValue() != 0) {
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width()) / 2, (getHeight() + bounds.height()) / 2, painter);
        }
    }
}
