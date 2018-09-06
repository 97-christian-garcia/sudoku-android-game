package com.example.christian.supersurgedsudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreView extends AppCompatActivity {
    public int [] bestTimes = new int[5];
    private TextView txtTimeScore1, txtTimeScore2, txtTimeScore3, txtTimeScore4, txtTimeScore5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);
        Bundle theBundle = getIntent().getExtras();

        txtTimeScore1 = (TextView) findViewById(R.id.txtTimeScore1);
        txtTimeScore2 = (TextView) findViewById(R.id.txtTimeScore2);
        txtTimeScore3 = (TextView) findViewById(R.id.txtTimeScore3);
        txtTimeScore4 = (TextView) findViewById(R.id.txtTimeScore4);
        txtTimeScore5 = (TextView) findViewById(R.id.txtTimeScore5);

        bestTimes = theBundle.getIntArray("theBestTimes");

       // GameView gameView = new GameView();
       // bestTimes = gameView.getBestTimes();

        setText();
    }

    public void setText(){
        if (bestTimes[0] == 0) {
            txtTimeScore1.setText("1: -----");
        } else {
            txtTimeScore1.setText("1: " + bestTimes[5]);
        }

        if (bestTimes[1] == 0) {
            txtTimeScore2.setText("2: -----");
        } else {
            txtTimeScore2.setText("2: " + bestTimes[1]);
        }

        if (bestTimes[2] == 0) {
            txtTimeScore3.setText("3: -----");
        } else {
            txtTimeScore3.setText("3: " + bestTimes[2]);
        }

        if (bestTimes[3] == 0) {
            txtTimeScore4.setText("4: -----");
        } else {
            txtTimeScore4.setText("4: " + bestTimes[3]);
        }

        if (bestTimes[4] == 0) {
            txtTimeScore5.setText("5: -----");
        } else {
            txtTimeScore5.setText("5: " + bestTimes[4]);
        }
    }



    public void returnHome(View v){
        startActivity(new Intent(ScoreView.this, MainMenu.class));
    }
}

