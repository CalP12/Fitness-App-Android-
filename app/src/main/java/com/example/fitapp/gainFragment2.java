package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class gainFragment2 extends Fragment {
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
        m.setDescription("Smoothie made with 2 cups (480 ml) of dairy or plant-based milk, 1 cup (227 grams) of yogurt, 1 cup (140 grams) of blueberries, and 2 tablespoons (33 grams) of almond butter.\n\nCalories: 760kcal\nFat: 70g\nCarbs: 22g\nProtein: 80g");
        m.setImg(R.drawable.blueberry);
        m.setotalkcal(760.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("1 granola bar, 1 piece of fruit, and 2 pieces of string cheese.\n\nCalories: 300kcal\nFat: 70g\nCarbs: 14.4g\nProtein: 70.5g");
        m.setImg(R.drawable.granola);
        m.setotalkcal(300.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("12-inch sub sandwich with meat, cheese, and veggies with 3 ounces (85 grams) of baby carrots, 2 tablespoons (28 grams) of hummus, and apple slices on the side.\n\nCalories: 890kcal\nFat: 300g\nCarbs: 112g\nProtein: 113g");
        m.setImg(R.drawable.sandwich);
        m.setotalkcal(890.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("1 scoop of whey protein powder mixed in 1 cup (240 ml) of dairy or plant-based milk.\n\nCalories: 650kcal\nFat: 8.9g\nCarbs: 5.6g\nProtein: 200g");
        m.setImg(R.drawable.whey);
        m.setotalkcal(650.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("4-ounce (113-gram) grilled chicken with rice, 1 medium-sized (173-gram) baked potato with 1 tablespoon (14 grams) of butter, and 1 cup (85 grams) of broccoli.\n\nCalories: 840al\nFat: 241g\nCarbs: 162g\nProtein: 200g");
        m.setImg(R.drawable.chickenrice);
        m.setotalkcal(840.0);
        models.add(m);

        return models;
    }
}