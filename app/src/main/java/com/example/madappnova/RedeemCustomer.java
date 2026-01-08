package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RedeemCustomer extends AppCompatActivity {

    // Top Bar Views
    private ImageView menuIcon;

    // Bottom Navigation Views
    private TextView tvHomeCustomer;
    private TextView tvShopCustomer;
    private TextView tvOrderCustomer;
    private TextView tvChatCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redeem_customer);

        // Initialize views
        initializeViews();

        // Set up click listeners
        setupClickListeners();
    }

    private void initializeViews() {
        // Top Bar
        menuIcon = findViewById(R.id.menuIcon);

        // Bottom Navigation
        tvHomeCustomer = findViewById(R.id.tvHomeCustomer);
        tvShopCustomer = findViewById(R.id.tvShopCustomer);
        tvOrderCustomer = findViewById(R.id.tvOrderCustomer);
        tvChatCustomer = findViewById(R.id.tvChatCustomer);
    }

    private void setupClickListeners() {
        // Menu Icon Click
        if (menuIcon != null) {
            menuIcon.setOnClickListener(v -> Toast.makeText(RedeemCustomer.this, "Menu clicked", Toast.LENGTH_SHORT).show());
        }

        // Bottom nav (TextViews as buttons)
        if (tvHomeCustomer != null) {
            tvHomeCustomer.setOnClickListener(v -> navigateToActivity(ItemCustomer.class));
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
        Intent intent = new Intent(RedeemCustomer.this, targetActivity);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // You could highlight the Orders tab here since redemption usually comes from an order
        if (tvOrderCustomer != null) {
            tvOrderCustomer.setTextColor(getResources().getColor(android.R.color.black));
        }
    }
}
