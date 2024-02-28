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

    Button btnLayoutExercise, closeBtn, toastBtn, changeBgBtn, changeBtnBgBtn, disappearBtn;

    ConstraintLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLayoutExercise = (Button) findViewById(R.id.btnLayoutExercise);
        btnLayoutExercise.setOnClickListener(new View.OnClickListener() {
            // gateway from one activity to another
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        MainActivity.this, // this activity
                        LayoutExercise.class); // destination activity
                startActivity(intent1);
            }
        });

        closeBtn = findViewById(R.id.closebtn);
        toastBtn = findViewById(R.id.toastbtn);
        changeBgBtn = findViewById(R.id.changebgbtn);
        changeBtnBgBtn = findViewById(R.id.changebtnbgbtn);
        disappearBtn = findViewById(R.id.disappearbtn);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        MainActivity.this,
                        EmptyActivity.class
                );
                startActivity(intent1);
            }
        });

        toastBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Let's make a toast!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        changeBgBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bg = ((ConstraintLayout)findViewById(R.id.bg));
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
                bg.setBackgroundColor(color);
            }
        });

        changeBtnBgBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
                v.setBackgroundColor(color);
            }
        });

        disappearBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                disappearBtn.setVisibility(v.INVISIBLE);
            }
        });
    }
}