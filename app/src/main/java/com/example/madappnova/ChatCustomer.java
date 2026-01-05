package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class ChatCustomer extends AppCompatActivity {

    private TextView tvHomeCustomer;
    private TextView tvShopCustomer;
    private TextView tvOrderCustomer;
    private TextView tvChatCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_customer);

        // Initialize bottom navigation views
        initializeViews();

        // Set up navigation listeners
        setupClickListeners();

        // Set up chat item click listeners
        setupChatItemListeners();
    }

    private void initializeViews() {
        tvHomeCustomer = findViewById(R.id.tvHomeCustomer);
        tvShopCustomer = findViewById(R.id.tvShopCustomer);
        tvOrderCustomer = findViewById(R.id.tvOrderCustomer);
        tvChatCustomer = findViewById(R.id.tvChatCustomer);
    }

    private void openChatDetail(String shopName) {
        // Corrected Navigation: Point to the new ChatSingleCustomerActivity
        Intent intent = new Intent(ChatCustomer.this, ChatSingleCustomerActivity.class);
        intent.putExtra("SHOP_NAME", shopName);
        startActivity(intent);
    }

    private void setupChatItemListeners() {
        findViewById(R.id.chat_item_1).setOnClickListener(v -> openChatDetail("Dona Bakehouse"));
        findViewById(R.id.chat_item_2).setOnClickListener(v -> openChatDetail("Ayam Gepuk ABC"));
        findViewById(R.id.chat_item_3).setOnClickListener(v -> openChatDetail("Joyah Grocer"));
        findViewById(R.id.chat_item_4).setOnClickListener(v -> openChatDetail("SYJ Pastry"));
    }


    private void setupClickListeners() {
        // Bottom nav (TextViews as buttons)
        tvHomeCustomer.setOnClickListener(v -> {
            navigateToActivity(ItemCustomer.class);
        });

        tvShopCustomer.setOnClickListener(v -> {
            navigateToActivity(ShopCustomer.class);
        });

        tvOrderCustomer.setOnClickListener(v -> {
            navigateToActivity(OrderCustomer.class);
        });

        tvChatCustomer.setOnClickListener(v -> {
            // Current screen, do nothing.
        });
    }

    private void navigateToActivity(Class<?> activityClass) {
        Intent intent = new Intent(ChatCustomer.this, activityClass);
        startActivity(intent);
    }
}
