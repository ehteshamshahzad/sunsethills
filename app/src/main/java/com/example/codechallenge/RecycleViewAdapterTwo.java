package com.example.codechallenge;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapterTwo extends RecyclerView.Adapter<RecycleViewAdapterTwo.ViewHolder> {
    private Context context;
    private ArrayList<Integer> arr;
    private ArrayList<Integer> arr3;
    private int integer;
    private int integer2;

    public RecycleViewAdapterTwo(Context context, int integer, int integer2) {
        this.context = context;
        this.integer = integer;
        this.integer2 = integer2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem_two, parent, false);
        RecycleViewAdapterTwo.ViewHolder holder = new RecycleViewAdapterTwo.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.button.setText(String.valueOf(integer));
        if(integer2 == 1){
            holder.button.setText("SUNNY :D");
            holder.button.setBackgroundColor(Color.YELLOW);
        } else {
            holder.button.setText("Dark :(");
            holder.button.setBackgroundColor(Color.GRAY);
        }
    }


    @Override
    public int getItemCount() {
        return integer;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button button;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.hi_two);
            parentLayout = itemView.findViewById(R.id.parent_layout_two);
        }
    }
}
