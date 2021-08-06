package com.example.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    String plan;
    TextView greeting,prog1,prog2,lose_gain;
    ProgressBar progr1,progr2;
    String checklose = "Lose Weight";
    Button log;
    CardView bmi,stepc,begin,diet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Toolbar toolbar = findViewById(R.id.toolbar2); //toolbar
        setSupportActionBar(toolbar);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users1");
        userID = user.getUid();

        progr1 = findViewById(R.id.progress_bar);
        progr2 = findViewById(R.id.progress_bar2);
        prog1 = findViewById(R.id.pro1);
        prog2 = findViewById(R.id.pro2);
        prog1.setText("0%");
        prog2.setText("0%");
        lose_gain = findViewById(R.id.textView10);

        log=findViewById(R.id.logout);
        greeting=findViewById(R.id.greeting);
        stepc=findViewById(R.id.step);
        stepc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Step.class));
            }
        });
        bmi=findViewById(R.id.bmic);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,BMI.class));
            }
        });
        begin=findViewById(R.id.beginc);
        diet = findViewById(R.id.diet);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Home.this,MainActivity.class));
                Toast.makeText(Home.this, "User Logged Out", Toast.LENGTH_SHORT).show();
            }
        });

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User1 userProfile = snapshot.getValue(User1.class);
                if(userProfile!=null)
                {
                    String name = userProfile.name;
                    plan = userProfile.plan;


                    greeting.setText("Hello, "+ name);

                    if(plan.equals(checklose)){
                        lose_gain.setText("Daily Calorie Loss");
                        begin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Home.this,loseWeight.class));
                            }
                        });
                        diet.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Home.this, Diet.class));
                            }
                        });
                    }
                    else{
                        lose_gain.setText("Daily Calorie Gain");
                        begin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Home.this,gainWeight.class));
                            }
                        });
                        diet.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Home.this, gainDiet.class));
                            }
                        });
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) //toolbar chart
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.chart:
                startActivity(new Intent(Home.this,calorieChart.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User1 userProfile = snapshot.getValue(User1.class);
                String plan = userProfile.plan;
                Integer workoutsint = (userProfile.workouts * 10);
                String workoutCount = workoutsint.toString();
                prog1.setText(workoutCount + "%");
                progr1.setProgress(workoutsint);

                if(plan.equals(checklose)) {
                    Double calo = userProfile.kcalLoss;
                    double goal = (calo / 500) * 100;
                    int goalProgress = (int) goal;
                    String goalString = String.format("%.1f", goal);
                    prog2.setText(goalString + "%");
                    progr2.setProgress(goalProgress);
                }
                else {
                    Double calo = userProfile.totalkcal;
                    double goal = (calo / 3000) * 100;
                    int goalProgress = (int)goal;
                    String goalString = String.format("%.1f", goal);
                    prog2.setText(goalString + "%");
                    progr2.setProgress(goalProgress);
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}