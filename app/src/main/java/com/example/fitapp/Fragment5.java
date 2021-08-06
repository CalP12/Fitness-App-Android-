package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment5 extends Fragment {
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
        View view= inflater.inflate(R.layout.fragment_5, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView6);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription("A few small tomatoes with a bowl of boiled kidney beans and two glasses of water.\n\nCalories: 130kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.day5tomatoes);
        m.setotalkcal(130.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("A cup of yogurt and two glasses of water.\n\nCalories: 45kcal\nFat: 20g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.yogurt);
        m.setotalkcal(45.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("A bowl of cooked brown rice with two tomatoes and two glasses of water.\n\nCalories: 260kcal\nFat: 0.2g\nCarbs: 66.8g\nProtein: 0.3g");
        m.setImg(R.drawable.day5brownrice);
        m.setotalkcal(260.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("A salad with onions, sprouts, tomatoes and two glasses of water.\n\nCalories: 78kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.onion);
        m.setotalkcal(78.0);
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