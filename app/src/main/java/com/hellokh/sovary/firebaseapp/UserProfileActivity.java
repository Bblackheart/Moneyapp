package com.hellokh.sovary.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfileActivity extends AppCompatActivity {
    private TextView textViewWelcome, textViewUsername, textViewEmail;
    private ProgressBar progressBar;
    private String username, email;
    private FirebaseAuth authProfile;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        getSupportActionBar().setTitle("UserProfile");

        textViewWelcome = findViewById(R.id.textView_show_welcome);
        textViewUsername = findViewById(R.id.textView_show_username);
        textViewEmail = findViewById(R.id.textView_show_email);
        progressBar = findViewById(R.id.progressBar);

        logout = (Button)findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authProfile.signOut();
                finish();
                startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
                Toast.makeText(UserProfileActivity.this, "You have logged out", Toast.LENGTH_LONG).show();
            }
        });

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();

        if (firebaseUser == null){
            Toast.makeText(UserProfileActivity.this, "Something went wrong! User's details are not available at the moment",
                    Toast.LENGTH_LONG).show();
        } else  {
            progressBar.setVisibility(View.VISIBLE);
            showUserProfile(firebaseUser);
        }
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();

        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("App Financial").child("User");
        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
                if (readUserDetails != null){
                    username = firebaseUser.getDisplayName();
                    email = firebaseUser.getEmail();

                    username = readUserDetails.username;
                    email = readUserDetails.email;

                    textViewWelcome.setText("Welcome, " + username + "!");
                    textViewUsername.setText(username);
                    textViewEmail.setText(email);
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfileActivity.this, "Something went wrong! ", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}