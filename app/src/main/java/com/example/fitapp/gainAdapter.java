package com.example.fitapp;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class gainAdapter extends RecyclerView.Adapter<gainHolder>{

    Context c;
    ArrayList<Model3> models;
    Dialog myDialog,completeDialog;
    Button close,completeclose;
    TextView mworktitle,mdescription;
    ImageView mImage;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    int workprogress = 0;
    public gainAdapter(Context c, ArrayList<Model3> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public gainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users1");
        userID = user.getUid();

        myDialog = new Dialog(c);
        completeDialog = new Dialog(c);
        return new gainHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull gainHolder gainHolder, int position) {
        gainHolder.mTitle.setText(models.get(position).getTitle());
        gainHolder.mDescription.setText(models.get(position).getDescription());
        gainHolder.mImage.setImageResource(models.get(position).getImg());
        gainHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View v, int layoutPosition) {
                CheckBox mCheckbox = (CheckBox) v;
                if(mCheckbox.isChecked())
                    workprogress += 1;
                else
                    workprogress -= 1;

                reference.child(userID).child("workouts").setValue(workprogress);

                if( workprogress == 10 )
                {
                    completeDialog.setContentView(R.layout.complete_modal);
                    completeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    completeclose = completeDialog.findViewById(R.id.completeclose);
                    completeclose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            completeDialog.dismiss();
                        }
                    });
                    completeDialog.show();
                }
            }
        });

        gainHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.modal2);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                mworktitle = myDialog.findViewById(R.id.worktitle);
                mdescription = myDialog.findViewById(R.id.workdescription);
                mImage = myDialog.findViewById(R.id.workimage);

                close = myDialog.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                if(position==0) {
                    myDialog.show();
                }
                else if(position==1)
                {
                    mImage.setImageResource(R.drawable.triceps);
                    mworktitle.setText("Triceps extension");
                    mdescription.setText("Stand tall, holding dumbbells over your head with both hands, arms straight. Keeping your chest up, lower the weights behind your head, then raise them back to the start.");
                    myDialog.show();
                }
                else if(position==2)
                {
                    mImage.setImageResource(R.drawable.benchpress);
                    mworktitle.setText("Bench Press");
                    mdescription.setText("Lie on a flat bench, holding a barbell with your hands slightly wider than shoulder-width apart. Brace your core, then lower the bar towards your chest. Press it back up to the start.");
                    myDialog.show();
                }
                else if(position==3)
                {
                    mImage.setImageResource(R.drawable.overhead);
                    mworktitle.setText("Overhead press");
                    mdescription.setText("Hold a bar in front of your neck with your hands just wider than shoulder-width apart. Keeping your chest up and core braced, press the bar overhead until your arms are straight. Lower it back to the start.");
                    myDialog.show();
                }
                else if(position==4)
                {
                    mImage.setImageResource(R.drawable.chin);
                    mworktitle.setText("Chin-Up");
                    mdescription.setText("Hold a pull-up bar with hands shoulder-width apart, palms facing you. Brace your core, then pull yourself up until your chin is over the bar. Lower until your arms are straight again.");
                    myDialog.show();
                }
                else if(position==5)
                {
                    mImage.setImageResource(R.drawable.tricepbar);
                    mworktitle.setText("Tricep dip");
                    mdescription.setText("Grip rings or parallel bars with your arms straight. Keeping your chest up, bend your elbows to lower your body as far as your shoulders allow. Press back up powerfully to return to the start.");
                    myDialog.show();
                }
                else if(position==6)
                {
                    mImage.setImageResource(R.drawable.glute);
                    mworktitle.setText("Glute bridge");
                    mdescription.setText("Sit with your upper back supported on a bench, holding a barbell across the tops of your thighs. Thrust your hips up, squeeze your glutes at the top, and then return to the start.");
                    myDialog.show();
                }
                else if(position==7)
                {
                    mImage.setImageResource(R.drawable.flye);
                    mworktitle.setText("Reverse flye");
                    mdescription.setText("Bend forwards from the hips, holding a light dumbbell in each hand with palms facing. Keeping a slight bend in your elbows, raise the weights out to shoulder height, then lower them back to the start.");
                    myDialog.show();
                }
                else if(position==8)
                {
                    mImage.setImageResource(R.drawable.seated);
                    mworktitle.setText("Seated incline curl");
                    mdescription.setText("Sit on an upright bench, holding a dumbbell in each hand at shoulder height. Keeping your chest up, press the weights directly overhead until your arms are straight, then lower them back to the start.");
                    myDialog.show();
                }
                else
                {
                    mImage.setImageResource(R.drawable.inclined);
                    mworktitle.setText("Incline dumbbell press");
                    mdescription.setText("Lie on an incline bench, holding a dumbbell in each hand by your shoulders. Press the weights up until your arms are straight, then lower them back to the start under control.");
                    myDialog.show();
                }

            }
        });

    }
    @Override
    public int getItemCount() {
        return models.size();
    }
}
