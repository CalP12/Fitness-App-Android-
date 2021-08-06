package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment1 extends Fragment {
    RecyclerView mRecyclerView;
    DietAdapter myAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_1, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView2);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription("A regular sized apple with a glass of water.\n\nCalories: 52kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.apple);
        m.setotalkcal(52.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("Half bowl of cantaloupes and a glass of water.\n\nCalories: 60kcal\nFat: 0.3g\nCarbs: 14.4g\nProtein: 1.5g");
        m.setImg(R.drawable.cantaloupes);
        m.setotalkcal(60.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("A serving of watermelon and two glasses of water.\n\nCalories: 130kcal\nFat: 0.2g\nCarbs: 11.6g\nProtein: 0.9g");
        m.setImg(R.drawable.watermelon);
        m.setotalkcal(130.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("A whole orange and a glass of water.\n\nCalories: 62kcal\nFat: 0.16g\nCarbs: 15.4g\nProtein: 1.2g");
        m.setImg(R.drawable.orange);
        m.setotalkcal(62.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("Sliced cantaloupe and a guava with two glasses of water.\n\nCalories: 172kcal\nFat: 1.9g\nCarbs: 38g\nProtein: 5.7g");
        m.setImg(R.drawable.guava);
        m.setotalkcal(172.0);
        models.add(m);

        return models;
    }
}