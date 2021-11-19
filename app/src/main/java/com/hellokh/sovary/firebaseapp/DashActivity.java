package com.hellokh.sovary.firebaseapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashActivity extends AppCompatActivity {
    private TextView textViewAmount;
    private Button button;
    private String amount;
    private FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        textViewAmount = findViewById(R.id.total);

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();

        Button page2 = findViewById(R.id.page2);
        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, Page2.class);
                startActivity(intent);
            }
        });

        Button page3 = findViewById(R.id.page3);
        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, Page3.class);
                startActivity(intent);
            }
        });

        Button page4 = findViewById(R.id.page4);
        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, Page4.class);
                startActivity(intent);
            }
        });

        Button page1 = findViewById(R.id.page1);
        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, DashActivity.class);
                startActivity(intent);
            }
        });

        Button logout = findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button revenueAcivity = findViewById(R.id.revenuebtn);
        revenueAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, RevenueActivity.class);
                startActivity(intent);
            }
        });

        Button expensesAcivity = findViewById(R.id.expensesbtn);
        expensesAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashActivity.this, expensesActivity.class);
                startActivity(intent);
            }
        });
            showUserProfile(firebaseUser);
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();

        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("User");
        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if (user != null) {
                    amount = firebaseUser.getDisplayName();
                    amount = user.amount;
                    textViewAmount.setText(amount);

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DashActivity.this, "Something went wrong! ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
