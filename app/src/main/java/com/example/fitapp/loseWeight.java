package com.example.fitapp;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class loseWeight extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose_weight);

        Toolbar toolbar = findViewById(R.id.toolbar2); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);

    }
    private ArrayList<Model>getMyList(){
        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();
        m.setTitle("Bent-over Row");
        m.setDescription("10 reps, 3 sets");
        m.setImg(R.drawable.dumbbell2);
        models.add(m);

        m = new Model();
        m.setTitle("Romanian Deadlift");
        m.setDescription("10 reps, 3 sets");
        m.setImg(R.drawable.dumbbell);
        models.add(m);

        m = new Model();
        m.setTitle("Diamond push-ups");
        m.setDescription("10 reps, 3 sets");
        m.setImg(R.drawable.headright);
        models.add(m);

        m = new Model();
        m.setTitle("Wide-arm push-ups");
        m.setDescription("10 reps, 3 sets");
        m.setImg(R.drawable.headleft);
        models.add(m);

        m = new Model();
        m.setTitle("Squat");
        m.setDescription("20 reps, 2 sets");
        m.setImg(R.drawable.normal);
        models.add(m);

        m = new Model();
        m.setTitle("Split Squat");
        m.setDescription("20 reps, 2 sets");
        m.setImg(R.drawable.powerlifting);
        models.add(m);

        m = new Model();
        m.setTitle("Lateral Raise");
        m.setDescription("10 reps, 3 sets");
        m.setImg(R.drawable.headright);
        models.add(m);

        m = new Model();
        m.setTitle("Lunge Press");
        m.setDescription("10 reps, 5 sets");
        m.setImg(R.drawable.powerlifting3);
        models.add(m);

        m = new Model();
        m.setTitle("Dive-bomber");
        m.setDescription("20 seconds");
        m.setImg(R.drawable.headleft);
        models.add(m);

        m = new Model();
        m.setTitle("Renegade Row");
        m.setDescription("20 seconds");
        m.setImg(R.drawable.normal);
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
