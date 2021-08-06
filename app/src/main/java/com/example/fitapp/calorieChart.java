package com.example.fitapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class calorieChart extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    int totali;
    float total;
    double totald;
    private String userID;
    TextView average,weekly,totalcount,currentBmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_chart);

        currentBmi= findViewById(R.id.fbmi);
        average= findViewById(R.id.average);
        weekly= findViewById(R.id.weekly);
        totalcount= findViewById(R.id.total);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users1");
        userID = user.getUid();

        Toolbar toolbar = findViewById(R.id.toolbar2); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BarChart barChart= findViewById(R.id.barchart);
        ArrayList<BarEntry> calories=new ArrayList<>();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User1 userProfile = snapshot.getValue(User1.class);
                if (userProfile != null) {

                    Double totalkcal = userProfile.totalkcal;
                    Double kcalLoss = userProfile.kcalLoss;
                    Double bmi = userProfile.bmi;

                    totald = totalkcal - kcalLoss;
                    totali= (int) totald;
                    int weeklyi = 2200+2150+1966+1700+2500+1890+totali;
                    int averagei = weeklyi/7;

                    totalcount.setText(String.valueOf(totali));
                    weekly.setText(String.valueOf(weeklyi));
                    average.setText(String.valueOf(averagei));
                    currentBmi.setText(String.format("%.2f",bmi));
                    total = (float) totali;

                }
            }
                @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        calories.add(new BarEntry(1, 2200));
        calories.add(new BarEntry(2, 2150));
        calories.add(new BarEntry(3, 1966));
        calories.add(new BarEntry(4, 1700));
        calories.add(new BarEntry(5, 2500));
        calories.add(new BarEntry(6, 1890));
        calories.add(new BarEntry(7, 2287));

        BarDataSet barDataSet=new BarDataSet(calories,"Calories");
        barDataSet.setColors(getResources().getColor(R.color.red));
        barDataSet.setValueTextColor(Color.WHITE);
        barDataSet.setValueTextSize(16f);

        BarData bardata= new BarData(barDataSet);
        barChart.setTouchEnabled(false);
        barChart.getDescription().setEnabled(false);
        barChart.setBackgroundColor(getResources().getColor(R.color.dgrey));
        barChart.setFitBars(true);
        barChart.setData(bardata);
        barChart.animateY(2000);
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