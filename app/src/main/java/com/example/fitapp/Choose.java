package com.example.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Choose extends AppCompatActivity {
    ImageView muscle, gain, lose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

        Toolbar toolbar = findViewById(R.id.toolbar3); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        muscle = findViewById(R.id.muscle);
        gain = findViewById(R.id.gain);
        lose = findViewById(R.id.lose);
        gain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String plan= "Gain Weight";
                String email=intent.getStringExtra("e");
                String password=intent.getStringExtra("p");
                String date=intent.getStringExtra("d");
                String name=intent.getStringExtra("n");

                Intent intent2 = new Intent(getApplicationContext(),Current.class);
                intent2.putExtra("e",email);
                intent2.putExtra("n",name);
                intent2.putExtra("p",password);
                intent2.putExtra("d",date);
                intent2.putExtra("pl",plan);
                startActivity(intent2);

            }
        });
        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String plan= "Lose Weight";
                String email=intent.getStringExtra("e");
                String password=intent.getStringExtra("p");
                String date=intent.getStringExtra("d");
                String name=intent.getStringExtra("n");

                Intent intent2 = new Intent(getApplicationContext(),Current.class);
                intent2.putExtra("e",email);
                intent2.putExtra("n",name);
                intent2.putExtra("p",password);
                intent2.putExtra("d",date);
                intent2.putExtra("pl",plan);
                startActivity(intent2);
            }
        });
        muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String plan= "Gain Weight";
                String email=intent.getStringExtra("e");
                String password=intent.getStringExtra("p");
                String date=intent.getStringExtra("d");
                String name=intent.getStringExtra("n");

                Intent intent2 = new Intent(getApplicationContext(),Current.class);
                intent2.putExtra("e",email);
                intent2.putExtra("n",name);
                intent2.putExtra("p",password);
                intent2.putExtra("d",date);
                intent2.putExtra("pl",plan);
                startActivity(intent2);
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