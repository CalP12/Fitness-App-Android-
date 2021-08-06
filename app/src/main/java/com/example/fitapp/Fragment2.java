package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment2 extends Fragment {
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
        View view= inflater.inflate(R.layout.fragment_2, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView3);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription("A boiled potato. You can also add a teaspoon of low-fat butter for flavor.\n\nCalories: 86kcal\nFat: 0.1g\nCarbs: 20.4g\nProtein: 2.2g");
        m.setImg(R.drawable.potato);
        m.setotalkcal(86.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("Cabbage and lettuce salad with a light dressing and a glass of water.\n\nCalories:58kcal\nFat: 15g\nCarbs: 22g\nProtein: 1.9g");
        m.setImg(R.drawable.lettuce);
        m.setotalkcal(58.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("A mixed vegetable salad with cucumbers, onions, and carrots and two glasses of water.\n\nCalories: 33kcal\nFat: 0.1g\nCarbs: 6.7g\nProtein: 2.6g");
        m.setImg(R.drawable.cucumsalad);
        m.setotalkcal(33.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("A cup of boiled broccoli, half a cup of sliced bell pepper, and two glasses of water.\n\nCalories: 34kcal\nFat: 0.3g\nCarbs: 6g\nProtein: 2.5g");
        m.setImg(R.drawable.broccoli);
        m.setotalkcal(34.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("A salad comprising of boiled carrots, broccoli, and green beans, and two glasses of water.\n\nCalories: 120kcal\nFat: 1.2g\nCarbs: 20.8g\nProtein: 2.2g");
        m.setImg(R.drawable.carrotbean);
        m.setotalkcal(120.0);
        models.add(m);

        return models;
    }
}