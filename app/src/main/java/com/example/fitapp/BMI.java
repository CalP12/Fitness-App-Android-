package com.example.fitapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BMI extends AppCompatActivity {
    EditText height,weight;
    Button cal;
    TextView res,health,currentBmi;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        Toolbar toolbar = findViewById(R.id.toolbar2); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        currentBmi= findViewById(R.id.fbmi);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users1");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User1 userProfile = snapshot.getValue(User1.class);
                if(userProfile!=null)
                {
                    String cwe = userProfile.we;
                    String che = userProfile.he;
                    float ch= Float.parseFloat(che);
                    float cw= Float.parseFloat(cwe);
                    double cr = cw/((ch/100)*(ch/100));
                    Double bmi = cr;
                    reference.child(userID).child("bmi").setValue(bmi);
                    if(cr<=18.5){
                        currentBmi.setTextColor(Color.parseColor("#FF3D41"));
                    }
                    else if(cr>=18.5 && cr<=24.9)
                    {
                        currentBmi.setTextColor(Color.parseColor("#45F248"));

                    }
                    else if(cr>=25 && cr<=24.9)
                    {
                        currentBmi.setTextColor(Color.parseColor("#FF3D41"));
                    }
                    else{
                        currentBmi.setTextColor(Color.parseColor("#FF3D41"));
                    }
                    currentBmi.setText(String.format("%.2f",cr));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        cal=findViewById(R.id.calc);
        res=findViewById(R.id.result);
        health=findViewById(R.id.health);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setEnabled(false);
                height.setEnabled(true);
                String he = height.getText().toString();
                String we = weight.getText().toString();
                if(we.isEmpty()){
                    weight.setError("Weight Required!");
                    weight.requestFocus();
                    return;
                }
                if(he.isEmpty()){
                    height.setError("Height Required!");
                    height.requestFocus();
                    return;
                }
                float h= Float.parseFloat(he);
                float w= Float.parseFloat(we);
                float r = w/((h/100)*(h/100));
                if(r<=18.5){
                    health.setText("Underweight");
                    health.setTextColor(Color.parseColor("#FF3D41"));

                }
                else if(r>=18.5 && r<=24.9)
                {
                    health.setText("Normal");
                    health.setTextColor(Color.parseColor("#45F248"));

                }
                else if(r>=25 && r<=24.9)
                {
                    health.setText("Overweight");
                    health.setTextColor(Color.parseColor("#FF3D41"));

                }
                else{
                    health.setText("Obese");
                    health.setTextColor(Color.parseColor("#FF3D41"));
                    weight.clearFocus();
                }

                res.setText(String.format("%.2f",r));

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
