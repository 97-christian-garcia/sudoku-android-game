package com.example.christian.supersurgedsudoku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    private TextView txtVisited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean appOpened;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        txtVisited = (TextView)(findViewById(R.id.txtVisited));

        SharedPreferences sharedPreferences = getSharedPreferences("mypref", 0);
        appOpened = sharedPreferences.getBoolean("visit", false);

        if(appOpened){
            txtVisited.setText("Welcome back! Please feel free to start a new puzzle!");
        }
        else if(!appOpened){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            txtVisited.setText("Welcome to the app! If you haven't played Sudoku before, click the 'Sudoku Rules' button to learn more!");
            editor.putBoolean("visit", true).commit();
        }
    }

    public void startGame(View v){
        startActivity(new Intent(MainMenu.this, GameView.class));
    }

    public void startScore(View v){
        Uri uri = Uri.parse("http://www.sudokuessentials.com/how_to_play_sudoku.html");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
   }
}
