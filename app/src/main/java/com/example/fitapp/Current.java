package com.example.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Current extends AppCompatActivity {
    EditText weight, height;
    Button done;
    ProgressBar prog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current);

        Toolbar toolbar = findViewById(R.id.toolbar2); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        prog = findViewById(R.id.progressBar2);
        done = findViewById(R.id.next);
        mAuth = FirebaseAuth.getInstance();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = getIntent();
                String email=intent2.getStringExtra("e");
                String password=intent2.getStringExtra("p");
                String date=intent2.getStringExtra("d");
                String name=intent2.getStringExtra("n");
                String plan=intent2.getStringExtra("pl");

                String he = height.getText().toString();
                String we = weight.getText().toString();
                Double kcal = 0.0;
                Double bmi = 0.0;
                Integer workouts = 0;
                Double totalkcal = 0.0;

                prog.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    User1 user = new User1(name,date,email,plan,we,he,workouts,kcal,totalkcal,bmi);
                                    FirebaseDatabase.getInstance().getReference("Users1")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful())
                                            {
                                                Toast.makeText(Current.this, "Registration Successful!", Toast.LENGTH_LONG).show();
                                                prog.setVisibility(View.GONE);
                                                startActivity(new Intent(Current.this,MainActivity.class));
                                            }
                                            else{
                                                Toast.makeText(Current.this, "Failed to Register", Toast.LENGTH_LONG).show();
                                                prog.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                                }
                                else{
                                    Toast.makeText(Current.this, "Failed to Register", Toast.LENGTH_LONG).show();
                                    prog.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });
    }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) //toolbar back
        {
            if(item.getItemId() == android.R.id.home){
                finish();
            }
            return super.onOptionsItemSelected(item);
        }

}