package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnLayoutExercise, btnButtonExercise, btnCalculatorExercise, btnMidtermExamTicTacToe, btnMatch3Exercise, btnPassingIntents;

    ConstraintLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLayoutExercise = (Button) findViewById(R.id.btnLayoutExercise);
        btnButtonExercise = (Button) findViewById(R.id.btnButtonExercise);
        btnCalculatorExercise = findViewById(R.id.btnCalculatorExercise);
        btnMidtermExamTicTacToe = findViewById(R.id.btnMidtermExam);
        btnMatch3Exercise = findViewById(R.id.btnMatch3Exercise);
        btnPassingIntents = findViewById(R.id.btnPassingIntents);


        btnLayoutExercise.setOnClickListener(new View.OnClickListener() {
            // gateway from one activity to another
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // this activity
                        LayoutExercise.class); // destination activity
                startActivity(intent);
            }
        });
        btnButtonExercise.setOnClickListener(new View.OnClickListener() {
            // gateway from one activity to another
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // this activity
                        ButtonExercise.class); // destination activity
                startActivity(intent);
            }
        });
        btnCalculatorExercise.setOnClickListener(new View.OnClickListener() {
            // gateway from one activity to another
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // this activity
                        CalculatorExercise.class); // destination activity
                startActivity(intent);
            }
        });

        btnMidtermExamTicTacToe.setOnClickListener(new View.OnClickListener() {
            // gateway from one activity to another
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // this activity
                        MidtermExamTicTacToe.class); // destination activity
                startActivity(intent);
            }
        });

        btnMatch3Exercise.setOnClickListener(new View.OnClickListener() {
            // gateway from one activity to another
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // this activity
                        Match3.class); // destination activity
                startActivity(intent);
            }
        });

        btnPassingIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        PassingIntentsExercise.class);
                startActivity(intent);
            }
        });
    }
}