package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShopCustomer extends AppCompatActivity {

    // Using the TextView IDs from your shop_customer.xml layout
    private TextView tvHome;
    private TextView tvShop;
    private TextView tvChat;
    private TextView tvDonate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_customer);

        initializeViews();
        setupNavigationListeners();
    }

    private void initializeViews() {
        tvHome = findViewById(R.id.tvHome);
        tvShop = findViewById(R.id.tvShop);
        tvChat = findViewById(R.id.tvChat);
        tvDonate = findViewById(R.id.tvDonate);
    }

    private void setupNavigationListeners() {
        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvHomeCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ShopCustomer.this, ItemCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvShopCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ShopCustomer.this, ShopCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvOrderCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ShopCustomer.this, OrderCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChatCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ShopCustomer.this, ChatCustomer.class);
            startActivity(intent);
        });
    }

    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(ShopCustomer.this, targetActivity);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Optional: Highlight the current tab
        if (tvShop != null) {
            tvShop.setTextColor(getResources().getColor(android.R.color.black));
        }
    }
}
