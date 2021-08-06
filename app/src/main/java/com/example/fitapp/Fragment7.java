package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment7 extends Fragment {
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
        View view= inflater.inflate(R.layout.fragment_7, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView8);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription("A cup of brown rice with melon or some mixed vegetables and two glasses of water.\n\nCalories: 190kcal\nFat: 2.7g\nCarbs: 60.2gg\nProtein: 5.6g");
        m.setImg(R.drawable.brownrice5);
        m.setotalkcal(190.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("Mixed fruit juice without sugar and two glasses of water.\n\nCalories: 110kcal\nFat: 0g\nCarbs: 27g\nProtein: 2g");
        m.setImg(R.drawable.fruit);
        m.setotalkcal(110.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("A salad with any of your favourite vegetables along with a raw mango and two glasses of water.\n\nCalories: 250kcal\nFat: 30g\nCarbs: 42g\nProtein: 9.7g");
        m.setImg(R.drawable.bigsalad);
        m.setotalkcal(250.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("Mixed fruit juice without sugar and two glasses of water.\n\nCalories: 110kcal\nFat: 0g\nCarbs: 27g\nProtein: 2g");
        m.setImg(R.drawable.fruit);
        m.setotalkcal(110.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("A bowl of brown rice with beans, tomatoes, bell peppers and carrots including two glasses of water.\n\nCalories: 230kcal\nFat: 40.2gg\nCarbs: 51.7g\nProtein: 12g");
        m.setImg(R.drawable.brownrice5);
        m.setotalkcal(230.0);
        models.add(m);

        return models;
    }
}