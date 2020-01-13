package com.meet.paperface.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.meet.paperface.Model.Past_Order_Model;
import com.meet.paperface.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Past_Order_Adapter extends RecyclerView.Adapter<Past_Order_Adapter.ViewHolder> {


    private Context fcontext;
    private List<Past_Order_Model> fupload = new ArrayList<>();
    SharedPreferences sp;
    public static final String mypreference = "mypreference";
    public static final String Name = "nameKey";

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    public void add(Past_Order_Model s) {
        fupload.add(s);
    }

    public Past_Order_Adapter(Context context, List<Past_Order_Model> user) {

        fcontext = context;
        fupload = user;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(fcontext).inflate( R.layout.data_list_shop_pastorder, parent, false);


        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.page.setText(fupload.get(position).getPages());
        holder.rs.setText(fupload.get(position).getRs());
        holder.date.setText(fupload.get(position).getDate());



    }

    @Override
    public int getItemCount() {

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        String myuid=firebaseUser.getUid();
        HashMap<String,Integer > map=new HashMap<>();
        map.put(myuid,fupload.size());

        databaseReference.child(myuid).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {



            }
        });

        return fupload.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView page, rs, date;

        ViewHolder(@NonNull View itemView) {
            super(itemView);


            page = itemView.findViewById(R.id.card_Pages_shop_blank);
            rs = itemView.findViewById(R.id.card_Rupees_shop_blank);
            date = itemView.findViewById(R.id.card_date_blank);

        }
    }

}

