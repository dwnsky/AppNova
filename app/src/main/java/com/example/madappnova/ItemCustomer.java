package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ItemCustomer extends AppCompatActivity {

    // Top Bar Views
    private ImageView menuIcon;
    private TextView tvShopName;
    private ImageView imgPlaceholder;

    // Product Views
    private ImageView imgProduct;
    private TextView tvDetails;
    private Button btConfirm;

    // Bottom Navigation Views
    private TextView tvHomeCustomer;
    private TextView tvShopCustomer;
    private TextView tvOrderCustomer;
    private TextView tvChatCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_customer);

        // Initialize views
        initializeViews();

        // Set up click listeners
        setupClickListeners();
    }

    private void initializeViews() {
        // Top Bar
        menuIcon = findViewById(R.id.menuIcon);
        tvShopName = findViewById(R.id.tvShopName);
        imgPlaceholder = findViewById(R.id.imgPlaceholder);

        // Product Details
        imgProduct = findViewById(R.id.imgProduct53);
        tvDetails = findViewById(R.id.tvDetails53);
        btConfirm = findViewById(R.id.btConfirm);

        // Bottom Navigation
        tvHomeCustomer = findViewById(R.id.tvHomeCustomer);
        tvShopCustomer = findViewById(R.id.tvShopCustomer);
        tvOrderCustomer = findViewById(R.id.tvOrderCustomer);
        tvChatCustomer = findViewById(R.id.tvChatCustomer);
    }

    private void setupClickListeners() {
        // Menu Icon Click
        if (menuIcon != null) {
            menuIcon.setOnClickListener(v -> Toast.makeText(ItemCustomer.this, "Menu clicked", Toast.LENGTH_SHORT).show());
        }

        // Confirm Button Click
        if (btConfirm != null) {
            btConfirm.setOnClickListener(v -> Toast.makeText(ItemCustomer.this, "Order confirmed!", Toast.LENGTH_SHORT).show());
        }

        // Bottom nav (TextViews as buttons)
        if (tvHomeCustomer != null) {
            tvHomeCustomer.setOnClickListener(v -> {
                // Already on Home - do nothing or refresh
            });
        }

        if (tvShopCustomer != null) {
            tvShopCustomer.setOnClickListener(v -> navigateToActivity(ShopCustomer.class));
        }

        if (tvOrderCustomer != null) {
            tvOrderCustomer.setOnClickListener(v -> navigateToActivity(OrderCustomer.class));
        }

        if (tvChatCustomer != null) {
            tvChatCustomer.setOnClickListener(v -> navigateToActivity(ChatCustomer.class));
        }
    }

    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(ItemCustomer.this, targetActivity);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (tvHomeCustomer != null) {
            tvHomeCustomer.setTextColor(getResources().getColor(android.R.color.black));
        }
    }
}