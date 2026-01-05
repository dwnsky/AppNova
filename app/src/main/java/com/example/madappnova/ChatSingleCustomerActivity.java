package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatSingleCustomerActivity extends AppCompatActivity {

    private TextView tvHomeCustomer;
    private TextView tvShopCustomer;
    private TextView tvOrderCustomer;
    private TextView tvChatCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatsingle_customer);

        // You can add code here to handle the chat screen logic,
        // like getting the shop name from the intent and loading messages.
        String shopName = getIntent().getStringExtra("SHOP_NAME");
        // Initialize views
        initializeViews();

        // Set up click listeners
        setupClickListeners();
    }

    private void initializeViews() {
        // Bottom Navigation
        tvHomeCustomer = findViewById(R.id.tvHomeCustomer);
        tvShopCustomer = findViewById(R.id.tvShopCustomer);
        tvOrderCustomer = findViewById(R.id.tvOrderCustomer);
        tvChatCustomer = findViewById(R.id.tvChatCustomer);
    }

    private void setupClickListeners() {
        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvHomeCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSingleCustomerActivity.this, ItemCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvShopCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSingleCustomerActivity.this, ShopCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvOrderCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSingleCustomerActivity.this, OrderCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChatCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSingleCustomerActivity.this, ChatCustomer.class);
            startActivity(intent);
        });
}}
