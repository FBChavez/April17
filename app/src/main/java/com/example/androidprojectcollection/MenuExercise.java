package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
        resetToDefault();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mItemChange) {
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemChangeColor) {
            Toast.makeText(this, "Change Button Color Object Item is clicked", Toast. LENGTH_SHORT).show();
            changeBtnColor();
        } else if (item.getItemId() == R.id.mItemChangeColorText) {
            Toast.makeText(this, "Change Text Color Object Item is clicked", Toast. LENGTH_SHORT).show();
            changeTextColor();
        } else if (item.getItemId() == R.id.mItemChangeTextSize) {
            Toast.makeText(this, "Change Text size Object Item is clicked", Toast. LENGTH_SHORT).show();
            changeTextSize();
        } else if (item.getItemId() == R.id.mItemChangeSize) {
            Toast.makeText(this, "Change Size Object Item is clicked", Toast. LENGTH_SHORT).show();
            changeBtnSize();
        } else if (item.getItemId() == R.id.mItemChangeText) {
            Toast.makeText(this, "Change Text Object Item is clicked", Toast. LENGTH_SHORT).show();
            changeBtnText();
        } else if (item.getItemId() == R.id.mItemReset) {
            Toast.makeText(this, "Reset Object Item is clicked", Toast. LENGTH_SHORT).show();
            resetToDefault();
        } else if (item.getItemId() == R.id.mItemExit) {
            finish();
        }
        return true;
    }

    private void changeTextColor() {
        Random random = new Random();
        int colorIndex = random.nextInt(5);
        switch (colorIndex) {
            case 0:
                btnChanger.setTextColor(getColor(android.R.color.holo_red_dark));
                break;
            case 1:
                btnChanger.setTextColor(getColor(android.R.color.holo_green_dark));
                break;
            case 2:
                btnChanger.setTextColor(getColor(android.R.color.holo_blue_dark));
                break;
            case 3:
                btnChanger.setTextColor(getColor(android.R.color.holo_orange_dark));
                break;
            case 4:
                btnChanger.setTextColor(getColor(android.R.color.darker_gray));
                break;
        }
    }

    private void changeTextSize() {
        Random random = new Random();
        float size = random.nextFloat();

        btnChanger.setTextSize((size*10) + 30);
    }

    public void changeBtnColor() {
        Random random = new Random();
        int colorIndex = random.nextInt(5);
        switch (colorIndex) {
            case 0:
                btnChanger.setBackgroundColor(getColor(android.R.color.holo_red_light));
                break;
            case 1:
                btnChanger.setBackgroundColor(getColor(android.R.color.holo_green_light));
                break;
            case 2:
                btnChanger.setBackgroundColor(getColor(android.R.color.holo_blue_light));
                break;
            case 3:
                btnChanger.setBackgroundColor(getColor(android.R.color.holo_orange_light));
                break;
            case 4:
                btnChanger.setBackgroundColor(getColor(android.R.color.holo_purple));
                break;
        }
    }

    public void changeBtnSize() {
        Random random = new Random();
        int size = random.nextInt(400);
        btnChanger.setWidth(size + 400);
        btnChanger.setHeight(size + 400);
    }

    public void changeBtnText() {
        btnChanger.setText(getString(R.string.changed_text));
    }

    public void resetToDefault() {
        btnChanger.setBackgroundColor(getColor(R.color.bluish));

        btnChanger.setText(getString(R.string.default_text));

        btnChanger.setWidth(800);
        btnChanger.setHeight(800);

        btnChanger.setTextSize(30);

        btnChanger.setTextColor(getColor(android.R.color.black));
    }
}