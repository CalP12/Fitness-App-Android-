package com.example.fitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DietAdapter extends RecyclerView.Adapter<DietHolder> {
    Context c;
    ArrayList<Model2> models;
    TextView mworktitle,mdescription;
    ImageView mImage;
    int dietprogress = 0;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    public DietAdapter(Context c, ArrayList<Model2> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public DietHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row2, null);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users1");
        userID = user.getUid();
        return new DietHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DietHolder DietHolder, int position) {
        DietHolder.mTitle.setText(models.get(position).getTitle());
        DietHolder.mDescription.setText(models.get(position).getDescription());
        DietHolder.mImage.setImageResource(models.get(position).getImg());
        DietHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View v, int layoutPosition) {
                CheckBox mCheckbox = (CheckBox) v;
                if(mCheckbox.isChecked())
                    dietprogress += models.get(position).getotalkcal();
                else
                    dietprogress -= models.get(position).getotalkcal();
                reference.child(userID).child("totalkcal").setValue(dietprogress);
            }
        });
    }
    @Override
    public int getItemCount() {
        return models.size();
    }
}
