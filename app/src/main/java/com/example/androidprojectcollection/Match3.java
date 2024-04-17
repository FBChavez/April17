package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Match3 extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[5][5];
    private int[][] colors = new int[5][5];
    private int clickedRow1 = -1, clickedCol1 = -1;
    private int clickedRow2 = -1, clickedCol2 = -1;
    private Button btnReset, btnRandomize;
    private int points = 0;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);

        scoreTextView = findViewById(R.id.score);
        scoreTextView.setText(getString(R.string.score_format, points));

        btnReset = findViewById(R.id.resetbtn);
        btnReset.setOnClickListener(this);

        btnRandomize = findViewById(R.id.randomizebtn);
        btnRandomize.setOnClickListener(this);

        initializeButtons();
        randomize();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.resetbtn:
                resetGame();
                break;
            case R.id.randomizebtn:
                randomize();
                break;
            default:
                handleTileClick((Button) v);
                break;
        }
    }

    private void initializeButtons() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "btn_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    private void handleTileClick(Button clickedButton) {
        String id = getResources().getResourceEntryName(clickedButton.getId());
        int row = Character.getNumericValue(id.charAt(4)); // Adjust index to get row number
        int col = Character.getNumericValue(id.charAt(5)); // Adjust index to get column number

        if (clickedRow1 == -1 && clickedCol1 == -1) {
            clickedRow1 = row;
            clickedCol1 = col;
        } else if (clickedRow2 == -1 && clickedCol2 == -1) {
            clickedRow2 = row;
            clickedCol2 = col;

            if (areAdjacent(clickedRow1, clickedCol1, clickedRow2, clickedCol2)) {
                swapTiles(clickedRow1, clickedCol1, clickedRow2, clickedCol2);
                checkMatches();
            } else {
                Toast.makeText(this, "Tiles are not adjacent!", Toast.LENGTH_SHORT).show();
            }

            clickedRow1 = -1;
            clickedCol1 = -1;
            clickedRow2 = -1;
            clickedCol2 = -1;
        }
    }


    private boolean areAdjacent(int row1, int col1, int row2, int col2) {
        return (Math.abs(row1 - row2) == 1 && col1 == col2) || (Math.abs(col1 - col2) == 1 && row1 == row2);
    }

    private void swapTiles(int row1, int col1, int row2, int col2) {
        int tempColor = colors[row1][col1];
        colors[row1][col1] = colors[row2][col2];
        colors[row2][col2] = tempColor;

        buttons[row1][col1].setBackgroundColor(colors[row1][col1]);
        buttons[row2][col2].setBackgroundColor(colors[row2][col2]);
    }

    private void checkMatches() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (colors[i][j] == colors[i][j + 1] && colors[i][j] == colors[i][j + 2]) {
                    points += 1;
                    updateScore(points);

                    colors[i][j] = generateColor();
                    colors[i][j + 1] = generateColor();
                    colors[i][j + 2] = generateColor();
                    buttons[i][j].setBackgroundColor(colors[i][j]);
                    buttons[i][j + 1].setBackgroundColor(colors[i][j + 1]);
                    buttons[i][j + 2].setBackgroundColor(colors[i][j + 2]);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (colors[i][j] == colors[i + 1][j] && colors[i][j] == colors[i + 2][j]) {
                    points += 1;
                    updateScore(points);

                    colors[i][j] = generateColor();
                    colors[i + 1][j] = generateColor();
                    colors[i + 2][j] = generateColor();
                    buttons[i][j].setBackgroundColor(colors[i][j]);
                    buttons[i + 1][j].setBackgroundColor(colors[i + 1][j]);
                    buttons[i + 2][j].setBackgroundColor(colors[i + 2][j]);
                }
            }
        }
    }

    private int generateColor() {
        Random rnd = new Random();
        int colorIndex = rnd.nextInt(4);
        switch (colorIndex) {
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }

    private void randomize() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                colors[i][j] = generateColor();
                buttons[i][j].setBackgroundColor(colors[i][j]);
            }
        }
        checkMatches();
    }

    private void updateScore(int points) {
        scoreTextView.setText(getString(R.string.score_format, points));
    }

    private void resetGame() {
        points = 0;
        updateScore(points);
        randomize();
    }
}