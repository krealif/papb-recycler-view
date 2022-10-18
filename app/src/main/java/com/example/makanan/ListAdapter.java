package com.example.makanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final ArrayList<Food> foodList;
    private final LayoutInflater inflater;

    public ListAdapter(Context context, ArrayList<Food> foodList) {
        this.foodList = foodList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        final Food food = foodList.get(position);
        holder.txtName.setText(food.getName());
        holder.txtDesc.setText(food.getDescription());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName, txtDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtDesc = itemView.findViewById(R.id.txt_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Food food = foodList.get(position);
            Intent intent = new Intent(view.getContext(), FoodDetailActivity.class);
            intent.putExtra("name", food.getName());
            intent.putExtra("desc", food.getDescription());
            view.getContext().startActivity(intent);
        }
    }
}
