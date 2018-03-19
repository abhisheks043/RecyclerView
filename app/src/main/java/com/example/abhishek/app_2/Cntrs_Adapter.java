package com.example.abhishek.app_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek on 3/18/2018.
 */

public class Cntrs_Adapter extends RecyclerView.Adapter<Cntrs_Adapter.ViewHolder>{

    private ArrayList<Countries> lItems;
    Context context;

    public Cntrs_Adapter(ArrayList<Countries> lItems, Context context) {
        this.lItems = lItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Countries c = lItems.get(i);
        viewHolder.tRank.setText(String.valueOf(c.getRank()));
        viewHolder.tName.setText(c.getCountry());
        viewHolder.tPopulation.setText(c.getPopulation());

        Picasso.with(context)
                .load(c.getFlag())
                .into(viewHolder.iFlag);

        viewHolder.iFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FScreen.class);
                i.putExtra("url_string",c.getFlag());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return lItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tRank;
        public TextView tName;
        public TextView tPopulation;
        public ImageView iFlag;


        public ViewHolder(View itemView) {
            super(itemView);

            tRank = (TextView) itemView.findViewById(R.id.tRank);
            tName = (TextView) itemView.findViewById(R.id.tName);
            tPopulation = (TextView) itemView.findViewById(R.id.tPopulation);
            iFlag = (ImageView) itemView.findViewById(R.id.iFlag);





        }
    }



}
