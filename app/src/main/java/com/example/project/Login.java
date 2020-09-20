package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText emailId, password;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener maAthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignIn = findViewById(R.id.button2);
        tvSignUp= findViewById(R.id.textView);

        maAthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser !=null){
                    Toast.makeText(Login.this, "You Have Successfully Logged In", Toast.LENGTH_SHORT).show();

                }

            }
        };
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignIn = new Intent(Login.this,HomeActivity.class);
                startActivity(intSignIn);

            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(Login.this,MainActivity.class);
                startActivity(intSignUp);

            }
        });

    }
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(maAthStateListener);

    }
}