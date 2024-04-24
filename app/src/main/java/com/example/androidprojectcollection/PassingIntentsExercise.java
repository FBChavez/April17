package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PassingIntentsExercise extends AppCompatActivity {

    Button btnClearForm, btnSubmitForm;
    EditText etFirstName, etLastName, etBirthDate, etPhoneNumber, etEmail, etAddress, etProgram, etYearLevel, etIDNumber, etFullName, etRelationship;
    RadioButton rbMale, rbFemale, rbOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        btnClearForm = findViewById(R.id.btnClearForm);
        btnSubmitForm = findViewById(R.id.btnReturn);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);

        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOthers = findViewById(R.id.rbOthers);

        etBirthDate = findViewById(R.id.etBirthDate);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etProgram = findViewById(R.id.etProgram);
        etYearLevel = findViewById(R.id.etYearLevel);
        etIDNumber = findViewById(R.id.etIDNumber);
        etFullName = findViewById(R.id.etFullName);
        etRelationship = findViewById(R.id.etRelationship);

        btnSubmitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = etFirstName.getText().toString();
                String last_name = etLastName.getText().toString();

                String gender;
                if(rbMale.isChecked())
                    gender = "Male";
                else if (rbFemale. isChecked())
                    gender = "Female";
                else if (rbOthers.isChecked())
                    gender = "Others";
                else
                    gender = "Unknown";

                String birth_date = etBirthDate.getText().toString();
                String phone_number = etPhoneNumber.getText().toString();
                String email = etEmail.getText().toString();
                String address = etAddress.getText().toString();
                String program = etProgram.getText().toString();
                String year_level = etYearLevel.getText().toString();
                String id_number = etIDNumber.getText().toString();
                String full_name = etFullName.getText().toString();
                String relationship = etRelationship.getText().toString();

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                intent.putExtra("first_name_key", first_name);
                intent.putExtra("last_name_key", last_name);
                intent.putExtra("gender_key", gender);
                intent.putExtra("birth_date_key", birth_date);
                intent.putExtra("phone_number_key", phone_number);
                intent.putExtra("email_key", email);
                intent.putExtra("address_key", address);
                intent.putExtra("program_key", program);
                intent.putExtra("year_level_key", year_level);
                intent.putExtra("id_number_key", id_number);
                intent.putExtra("full_name_key", full_name);
                intent.putExtra("relationship_key", relationship);

                startActivity(intent);
            }
        });

        btnClearForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etFirstName.getText().clear();
                etLastName.getText().clear();

                rbMale.setChecked(false);
                rbFemale.setChecked(false);
                rbOthers.setChecked(false);

                etBirthDate.getText().clear();
                etPhoneNumber.getText().clear();
                etEmail.getText().clear();
                etAddress.getText().clear();
                etProgram.getText().clear();
                etYearLevel.getText().clear();
                etIDNumber.getText().clear();
                etFullName.getText().clear();
                etRelationship.getText().clear();
            }
        });

    }
}