package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PastOrderSeller extends AppCompatActivity {
    private RecyclerView recyclerViewOrders;
    private PastOrderAdapter adapter;
    private OrderRepository orderRepository;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);

        session = new SessionManager(this);
        if (!session.isLoggedIn()) {
            startActivity(new Intent(this, LoginPageSellerActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.past_order_seller);

        // Initialize repository
        orderRepository = new OrderRepository(this.getApplication());

        View topBar = findViewById(R.id.topBar);
        ViewCompat.setOnApplyWindowInsetsListener(topBar, (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        recyclerViewOrders = findViewById(R.id.recyclerViewOrder);
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PastOrderAdapter();
        recyclerViewOrders.setAdapter(adapter);

        int sellerId = session.getUserId();
        if (sellerId != -1) {
            orderRepository.getPastOrdersBySellerLive(sellerId).observe(this, orders -> {
                if (orders != null) {
                    adapter.updateOrders(orders);
                }
            });

        }

        // Top buttons
        findViewById(R.id.order_button).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.add_item_button).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        // Top buttons
        findViewById(R.id.current_order).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.past_order).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, PastOrderSeller.class);
            startActivity(intent);
        });


        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, ShopSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, HomeSellerActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, ChatSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvOrder).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        ImageView account = findViewById(R.id.imgPlaceholder);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PastOrderSeller.this, AccountActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onChatClick(Order order) {
        Intent intent = new Intent(this, ChatConversation.class);
        intent.putExtra("customer_name", order.getCustomerName());
        intent.putExtra("customer_id", order.getCustomerId());
        startActivity(intent);
    }

}
