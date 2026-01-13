package com.example.appnova;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodVH> {

    public interface OnFoodClickListener {
        void onFoodClick(FoodItem item);
    }

    private final Context context;
    private final List<FoodItem> items;
    private final OnFoodClickListener listener;

    public FoodAdapter(Context context, List<FoodItem> items, OnFoodClickListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new FoodVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodVH holder, int position) {
        FoodItem item = items.get(position);

        holder.imgFood.setImageResource(item.getImageResId());
        holder.txtFoodName.setText(item.getName());
        holder.txtPrice.setText(item.getPrice());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onFoodClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class FoodVH extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView txtFoodName, txtPrice;

        public FoodVH(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFood);
            txtFoodName = itemView.findViewById(R.id.txtFoodName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}

