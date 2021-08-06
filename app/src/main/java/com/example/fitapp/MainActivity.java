package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button login, register;
    EditText emai,passwor;
    ProgressBar proge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mAuth = FirebaseAuth.getInstance();
        emai = findViewById(R.id.email);
        proge = findViewById(R.id.progressB);
        passwor = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emai.getText().toString().trim();
                String password = passwor.getText().toString().trim();
                if(email.isEmpty()){
                    emai.setError("Email Required!");
                    emai.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    emai.setError("Invalid Email Address!");
                    emai.requestFocus();
                    return;
                }
                if(password.isEmpty()){
                    passwor.setError("Password Required!");
                    passwor.requestFocus();
                    return;
                }
                if(password.length() < 6)
                {
                    passwor.setError("Password must be 6 characters or more!");
                    passwor.requestFocus();
                    return;
                }
                proge.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            proge.setVisibility(View.GONE);
                            startActivity(new Intent(MainActivity.this,Home.class));
                        }
                        else{
                            proge.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "Email/Password is incorrect!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register1.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}