package com.example.fitapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DietHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView mImage;
    TextView mTitle, mDescription;
    CheckBox mCheckbox;

    ItemClickListener itemClickListener;
    public DietHolder(@NonNull View itemView){
        super(itemView);
        this.mImage = itemView.findViewById(R.id.logo);
        this.mTitle = itemView.findViewById(R.id.title);
        this.mDescription = itemView.findViewById(R.id.description);

        mCheckbox = itemView.findViewById(R.id.dietbox);
        mCheckbox.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.OnItemClick(v,getLayoutPosition());
    }
}
