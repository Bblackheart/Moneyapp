package com.hellokh.sovary.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Page2 extends AppCompatActivity {
    EditText getmEditText1;
    EditText getmEditText2;
    private EditText mEditText1;
    private EditText mEditText2;
    private TextView TextViewResult;
    private TextView TextView1Result;
    private Button mButtonAdd;
    private Button mButtonClear;
    private Button button;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        mEditText1 = findViewById(R.id.edittext_number_1);
        mEditText2 = findViewById(R.id.edittext_number_2);
        TextViewResult = findViewById(R.id.textview_result);
        TextView1Result = findViewById(R.id.textview1_result);
        mButtonAdd = findViewById(R.id.button_add);
        mButtonClear = findViewById(R.id.button_clear);
        getmEditText1 = findViewById(R.id.edittext_number_1);
        getmEditText2 = findViewById(R.id.edittext_number_2);



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
                Intent i = new Intent(Page2.this, Page2.class);
                startActivity(i);
            }
        });

        Button page3 = findViewById(R.id.page3);
        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page2.this, Page3.class);
                startActivity(i);
            }
        });

        Button page4 = findViewById(R.id.page4);
        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page2.this, Page4.class);
                startActivity(i);
            }
        });

        Button page1 = findViewById(R.id.page1);
        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page2.this, DashActivity.class);
                startActivity(i);
            }
        });

    }

    private void registerUser(String textAmount, String textAmount1) {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(textAmount, textAmount1).addOnCompleteListener(Page2.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    /*UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textAmount).build();
                    firebaseUser.updateProfile(profileChangeRequest);*/

                    /*ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textAmount, textAmount1);*/

                    DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered Users");

                    /*referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                firebaseUser.sendEmailVerification();
                            }
                        }
                    });*/
                }
            }
        });
    }


}

