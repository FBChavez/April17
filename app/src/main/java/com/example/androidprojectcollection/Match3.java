package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class Match3 extends AppCompatActivity {

    private Button[][] buttons = new Button[5][5];
    private int[][] colors = new int[5][5];
    private int[] color_list = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};

    private int points;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);

        points = 0;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                String buttonID = "btn" + i + "_" + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
//                colors[i][j] = generateColor();
            }
        }
    }

    void generateColor() {
        Random rand = new Random();
    }
}