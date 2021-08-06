package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class gainFragment4 extends Fragment {
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
        m.setDescription(" 3-egg omelet with sliced onions, red and green bell peppers, and 1/4 cup (28 grams) of shredded cheese.\n\nCalories: 760kcal\nFat: 70g\nCarbs: 22g\nProtein: 80g");
        m.setImg(R.drawable.omelet);
        m.setotalkcal(760.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("2 tablespoons (33 grams) of peanut butter and 1 banana on 1 slice of whole-wheat bread.\n\nCalories: 300kcal\nFat: 70g\nCarbs: 14.4g\nProtein: 70.5g");
        m.setImg(R.drawable.pbtoast);
        m.setotalkcal(300.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription("8 ounces (226 grams) of tilapia fillets, 1/4 cup (32 grams) of lentils, and a salad topped with 1/4 cup (30 grams) of walnuts.\n\nCalories: 890kcal\nFat: 300g\nCarbs: 112g\nProtein: 113g");
        m.setImg(R.drawable.tilapia);
        m.setotalkcal(890.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("2 sliced, hard-boiled eggs atop a mixed green salad.\n\nCalories: 650kcal\nFat: 8.9g\nCarbs: 5.6g\nProtein: 200g");
        m.setImg(R.drawable.egglettuce);
        m.setotalkcal(650.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("turkey breast, chopped onions, garlic, celery, and sweet peppers, 1/2 cup (123 grams) of canned, diced tomatoes, and 1/2 cup (120 grams) of cannellini beans.\n\nCalories: 840al\nFat: 241g\nCarbs: 162g\nProtein: 200g");
        m.setImg(R.drawable.turkeychili);
        m.setotalkcal(840.0);
        models.add(m);

        return models;
    }
}