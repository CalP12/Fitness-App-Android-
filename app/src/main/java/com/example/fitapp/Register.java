package com.example.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText nam,dob,emai,passwor;
    Button register;
    ProgressBar prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mAuth = FirebaseAuth.getInstance();
        nam = findViewById(R.id.name);
        dob = findViewById(R.id.dob);
        emai = findViewById(R.id.em);
        passwor = findViewById(R.id.pass);
        prog = findViewById(R.id.progressBar2);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emai.getText().toString().trim();
                String password = passwor.getText().toString().trim();
                String name = nam.getText().toString().trim();
                String date = dob.getText().toString().trim();

                if(name.isEmpty()){
                    nam.setError("Name Required!");
                    nam.requestFocus();
                    return;
                }
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

                if(date.isEmpty()){
                    dob.setError("D.O.B Required!");
                    dob.requestFocus();
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
                prog.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    User user = new User(name,date,email);
                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful())
                                            {
                                                Toast.makeText(Register.this, "Registration Successful!", Toast.LENGTH_LONG).show();
                                                prog.setVisibility(View.GONE);
                                                startActivity(new Intent(Register.this,Choose.class));
                                            }
                                            else{
                                                Toast.makeText(Register.this, "Failed to Register", Toast.LENGTH_LONG).show();
                                                prog.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                                }
                                else{
                                    Toast.makeText(Register.this, "Failed to Register", Toast.LENGTH_LONG).show();
                                    prog.setVisibility(View.GONE);
                                }
                            }
                        });

            }
        });
    }
}