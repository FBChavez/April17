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

public class activity_button_exercise extends AppCompatActivity {

    Button closeBtn, toastBtn, changeBgBtn, changeBtnBgBtn, disappearBtn;
    ConstraintLayout bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        closeBtn = (Button) findViewById(R.id.closebtn1);
        toastBtn = (Button) findViewById(R.id.toastbtn1);
        changeBgBtn = (Button) findViewById(R.id.changebgbtn1);
        changeBtnBgBtn = (Button) findViewById(R.id.changebtnbgbtn1);
        disappearBtn = (Button) findViewById(R.id.disappearbtn1);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        activity_button_exercise.this,
                        EmptyActivity.class
                );
                startActivity(intent1);
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        activity_button_exercise.this,
                        EmptyActivity.class
                );
                startActivity(intent1);
            }
        });

        toastBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(activity_button_exercise.this, "Let's make a toast!", Toast.LENGTH_SHORT);
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