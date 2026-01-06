package com.example.madappnova;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.madappnova.R;
import com.example.madappnova.Order;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<Order> orders;
    private OnOrderClickListener listener;

    public interface OnOrderClickListener {
        void onDoneClick(Order order, int position);
        void onChatClick(Order order);
    }

    public OrderAdapter(List<Order> orders, OnOrderClickListener listener) {
        this.orders = orders;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_card, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
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

    public void removeItem(int position) {
        orders.remove(position);
        notifyItemRemoved(position);
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvCustomerName, tvOrderStatus, tvItemName, tvQuantity, tvTotal;
        Button btnChatCustomer, btnDone;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCustomerName = itemView.findViewById(R.id.tvCustomerName);
            tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            btnChatCustomer = itemView.findViewById(R.id.btnChat);
            btnDone = itemView.findViewById(R.id.btnDone);
        }

        public void bind(Order order, OnOrderClickListener listener) {
            tvCustomerName.setText(order.getCustomerName());
            tvOrderStatus.setText(order.getStatus());
            tvItemName.setText(order.getItemName());
            tvQuantity.setText("x" + order.getQuantity());
            tvTotal.setText("Total Payment : RM " + String.format("%.2f", order.getTotalPayment()));

            btnDone.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onDoneClick(order, getAdapterPosition());
                }
            });

            btnChatCustomer.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onChatClick(order);
                }
            });
        }
    }
}
