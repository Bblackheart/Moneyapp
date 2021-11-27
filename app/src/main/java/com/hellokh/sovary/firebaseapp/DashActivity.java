package com.hellokh.sovary.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        Button page2 = findViewById(R.id.page2);
        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashActivity.this , Page2.class);
                startActivity(intent);
            }
        });

        Button page3 = findViewById(R.id.page3);
        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashActivity.this , Page3.class);
                startActivity(intent);
            }
        });

        Button page4 = findViewById(R.id.page4);
        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashActivity.this , Page4.class);
                startActivity(intent);
            }
        });

        Button page1 = findViewById(R.id.page1);
        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashActivity.this , DashActivity.class);
                startActivity(intent);
            }
        });

        Button login = findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashActivity.this ,MainActivity.class);
                startActivity(intent);
            }
        });

        Button revenueAcivity = findViewById(R.id.revenuebtn);
        revenueAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashActivity.this ,RevenueActivity.class);
                startActivity(intent);
            }
        });

        Button expensesAcivity = findViewById(R.id.expensesbtn);
        expensesAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashActivity.this ,ExpensesActivity.class);
                startActivity(intent);
            }
        });
    }
}