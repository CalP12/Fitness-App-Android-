package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class gainFragment7 extends Fragment {
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
        m.setDescription("3 whole eggs, 1 apple, and 1 cup (80 grams) of oatmeal made with 1 cup (240 ml) of dairy or plant-based milk.\n\nCalories: 760kcal\nFat: 0.2g\nCarbs: 13.8g\nProtein: 0.3g");
        m.setImg(R.drawable.oatmealbowl);
        m.setotalkcal(760.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("1 cup (226 grams) of plain yogurt with 1/4 cup (30 grams) of granola and 1/2 cup (70 grams) of raspberries.\n\nCalories: 300kcal\nFat: 0.3g\nCarbs: 14.4g\nProtein: 1.5g");
        m.setImg(R.drawable.greekyoghurt);
        m.setotalkcal(300.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("6-ounce (168-gram) chicken breast, 1 medium-sized (151-gram) sweet potato, 3/4 cup (85 grams) of green beans, and 1 ounce (28 grams) of nuts.\n\nCalories: 890kcal\nFat: 0.2g\nCarbs: 11.6g\nProtein: 0.9g");
        m.setImg(R.drawable.grilledchicken);
        m.setotalkcal(890.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("1/2 cup (130 grams) of chickpeas atop greens.\n\nCalories: 400kcal\nFat: 0.16g\nCarbs: 15.4g\nProtein: 1.2g");
        m.setImg(R.drawable.chickpeastwo);
        m.setotalkcal(400.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("6 ounces (170 grams) of chopped chicken, 1/2 cup (130 grams) of black beans, 1/2 cup (90 grams) of brown rice.\n\nCalories: 730kcal\nFat: 1.9g\nCarbs: 38g\nProtein: 5.7g");
        m.setImg(R.drawable.burritobowl);
        m.setotalkcal(730.0);
        models.add(m);

        return models;
    }
}