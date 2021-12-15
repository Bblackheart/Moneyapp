package com.hellokh.sovary.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalculateActivity extends AppCompatActivity {
    EditText getmEditText1;
    EditText getmEditText2;
    private EditText mEditText1;
    private EditText mEditText2;
    private TextView TextViewResult;
    private TextView TextView1Result;
    private Button mButtonAdd;
    private Button mButtonClear;
    private Button button_save;
    private DatabaseReference ref;
    ReadWriteUserDetails readWriteUserDetails;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        mEditText1 = findViewById(R.id.edittext_number_1);
        mEditText2 = findViewById(R.id.edittext_number_2);
        TextViewResult = findViewById(R.id.textview_result);
        TextView1Result = findViewById(R.id.textview1_result);
        mButtonAdd = findViewById(R.id.button_add);
        mButtonClear = findViewById(R.id.button_clear);
        getmEditText1 = findViewById(R.id.edittext_number_1);
        getmEditText2 = findViewById(R.id.edittext_number_2);
        button_save = findViewById(R.id.button_save);
        ref = FirebaseDatabase.getInstance().getReference().child("App Financial").child("calculate");
        readWriteUserDetails = new ReadWriteUserDetails();



        getSupportActionBar().setTitle("Calculate");


        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText1.getText().toString().length() == 0) {
                    mEditText1.setText("0");
                }
                if (mEditText2.getText().toString().length() == 0) {
                    mEditText2.setText("0");
                }
                int num1 = Integer.parseInt(mEditText1.getText().toString());
                int num2 = Integer.parseInt(mEditText2.getText().toString());

                int sum = (num1 - num2) / 30;
                int sum1 = (num1 - num2) / 7;

                TextViewResult.setText(String.valueOf(sum));
                TextView1Result.setText(String.valueOf(sum1));
            }
        });

        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getmEditText1.getText().clear();
                getmEditText2.getText().clear();

            }
        });


        Button page2 = findViewById(R.id.page2);
        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CalculateActivity.this, CalculateActivity.class);
                startActivity(i);
            }
        });

        Button page3 = findViewById(R.id.page3);
        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CalculateActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

        Button page4 = findViewById(R.id.page4);
        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CalculateActivity.this, UserProfileActivity.class);
                startActivity(i);
            }
        });

        Button page1 = findViewById(R.id.page1);
        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CalculateActivity.this, DashActivity.class);
                startActivity(i);
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertCalculate();
            }
        });

    }
    private void insertCalculate(){
        String calculate = TextViewResult.getText().toString().trim();
        String calculate1 = TextView1Result.getText().toString().trim();

        InsertCal insertCal = new InsertCal(calculate);
        InsertCal1 insertCal1 = new InsertCal1(calculate1);
        ref.push().setValue(insertCal);
        ref.push().setValue(insertCal1);
        Toast.makeText(CalculateActivity.this, "Save data successfully", Toast.LENGTH_LONG).show();
    }


    }



