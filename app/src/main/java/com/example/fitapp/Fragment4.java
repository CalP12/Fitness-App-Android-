package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment4 extends Fragment {
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
        View view= inflater.inflate(R.layout.fragment_4, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView5);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription("Two large bananas and a glass of milk later two glasses of water.\n\nCalories: 210kcal\nFat: 0.2g\nCarbs: 62g\nProtein: 0.3g");
        m.setImg(R.drawable.banana);
        m.setotalkcal(210.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("A banana shake (one banana) with half a teaspoon of honey.\n\nCalories: 200kcal\nFat: 0.2g\nCarbs: 51g\nProtein: 0.3g");
        m.setImg(R.drawable.bananashake);
        m.setotalkcal(200.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("Cabbage diet soup with bell peppers and two glasses of water.\n\nCalories: 166kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.gm);
        m.setotalkcal(166.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("A glass of banana milkshake and two glasses of water.\n\nCalories: 200kcal\nFat: 0.2g\nCarbs: 51g\nProtein: 0.3g");
        m.setImg(R.drawable.bananashake);
        m.setotalkcal(200.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("Cabbage diet soup with bell peppers and two glasses of water.\n\nCalories: 166kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.gm);
        m.setotalkcal(166.0);
        models.add(m);

        return models;
    }
}