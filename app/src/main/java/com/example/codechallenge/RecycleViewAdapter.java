package com.example.codechallenge;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Integer> arr;
    private ArrayList<Integer> arr2;
    private ArrayList<Integer> arr3;
    private int count;

    public RecycleViewAdapter(Context context, ArrayList<Integer> arr, ArrayList<Integer> arr2, ArrayList<Integer> arr3, int count) {
        this.context = context;
        this.arr = arr;
        this.arr2 = arr2;
        this.arr3 = arr3;
        this.count = count;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("positionValue", arr.get(position).toString());
        RecycleViewAdapterTwo recycleViewAdapterTwo = new RecycleViewAdapterTwo(context, arr.get(position), arr3.get(position));

        LinearLayoutManager llm = new LinearLayoutManager(context);

        holder.recyclerView.setLayoutManager(llm);
        holder.recyclerView.setAdapter(recycleViewAdapterTwo);
        holder.recyclerView.scrollToPosition(arr.size()-1);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view_two);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
