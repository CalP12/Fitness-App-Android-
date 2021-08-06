package com.example.fitapp;

import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Step extends AppCompatActivity implements SensorEventListener{
    TextView Stepcounter,distance,calories,calorietext,steptext;
    SensorManager sensorManager;
    double calo;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    boolean running = false;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step);
        distance = findViewById(R.id.distance);
        calories = findViewById(R.id.calories);
        calorietext = findViewById(R.id.texxxxxt);
        steptext = findViewById(R.id.texxt);
        int unicodefire=0x1F525;
        int unicodefoot=0x1F463;
        String fire = getEmoji(unicodefire);
        String foot = getEmoji(unicodefoot);
        calorietext.setText("Calories burned "+fire);
        steptext.setText("Distance travelled "+foot);

        Toolbar toolbar = findViewById(R.id.toolbar2); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 101);
        Stepcounter=findViewById(R.id.ctr);
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            Toast.makeText(this, "SENSOR UNAVAILABLE", Toast.LENGTH_SHORT).show();
        }
    }
    public String getEmoji(int uni)
    {
        return new String(Character.toChars(uni));
    }
    @Override
    protected void onPause() {
        super.onPause();
        running = false;
    }
    @Override
    public void onSensorChanged(SensorEvent event)
    {
        String steps = String.valueOf(event.values[0]);
        Stepcounter.setText(steps);
        float stepsf= Float.parseFloat(steps);
        float dist = ((stepsf*8)/10000);
        distance.setText(String.format("%.2f km",dist));
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users1");
        userID = user.getUid();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User1 userProfile = snapshot.getValue(User1.class);
                if (userProfile != null) {
                    double bmi = userProfile.bmi;
                    if(bmi>25)
                        calo = (stepsf/1000)*52;
                    calo = (stepsf/1000)*37;
                    calories.setText(String.format("%.2f kcal",calo));
                    reference.child(userID).child("kcalLoss").setValue(calo);
                }
            }
                @Override
                public void onCancelled (@NonNull DatabaseError error){

                }
        });
}
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

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