package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment6 extends Fragment {
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
        View view= inflater.inflate(R.layout.fragment_6, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView7);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription("Cabbage diet soup with bell peppers and two glasses of water.\n\nCalories: 74kcal\nFat: 2g\nCarbs: 11\nProtein: 1.2g");
        m.setImg(R.drawable.gm);
        m.setotalkcal(74.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("A bowl of mixed boiled vegetables or kidney beans and two glasses of water.\n\nCalories: 160.5kcal\nFat: 0.9g\nCarbs: 24g\nProtein: 8g");
        m.setImg(R.drawable.boiledveg);
        m.setotalkcal(160.5);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("A bowl of brown rice and vegetables and two glasses of water.\n\nCalories: 190kcal\nFat: 2.7g\nCarbs: 60.2gg\nProtein: 5.6g");
        m.setImg(R.drawable.brownrice);
        m.setotalkcal(190.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("3-4 baby carrots and a glass of water.\n\nCalories: 35kcal\nFat: 0.1g\nCarbs: 8.2g\nProtein: 0.6g");
        m.setImg(R.drawable.babycarrot);
        m.setotalkcal(35.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("A bowl of boiled vegetables including carrots, cabbage, bell peppers.\n\nCalories: 124kcal\nFat: 0.7g\nCarbs: 32g\nProtein: 6g");
        m.setImg(R.drawable.bell);
        m.setotalkcal(124.0);
        models.add(m);

        return models;
    }
}