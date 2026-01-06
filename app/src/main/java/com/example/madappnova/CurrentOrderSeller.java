package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CurrentOrderSeller extends AppCompatActivity implements OrderAdapter.OnOrderClickListener {
    private RecyclerView recyclerViewOrders;
    private OrderAdapter adapter;
    private OrderRepository orderRepository;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);

        // Check if user is logged in
        session = new SessionManager(this);
        if (!session.isLoggedIn()) {
            startActivity(new Intent(this, LoginPageSellerActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.current_order_seller);

        // Initialize repository
        orderRepository = new OrderRepository(this.getApplication());

        // Setup window insets for edge-to-edge display
        View topBar = findViewById(R.id.topBar);
        ViewCompat.setOnApplyWindowInsetsListener(topBar, (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        // Setup RecyclerView
        recyclerViewOrders = findViewById(R.id.recyclerViewOrder);
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderAdapter(new ArrayList<>(),this);
        recyclerViewOrders.setAdapter(adapter);

        int sellerId = session.getUserId();

        if (sellerId != -1) {
            orderRepository.getCurrentOrdersBySellerLive(sellerId).observe(this, orders -> {
                if (orders != null) {
                    adapter.updateOrders(orders);
                }
            });
        }

        // Top bar buttons
        findViewById(R.id.order_button).setOnClickListener(v -> {
            // Already on this page, no need to navigate
        });

        findViewById(R.id.add_item_button).setOnClickListener(v -> {
            startActivity(new Intent(CurrentOrderSeller.this, UploadRegularSeller.class));
        });

        findViewById(R.id.current_order).setOnClickListener(v -> {
            // Already on this page
        });

        findViewById(R.id.past_order).setOnClickListener(v -> {
            startActivity(new Intent(CurrentOrderSeller.this, PastOrderSeller.class));
        });

        // Bottom navigation
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            startActivity(new Intent(CurrentOrderSeller.this, ShopSeller.class));
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            startActivity(new Intent(CurrentOrderSeller.this, UploadRegularSeller.class));
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            startActivity(new Intent(CurrentOrderSeller.this, HomeSellerActivity.class));
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            startActivity(new Intent(CurrentOrderSeller.this, ChatSeller.class));
        });

        findViewById(R.id.tvOrder).setOnClickListener(v -> {
            // Already on this page
        });

        // Account button
        ImageView account = findViewById(R.id.imgPlaceholder);
        account.setOnClickListener(v -> {
            startActivity(new Intent(CurrentOrderSeller.this, AccountActivity.class));
        });
    }

    /**
     * Handle Done button click - Mark order as completed
     */
    @Override
    public void onDoneClick(Order order, int position) {
        // Update order status in background
        // LiveData will automatically refresh the list
        new Thread(() -> {
            orderRepository.updateOrderStatus(order.getId(), "Done");

            // Show success message on main thread
            runOnUiThread(() -> {
                Toast.makeText(this, "Order completed!", Toast.LENGTH_SHORT).show();
            });
        }).start();
    }

    /**
     * Handle Chat button click - Open chat with customer
     */
    @Override
    public void onChatClick(Order order) {
        Intent intent = new Intent(this, ChatSeller.class);
        intent.putExtra("customer_name", order.getCustomerName());
        intent.putExtra("customer_id", order.getCustomerId());
        startActivity(intent);
    }
}