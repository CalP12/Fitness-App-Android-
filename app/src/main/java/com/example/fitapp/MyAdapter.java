package com.example.fitapp;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder>{

    Context c;
    ArrayList<Model> models;
    Dialog myDialog,completeDialog;
    Button close,completeclose;
    TextView mworktitle,mdescription;
    ImageView mImage;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    int workprogress = 0;
    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users1");
        userID = user.getUid();

        myDialog = new Dialog(c);
        completeDialog = new Dialog(c);
        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder MyHolder, int position) {
        MyHolder.mTitle.setText(models.get(position).getTitle());
        MyHolder.mDescription.setText(models.get(position).getDescription());
        MyHolder.mImage.setImageResource(models.get(position).getImg());
        MyHolder.setItemClickListener(new ItemClickListener() {
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

        MyHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.modal);
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
                    mImage.setImageResource(R.drawable.dead);
                    mworktitle.setText("Romanian Deadlift");
                    mdescription.setText("Keeping your legs straight, lean forward – hingeing at the hips – and lower the weights down the fronts of your shins until you feel a good stretch in your hamstrings. Then return to the start.");
                    myDialog.show();
                }
                else if(position==2)
                {
                    mImage.setImageResource(R.drawable.diamond);
                    mworktitle.setText("Diamond push-ups");
                    mdescription.setText("Start in a press-up position but with your thumbs and forefingers together to form a diamond shape. Lower your chest to the floor, keeping your elbows close to your sides, then press back up.");
                    myDialog.show();
                }
                else if(position==3)
                {
                    mImage.setImageResource(R.drawable.wide);
                    mworktitle.setText("Wide-arm push-ups");
                    mdescription.setText("Start in the normal press-up position but with your hands out wide. Bend your elbows and lower your chest down towards the floor. Once you are as low as you can comfortably go, press powerfully back up to the start.");
                    myDialog.show();
                }
                else if(position==4)
                {
                    mImage.setImageResource(R.drawable.squat);
                    mworktitle.setText("Squat");
                    mdescription.setText("Stand with your chest up and core braced, holding a dumbbell in each hand. Bend your knees to squat down until your thighs are at least parallel to the floor, then press down through your heels to return to the start.");
                    myDialog.show();
                }
                else if(position==5)
                {
                    mImage.setImageResource(R.drawable.split);
                    mworktitle.setText("Split Squat");
                    mdescription.setText("Start in a split stance, with one foot in front of the other, holding a dumbbell in each hand. Bend both legs until your trailing knee touches the floor. Straighten both legs to return to the start, then go straight into the next rep.");
                    myDialog.show();
                }
                else if(position==6)
                {
                    mImage.setImageResource(R.drawable.lateral);
                    mworktitle.setText("Lateral Raise");
                    mdescription.setText("Stand tall with your chest up and core braced, holding a dumbbell in each hand. Raise the weights out to the sides, leading with your elbows, until they reach shoulder height. Lower them slowly to return to the start.");
                    myDialog.show();
                }
                else if(position==7)
                {
                    mImage.setImageResource(R.drawable.lunge);
                    mworktitle.setText("Lunge Press");
                    mdescription.setText("Holding dumbbells at shoulder height, lunge forwards so that your front knee is over your front ankle. As you lunge, press the weights directly overhead, making sure they go up and not forwards. Alternate sides.");
                    myDialog.show();
                }
                else if(position==8)
                {
                    mImage.setImageResource(R.drawable.divebomber);
                    mworktitle.setText("Dive-bomber");
                    mdescription.setText("Get into a press-up position. As you lower to the bottom of the move, lift one foot off the floor and raise the knee to your elbow. Press back up, placing your foot back on the floor. Repeat on the other side.");
                    myDialog.show();
                }
                else
                {
                    mImage.setImageResource(R.drawable.renegade);
                    mworktitle.setText("Renegade Row");
                    mdescription.setText("Start in a press-up position, holding a dumbbell in each hand. Keeping your core braced, row your right hand up, leading with your elbow, then lower it back to the floor. Alternate sides with each rep.");
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
