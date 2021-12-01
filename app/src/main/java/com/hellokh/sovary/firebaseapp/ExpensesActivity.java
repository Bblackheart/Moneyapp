package com.hellokh.sovary.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExpensesActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private Button submitbtn;
    private DatabaseReference reff;
    ReadWriteUserDetails readWriteUserDetails;
    private Button clearbtn;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        display = findViewById(R.id.edittext_number_1);
        editTextNumber = findViewById(R.id.edittext_number_1);
        editTextNumber.setShowSoftInputOnFocus(true);
        submitbtn = findViewById(R.id.Submit_btn);
        reff = FirebaseDatabase.getInstance().getReference().child("App Financial").child("income-expense");
        getSupportActionBar().setTitle("Expenses");
        readWriteUserDetails = new ReadWriteUserDetails();
        clearbtn = findViewById(R.id.clear_btn);

        editTextNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString()))
                    display.setText("");
            }
        });

        Button buttonBack = findViewById(R.id.Back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpensesActivity.this, DashActivity.class);
                startActivity(intent);
            }
        });
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long revenue1 = Long.parseLong(editTextNumber.getText().toString());

                readWriteUserDetails.setExp(revenue1);

                reff.child("expenses").setValue(readWriteUserDetails);
                Toast.makeText(ExpensesActivity.this, "Record Successfully", Toast.LENGTH_LONG).show();
            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumber.getText().clear();
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void onebtn(View view) { updateText("1"); }

    public void fivebtn(View view){
        updateText("5");
    }

    public void tenbtn(View view){
        updateText("10");
    }

    public void twentybtn(View view) { updateText("20"); }

    public void fiftybtn(View view){
        updateText("50");
    }

    public void onehundredbtn(View view){
        updateText("100");
    }
}