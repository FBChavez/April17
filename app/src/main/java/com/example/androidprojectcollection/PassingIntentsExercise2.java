package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    Button btnReturn;
    TextView tvFirstNamePlaceholder, tvLastNamePlaceholder, tvGenderPlaceholder, tvBirthDatePlaceholder, tvPhoneNumberPlaceholder, tvEmailAddressPlaceholder,
            tvAddressPlaceholder, tvProgramPlaceholder, tvYearLevelPlaceholder, tvIDNumberPlaceholder, tvFullNamePlaceholder, tvRelationshipPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        btnReturn = findViewById(R.id.btnReturn);

        tvFirstNamePlaceholder = findViewById(R.id.tvFirstNamePlaceholder);
        tvLastNamePlaceholder = findViewById(R.id.tvLastNamePlaceholder);
        tvGenderPlaceholder = findViewById(R.id.tvGenderPlaceholder);
        tvBirthDatePlaceholder = findViewById(R.id.tvBirthDatePlaceholder);
        tvPhoneNumberPlaceholder = findViewById(R.id.tvPhoneNumberPlaceholder);
        tvEmailAddressPlaceholder = findViewById(R.id.tvEmailAddressPlaceholder);
        tvAddressPlaceholder = findViewById(R.id.tvAddressPlaceholder);
        tvProgramPlaceholder = findViewById(R.id.tvProgramPlaceholder);
        tvYearLevelPlaceholder = findViewById(R.id.tvYearLevelPlaceholder);
        tvIDNumberPlaceholder = findViewById(R.id.tvIDNumberPlaceholder);
        tvFullNamePlaceholder = findViewById(R.id.tvFullNamePlaceholder);
        tvRelationshipPlaceholder = findViewById(R.id.tvRelationshipPlaceholder);

        Intent intent = getIntent();

        String first_name = intent.getStringExtra("first_name_key");
        String last_name = intent.getStringExtra("last_name_key");
        String gender = intent.getStringExtra("gender_key");;
        String birth_date = intent.getStringExtra("birth_date_key");
        String phone_number = intent.getStringExtra("phone_number_key");
        String email = intent.getStringExtra("email_key");
        String address = intent.getStringExtra("address_key");
        String program = intent.getStringExtra("program_key");
        String year_level = intent.getStringExtra("year_level_key");
        String id_number = intent.getStringExtra("id_number_key");
        String full_name = intent.getStringExtra("full_name_key");
        String relationship = intent.getStringExtra("relationship_key");

        tvFirstNamePlaceholder.setText(first_name);
        tvLastNamePlaceholder.setText(last_name);
        tvGenderPlaceholder.setText(gender);
        tvBirthDatePlaceholder.setText(birth_date);
        tvPhoneNumberPlaceholder.setText(phone_number);
        tvEmailAddressPlaceholder.setText(email);
        tvAddressPlaceholder.setText(address);
        tvProgramPlaceholder.setText(program);
        tvYearLevelPlaceholder.setText(year_level);
        tvIDNumberPlaceholder.setText(id_number);
        tvFullNamePlaceholder.setText(full_name);
        tvRelationshipPlaceholder.setText(relationship);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        PassingIntentsExercise2.this,
                        PassingIntentsExercise.class);
                startActivity(intent);
            }
        });
    }
}