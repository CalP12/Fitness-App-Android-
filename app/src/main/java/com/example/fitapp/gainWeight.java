package com.example.fitapp;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class gainWeight extends AppCompatActivity {
    RecyclerView mRecyclerView;
    gainAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gain_weight);

        Toolbar toolbar = findViewById(R.id.toolbar2); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new gainAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);

    }
    private ArrayList<Model3>getMyList(){
        ArrayList<Model3> models = new ArrayList<>();
        Model3 m = new Model3();
        m.setTitle("Biceps Curls");
        m.setDescription("12 reps, 3 sets");
        m.setImg(R.drawable.dumbbell3);
        models.add(m);

        m = new Model3();
        m.setTitle("Triceps extension");
        m.setDescription("12 reps, 3 sets");
        m.setImg(R.drawable.dumbbell);
        models.add(m);

        m = new Model3();
        m.setTitle("Bench Press");
        m.setDescription("10 reps, 5 sets");
        m.setImg(R.drawable.powerlifting3);
        models.add(m);

        m = new Model3();
        m.setTitle("Overhead press");
        m.setDescription("10 reps, 5 sets");
        m.setImg(R.drawable.powerlifting);
        models.add(m);

        m = new Model3();
        m.setTitle("Chin-Up");
        m.setDescription("10 reps, 5 sets");
        m.setImg(R.drawable.bar);
        models.add(m);

        m = new Model3();
        m.setTitle("Triceps dip");
        m.setDescription("10 reps, 5 sets");
        m.setImg(R.drawable.barup);
        models.add(m);

        m = new Model3();
        m.setTitle("Glute bridge");
        m.setDescription("12 reps, 3 sets");
        m.setImg(R.drawable.powerlifting3);
        models.add(m);

        m = new Model3();
        m.setTitle("Reverse flye");
        m.setDescription("12 reps, 3 sets");
        m.setImg(R.drawable.dumbbell2);
        models.add(m);

        m = new Model3();
        m.setTitle("Seated incline curl");
        m.setDescription("12 reps, 3 sets");
        m.setImg(R.drawable.seat);
        models.add(m);

        m = new Model3();
        m.setTitle("Incline dumbbell press");
        m.setDescription("12 reps, 3 sets");
        m.setImg(R.drawable.seat);
        models.add(m);
        return models;
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
