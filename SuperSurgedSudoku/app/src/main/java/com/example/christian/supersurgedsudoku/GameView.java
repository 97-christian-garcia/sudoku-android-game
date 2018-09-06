package com.example.christian.supersurgedsudoku;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import java.util.Arrays;

public class GameView extends AppCompatActivity {
    Chronometer txtTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
        SudokuGameEngine.getInstance().createGrid(this);

        txtTimer = (Chronometer) findViewById(R.id.txtTimer);
        timerStart();
    }

    public void timerStart(){
        txtTimer.setBase(SystemClock.elapsedRealtime());
        txtTimer.start();
    }

    public void returnHome(View v){
        Intent i = new Intent(this, MainMenu.class);
        startActivity(new Intent(i));
    }

}
