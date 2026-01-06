package com.example.madappnova;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.madappnova.R;
import com.example.madappnova.Order;

import java.util.ArrayList;
import java.util.List;

public class PastOrderAdapter extends RecyclerView.Adapter<PastOrderAdapter.PastOrderViewHolder> {

    private List<Order> orders;
    private OnPastOrderClickListener listener;

    public interface OnPastOrderClickListener {
        void onChatClick(Order order);
    }

    public PastOrderAdapter() {
        this.orders = new ArrayList<>();
    }

    @NonNull
    @Override
    public PastOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_card_past, parent, false);
        return new PastOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastOrderViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.bind(order, listener);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void updateOrders(List<Order> newOrders) {
        this.orders = newOrders;
        notifyDataSetChanged();
    }

    static class PastOrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvCustomerName, tvOrderStatus, tvItemName, tvQuantity, tvTotal;
        Button btnChatCustomer;
        RatingBar ratingBar;

        public PastOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCustomerName = itemView.findViewById(R.id.tvCustomerName);
            tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            btnChatCustomer = itemView.findViewById(R.id.btnChat);

            ratingBar = itemView.findViewById(R.id.ratingBar1);
        }

        public void bind(Order order, OnPastOrderClickListener listener) {
            tvCustomerName.setText(order.getCustomerName());
            tvOrderStatus.setText(order.getStatus());
            tvItemName.setText(order.getItemName());
            tvQuantity.setText("x" + order.getQuantity());
            tvTotal.setText("Total Payment : RM " + String.format("%.2f", order.getTotalPayment()));

            if (ratingBar != null) {
                ratingBar.setRating(order.getRating());
            }

            btnChatCustomer.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onChatClick(order);
                }
            });
        }


    }
}