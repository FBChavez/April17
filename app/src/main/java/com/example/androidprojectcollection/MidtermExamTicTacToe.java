package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MidtermExamTicTacToe extends AppCompatActivity implements View.OnClickListener{
    private Button[][] buttons = new Button[3][3];
    private boolean isPlayerO = true;
    private boolean winnerExist = false;
    private int count = 0;
    TextView textViewTurn, textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midterm_exam);

        textViewTurn = findViewById(R.id.turntv);
        textViewTurn.setBackgroundColor(getColor(android.R.color.holo_red_light));
        textViewResult = findViewById(R.id.resulttv);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String stringid = "btn" + (i) + "_" + j;
                int resid = getResources().getIdentifier(stringid, "id", getPackageName());
                buttons[i][j] = findViewById(resid);

                buttons[i][j].setBackgroundColor(getColor(android.R.color.darker_gray));
                buttons[i][j].setOnClickListener(this);
            }
        }


        Button reset = findViewById(R.id.restartbtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(!((Button) view).getText().toString().equals(getString(R.string.empty)) || winnerExist) {
            return;
        }

        if (isPlayerO) {
            view.setBackgroundColor(getColor(android.R.color.holo_red_light));
            ((Button) view).setText(getString(R.string.O));
        } else {
            view.setBackgroundColor(getColor(android.R.color.holo_blue_light));
            ((Button) view).setText(getString(R.string.X));
        }

        count++;

        if (checkWinner()) {
            if (isPlayerO) {
                textViewResult.setText(getString(R.string.pOWins));
                Toast.makeText(getApplicationContext(), getString(R.string.pOWins), Toast.LENGTH_SHORT).show();
            } else {
                textViewResult.setText(getString(R.string.pXWins));
                Toast.makeText(getApplicationContext(), getString(R.string.pXWins), Toast.LENGTH_SHORT).show();
            }
            winnerExist = true;
        } else if (count == 9) {
            textViewResult.setText(getString(R.string.pDraw));
            Toast.makeText(getApplicationContext(), getString(R.string.pDraw), Toast.LENGTH_SHORT).show();
        } else {
            isPlayerO = !isPlayerO;
            updateTurn();
        }
    }

    public void updateTurn() {
        if (isPlayerO) {
            textViewTurn.setText(getString(R.string.pOTurn));
            textViewTurn.setBackgroundColor(getColor(android.R.color.holo_red_light));
        } else {
            textViewTurn.setText(getString(R.string.pXTurn));
            textViewTurn.setBackgroundColor(getColor(android.R.color.holo_blue_light));
        }
    }

    public boolean checkWinner() {
        String field[][] = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if(field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals(getString(R.string.empty))) {
                return true;
            }

            if(field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals(getString(R.string.empty))) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals(getString(R.string.empty))) {
            return true;
        }

        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals(getString(R.string.empty))) {
            return true;
        }

        return false;
    }
    public void restartGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setBackgroundColor(getColor(android.R.color.darker_gray));
                buttons[i][j].setText(getString(R.string.empty));
            }
        }

        textViewResult.setText(getString(R.string.empty));
        isPlayerO = true;
        winnerExist = false;
        count = 0;
        textViewTurn.setText(getString(R.string.pOTurn));
        textViewTurn.setBackgroundColor(getColor(android.R.color.holo_red_light));
    }
}