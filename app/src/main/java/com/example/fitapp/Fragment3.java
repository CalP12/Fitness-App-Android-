package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment3 extends Fragment {
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
        View view= inflater.inflate(R.layout.fragment_3, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView4);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription("Half a bowl of cantaloupe or a sliced apple and two glasses of water.\n\nCalories: 150kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.cantaloupes);
        m.setotalkcal(150.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("Half a sliced pineapple or a pear and two glasses of water.\n\nCalories: 65kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.pineapple);
        m.setotalkcal(65.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("A salad of cucumber, carrots, and lettuce with two glasses of water.\n\nCalories: 200kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.carrotcucum);
        m.setotalkcal(200.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("An orange or a pear with half a sliced cantaloupe and a glass of water.\n\nCalories: 75kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.pear);
        m.setotalkcal(75.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("Boiled Broccoli and beets with two glasses of water.\n\nCalories: 165kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.broccolibeet);
        m.setotalkcal(165.0);
        models.add(m);

        return models;
    }
}