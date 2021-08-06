package com.example.fitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class gainFragment1 extends Fragment {
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
        View view= inflater.inflate(R.layout.fragment_1, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView2);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myAdapter = new DietAdapter(view.getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);
        return view;


    }
    private ArrayList<Model2> getMyList(){
        ArrayList<Model2> models = new ArrayList<>();
        Model2 m = new Model2();
        m.setTitle("Breakfast - 8 AM");
        m.setDescription(" 1 cup (80 grams) of oats with 1 cup (240 ml) of dairy or plant-based milk, 1 sliced banana, and 2 tablespoons (33 grams) of peanut butter.\n\nCalories: 760kcal\nFat: 70g\nCarbs: 22g\nProtein: 80g");
        m.setImg(R.drawable.oats);
        m.setotalkcal(760.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 10 AM");
        m.setDescription("Trail mix made with 1 cup (80 grams) of dry cereal, 1/4 cup (30 grams) of granola, 1/4 cup (34 grams) of dried fruit, and 20 nuts.\n\nCalories: 300kcal\nFat: 70g\nCarbs: 14.4g\nProtein: 70.5g");
        m.setImg(R.drawable.trail);
        m.setotalkcal(300.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Lunch - 1 PM");
        m.setDescription(" 1 cup (100 grams) of spaghetti with 3/4 cups (183 grams) of tomato sauce and 4 ounces (112 grams) of cooked chicken, as well as 1 medium breadstick with 1 tablespoon (14 grams) of butter.\n\nCalories: 890kcal\nFat: 300g\nCarbs: 112g\nProtein: 113g");
        m.setImg(R.drawable.spaghetti);
        m.setotalkcal(890.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Snacks - 4 PM");
        m.setDescription("1 cup (226 grams) of cottage cheese and 1/2 cup (70 grams) of blueberries.\n\nCalories: 400kcal\nFat: 64g\nCarbs: 70gg\nProtein: 19.2g");
        m.setImg(R.drawable.cottage);
        m.setotalkcal(400.0);
        models.add(m);

        m = new Model2();
        m.setTitle("Dinner - 8 PM");
        m.setDescription("4 ounces (110 grams) of salmon, 1 cup (100 grams) of brown rice, and 5 asparagus spears.\n\nCalories: 730al\nFat: 241g\nCarbs: 162g\nProtein: 200g");
        m.setImg(R.drawable.salmon);
        m.setotalkcal(730.0);
        models.add(m);

        return models;
    }
}