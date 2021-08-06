package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class gainFragment3 extends Fragment {
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
        m.setDescription("3 whole-wheat waffles with 2 tablespoons (33 grams) of peanut butter, 1 orange, and 2 cups (480 ml) of dairy or plant-based milk.\n\nCalories: 873kcal\nFat: 99g\nCarbs: 46g\nProtein: 15g");
        m.setImg(R.drawable.peanutwaffle);
        m.setotalkcal(873.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("1 nut-based granola bar and 1 ounce (28 grams) of almonds.\n\nCalories: 300kcal\nFat: 70g\nCarbs: 14.4g\nProtein: 70.5g");
        m.setImg(R.drawable.granola);
        m.setotalkcal(300.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("Chicken burger on a whole-wheat bun with 1 tomato slice and lettuce leaf.\n\nCalories: 890kcal\nFat: 300g\nCarbs: 112g\nProtein: 113g");
        m.setImg(R.drawable.chickenburger);
        m.setotalkcal(890.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("1 cup (227 grams) of Greek yogurt and 1 cup (140 grams) of strawberries.\n\nCalories: 650kcal\nFat: 8.9g\nCarbs: 5.6g\nProtein: 200g");
        m.setImg(R.drawable.greekyoghurt);
        m.setotalkcal(650.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("4-ounce (112-gram) chicken breast, 1/2 cup (84 grams) of quinoa, and 1 1/3 cups (85 grams) of sugar snap peas.\n\nCalories: 840al\nFat: 241g\nCarbs: 162g\nProtein: 200g");
        m.setImg(R.drawable.grilledchicken);
        m.setotalkcal(840.0);
        models.add(m);

        return models;
    }
}